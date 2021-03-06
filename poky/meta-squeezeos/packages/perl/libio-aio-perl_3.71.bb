DESCRIPTION = "IO::AIO - Asynchronous Input/Output"
SECTION = "libs"
LICENSE = "Artistic|GPL"
PR = "r7"

# We want Perl to be as fast as possible, reset the default optimization flags
FULL_OPTIMIZATION = "-fexpensive-optimizations -fomit-frame-pointer -frename-registers -O2 -ggdb -feliminate-unused-debug-types"

SRC_URI = "http://backpan.perl.org/authors/id/M/ML/MLEHMANN/IO-AIO-${PV}.tar.gz \
	file://libio-aio-perl-config.h \
	file://libio-aio-perl-Makefile.PL.patch;patch=1"

S = "${WORKDIR}/IO-AIO-${PV}"

inherit cpan

FILES_${PN} = "${PERLLIBDIRS}/auto/IO/AIO/* \
               ${PERLLIBDIRS}"

cpan_do_configure_prepend () {
	cp ${WORKDIR}/libio-aio-perl-config.h ${S}/libeio/config.h	
}
