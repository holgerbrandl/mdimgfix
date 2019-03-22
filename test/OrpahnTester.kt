import de.mpicbg.scicomp.kutils.div
import org.junit.Assert
import org.junit.Test
import java.io.File

class Tests{

    val TEST_DATA_ROOT = File("test_data")

    @Test
    fun resolveDuplicate(){

        with(createTestCopy()){
            main(arrayOf(absolutePath))

            println("tmp dir is $this")

            Assert.assertTrue(resolve(".bar_images/image.png").exists())
            Assert.assertFalse(resolve(".foo_images/image.png").exists())
        }
    }

    private fun createTestCopy(): File = createTempDir("md_img_fix_test_").apply {
        (TEST_DATA_ROOT / "img_moved").copyRecursively(this)
    }
}