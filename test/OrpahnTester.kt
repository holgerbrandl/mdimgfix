import de.mpicbg.scicomp.kutils.div
import org.junit.Assert
import org.junit.Test
import java.io.File

class Tests{

    val TEST_DATA_ROOT = File("test_data")

    @Test
    fun resolveDuplicate(){

        with(createTestCopy("img_moved")){
//        with(File("C:\\Users\\brandl\\AppData\\Local\\Temp\\md_img_fix_test_2827320108353256509.tmp")){

            println("tmp dir is $this")

            main(arrayOf(absolutePath))

            Assert.assertTrue(resolve(".bar_images/image.png").exists())
            Assert.assertFalse(resolve(".foo_images/image.png").exists())
        }
    }
    @Test
    fun orphanImage(){

        with(createTestCopy("orphan_img")){
//        with(File("C:\\Users\\brandl\\AppData\\Local\\Temp\\md_img_fix_test_2827320108353256509.tmp")){

            println("tmp dir is $this")

            main(arrayOf(absolutePath,"foo.md"))

            Assert.assertFalse(resolve(".foo_images/image.png").exists())
        }
    }

    private fun createTestCopy(testDataName: String): File = createTempDir("md_img_fix_test_").apply {
        (TEST_DATA_ROOT / testDataName).copyRecursively(this)
    }
}