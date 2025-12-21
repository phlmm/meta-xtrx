FILESEXTRAPATHS:prepend := "${THISDIR}/files:"
LICENSE = "GPL-2.0-or-later | LGPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://xtrx.c;beginline=6;endline=19;md5=d30115414b689d1f700e4266a814f075"
LIC_FILES_CHKSUM += "file://xtrx_defs.h;beginline=6;endline=18;md5=243ac67638dece785218eb67f678999c"

inherit module

PN = "kernel-module-xtrx"
PR = "r0"
PV = "1.0+git"

SRC_URI = "gitsm://github.com/xtrx-sdr/images.git;protocol=https;branch=master"
SRC_URI += "file://0001-Fix-Makefile.patch"
SRC_URI += "file://0001-Fixed-for-6.1-Arm64-compatibility.patch"

SRCREV = "e7c68fa621004ee0d6a65171c786fd9d5a1f2ce6"
S:append = "/sources/xtrx_linux_pcie_drv"

RPROVIDES_${PN} += "kernel-module-xtrx"
KERNEL_MODULE_AUTOLOAD:append = " xtrx"
