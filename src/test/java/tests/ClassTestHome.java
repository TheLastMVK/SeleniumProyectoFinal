package tests;

import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ClassTestHome extends ClassTestBase {

    @Test
    public void verifyTitle() {
        classPageHome.goToSingIn();
        classPageHome.goToRegisterOption();
        assertEquals("Create an account", classPageHome.isPageLoginDisplayed());
        System.out.println("El titulo pagina estimada es 'Create an account', Titulo pagina obtenida es: "+  classPageHome.isPageLoginDisplayed() );
    }
}