FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

# We are overwriting the 'gpsd-xtrx' file typically provided by the main recipe
SRC_URI:append = " file://gpsd.xtrx"

# Ensure the file is installed correctly (Standard recipe usually handles this,
# but this ensures our version sticks if the logic varies)
do_install:append() {
    install -d ${D}${sysconfdir}/default
    install -m 0644 ${UNPACKDIR}/gpsd.xtrx ${D}${sysconfdir}/default/gpsd
}
