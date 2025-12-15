FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "LGPL-2.1-or-later"
LIC_FILES_CHKSUM = "file://liblms7002m/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://libusb3380/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://libxtrx/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://libxtrxdsp/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742 \
                    file://libxtrxll/LICENSE;md5=1803fa9c2c3ce8cb06b4861d75310742 \
"

SRC_URI = "gitsm://github.com/xtrx-sdr/images.git;protocol=https;branch=master"
SRC_URI += "file://0001-Add-version-to-lms7compact.patch"
PACKAGES += "${PN}-mod-src"
# Modify these as desired
PV = "1.0+git"
SRCREV = "e7c68fa621004ee0d6a65171c786fd9d5a1f2ce6"
S:append = "/sources/"

DEPENDS += "libusb python3-cheetah-native soapysdr"
inherit cmake python3native

EXTRA_OECMAKE += "-DCMAKE_POLICY_VERSION_MINIMUM=3.5 -DENABLE_USB3380=0 -DENABLE_SOAPY=1"

FILES:${PN} += "${libdir}/" 
FILES:${PN}-mod-src = "/usr/src/*" 
