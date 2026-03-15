SUMMARY = "GNU Radio LoRa transceiver implementation"
HOMEPAGE = "https://github.com/rpp0/gr-lora"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=f8ba9521e29f98b58a797652fc8fc985"

# Build-time dependencies
DEPENDS += "gnuradio liquiddsp volk python3-pybind11-native python3-pygccxml-native log4cpp"

# Runtime dependencies
RDEPENDS:${PN} += "gnuradio python3-click gr-lora"

inherit gnuradio-oot

PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/rpp0/gr-lora.git;branch=master;protocol=https"
SRCREV = "90343d45a3c73c84d32d74b8603b6c01de025b08"

# MAIN PACKAGE: Notice the dot before the asterisk in .so.*
# This ensures it ONLY grabs the versioned libraries (.so.1.0.0, etc.)
FILES:${PN} += " \
    ${libdir}/libgnuradio-lora.so.* \
    ${libdir}/python${PYTHON_BASEVERSION}/site-packages/lora/* \
    ${datadir}/gnuradio/grc/blocks/* \
"

# DEV PACKAGE: Explicitly grab only the base .so symlink and dev files
FILES:${PN}-dev += " \
    ${libdir}/libgnuradio-lora.so \
    ${includedir} \
    ${libdir}/cmake \
"

do_install:append() {
    # Ensure the target directory exists
    install -d ${D}${libdir}

    # Use 'cp -d' to preserve the symlink structure between .so and .so.1.0.0
    cp -d ${B}/lib/libgnuradio-lora.so* ${D}${libdir}/
}
