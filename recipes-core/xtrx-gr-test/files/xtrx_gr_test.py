#!/usr/bin/env python3
import time
from gnuradio import gr, blocks
from gnuradio import soapy

class HeadlessTest(gr.top_block):
    def __init__(self):
        gr.top_block.__init__(self, "XTRX Big Buffer Test")

        # 1. Source: Native Soapy (sc16)
        # We stick with sc16 (Short) to avoid CPU conversion overhead.
        self.source = soapy.source("driver=xtrx", "sc16", 1, "", "", [""], [""])
        
        # 2. CRITICAL FIX: The "Big Landing Zone" Strategy
        # Previous crash was caused by the buffer being too tight (exact packet size).
        # We force a MINIMUM buffer of 1 Million samples (~4MB).
        # This gives the DMA engine plenty of room to write without hitting a wall.
        huge_buffer = 1048576 # 1024 * 1024 samples
        self.source.set_min_output_buffer(huge_buffer)
        
        # We do NOT set a max buffer. Let GNU Radio manage the upper limit.

        # 3. Settings
        self.source.set_sample_rate(0, 2e6) # 2 MS/s
        self.source.set_frequency(0, 2.4e9)
        self.source.set_gain(0, 30)

        # 4. Sink: Null Sink (Short/Int16)
        # 4 bytes per item
        self.sink = blocks.null_sink(4) 

        self.connect(self.source, self.sink)

def main():
    print("[-] Initializing XTRX (Big Buffer Mode)...")
    try:
        tb = HeadlessTest()
    except Exception as e:
        print(f"[!] Block Init Failed: {e}")
        return

    print("[-] Starting Stream...")
    tb.start()
    
    try:
        # Run for 15 seconds to prove stability
        for i in range(15):
            print(f"    Running... {i+1}/15")
            time.sleep(1)
    except KeyboardInterrupt:
        pass
    finally:
        print("[-] Stopping...")
        tb.stop()
        tb.wait()
        print("[-] Done.")

if __name__ == '__main__':
    main()
