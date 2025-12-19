SUMMARY = "SoapySDR project"

DESCRIPTION = "A fresh and clean vendor neutral and platform independent SDR \
support library."

HOMEPAGE = "https://github.com/pothosware/SoapySDR/wiki"

LICENSE = "BSL-1.0 & MIT & Python-2.0"
LIC_FILES_CHKSUM = "file://LICENSE_1_0.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRCREV = "db0fae7c8a98462ee2b2493f08d633987e4b6fae"
SRC_URI = "git://github.com/pothosware/SoapySDR.git;protocol=https;branch=master \
          "

DEPENDS += "swig-native"
inherit cmake pkgconfig python3native
FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/SoapySDR*"
FILES:${PN} += "${PYTHON_SITEPACKAGES_DIR}/_SoapySDR*"
