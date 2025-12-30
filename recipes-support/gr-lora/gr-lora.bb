SUMMARY = "This is the fully-functional GNU Radio software-defined radio (SDR) implementation of a LoRa transceiver with all the necessary receiver components to operate correctly even at very low SNRs. This work has been conducted at the Telecommunication Circuits Laboratory, EPFL"
HOMEPAGE = "https://github.com/rpp0/gr-lora.git"
LICENSE = "GPL-3.0-only"
LIC_FILES_CHKSUM = "file://CMakeLists.txt;md5=f8ba9521e29f98b58a797652fc8fc985"
DEPENDS += "liquiddsp"
RDEPENDS:${PN} = "gnuradio python3-click"

inherit gnuradio-oot

PV = "1.0.0+git${SRCPV}"

SRC_URI = "git://github.com/rpp0/gr-lora.git;branch=master;protocol=https \
          "
SRCREV = "90343d45a3c73c84d32d74b8603b6c01de025b08"

FILES:${PN} += "${datadir}/gr-lora/examples/*.grc"
