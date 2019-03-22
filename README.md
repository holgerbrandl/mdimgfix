## Fix Image References in Markdown Files


This little tools solves a couple of problems which occur when working with images and mardkown
* Image reference was moved to markdown file in same directory --> Fix: Move the image to `.<filename>_images`
* Image reference was duplicated in a markdown file in same directory --> Fix: duplicate the image to `.<other_filename>_images`
* Image reference was remove --> Fix: remove the orphan image

Checks a couple of markdown documents for the absence/presence of images files in a directory, and removes orphane images, that is images which are not referenced in the markdown documents.


# Installation

The tool required [kscript](https://github.com/holgerbrandl/kscript) to be installed.

```bash
export PATH=/Users/brandl/projects/kotlin/kutils/tools/orphan_images:$PATH

orphimg.kt --help

```

or use a url-cached copy

```bash
alias orphimg='kscript https://github.com/holgerbrandl/mdimgfix/blob/master/src/MdImgFix.kt'

orphimg --help
```
