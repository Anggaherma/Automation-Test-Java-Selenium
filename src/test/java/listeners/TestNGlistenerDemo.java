package listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(listeners.testNGListeners.class)
public class TestNGlistenerDemo {
	
	@Test(groups = {"sanity"})
	public void test1() {
		System.out.println("This is Test 1");
	}
	
	@Test(groups = {"sanity", "smoke"})
	public void test2() {
		System.out.println("This is Test 2");
		Assert.assertTrue(true);
	}

	@Test(groups = {"regression"})
	public void test3() {
		System.out.println("This is Test 3");
	}

	@Test
	public void test4() {
		System.out.println("This is Test 4");
	}


}
