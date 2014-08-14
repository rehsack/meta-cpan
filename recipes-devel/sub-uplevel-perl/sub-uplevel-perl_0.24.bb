DESCRIPTION = "Like Tcl's uplevel() function, but not quite so dangerous. The idea is \
just to fool caller(). All the really naughty bits of Tcl's uplevel() \
are \
avoided."

SECTION = "libs"
LICENSE = "Artistic-1.0 | GPL-2.0"
PR = "r0"

MAINTAINER=	"Poky <poky@yoctoproject.org>"
HOMEPAGE=	"https://metacpan.org/release/Sub-Uplevel"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/Artistic-1.0;md5=cda03bbdc3c1951996392b872397b798 \
file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "http://cpan.metacpan.org/authors/id/D/DA/DAGOLDEN/Sub-Uplevel-0.24.tar.gz"

SRC_URI[md5sum] = "bea4037e8b2a0df563e25e6e44cb2e73"
SRC_URI[sha256sum] = "0f93f6e9c80b8dcb22c60d0e9df2c2c6d7db10d4d37151f1dfea6e54a3c6fdfb"

S = "${WORKDIR}/Sub-Uplevel-${PV}"

inherit cpan

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/${base_libdir}/ -name 'libc-*.so')"
	cpan_do_compile
}

BBCLASSEXTEND = "native"
