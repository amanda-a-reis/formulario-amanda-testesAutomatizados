import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Testes {

    @Test
    public void testInputNome() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");
        driver.findElement(By.id("nome")).sendKeys("Teste de Input");
        Assert.assertEquals(driver.findElement(By.id("nome")).getAttribute("value"),"Teste de Input" );

        driver.quit();
    }

    @Test
    public void testTextareaObservacoes() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");
        driver.findElement(By.id("msg")).sendKeys("Teste Textarea");
        Assert.assertEquals(driver.findElement(By.id("msg")).getAttribute("value"),"Teste Textarea" );

        driver.quit();
    }

    @Test
    public void testCheckBox() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");
        driver.findElement(By.id("checkbox1")).click();
        Assert.assertTrue(driver.findElement(By.id("checkbox1")).isSelected());

        driver.findElement(By.id("checkbox2")).click();
        Assert.assertTrue(driver.findElement(By.id("checkbox2")).isSelected());

        driver.findElement(By.id("checkbox3")).click();
        Assert.assertTrue(driver.findElement(By.id("checkbox3")).isSelected());

        driver.quit();
    }

    @Test
    public void testNumeroDeAdesivosAdicionaESubtrai() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");
        driver.findElement(By.id("btn-adc")).click();
        driver.findElement(By.id("btn-adc")).click();
        WebElement valor = driver.findElement(By.id("valor"));

        Assert.assertEquals(valor.getAttribute("value"), "2");

        driver.findElement(By.id("btn-diminui")).click();

        Assert.assertEquals(valor.getAttribute("value"), "1");
        driver.quit();
    }


    @Test
    public void testCadastro() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");

        driver.findElement(By.id("nome")).sendKeys("Amanda Reis");
        driver.findElement(By.id("msg")).sendKeys("Teste Textarea Submit");
        driver.findElement(By.id("checkbox1")).click();
        driver.findElement(By.id("btn-adc")).click();
        driver.findElement(By.linkText("Enviar")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://amanda-a-reis.github.io/formulario-amanda/pages/confirm.html" );

        driver.quit();
    }

    @Test
    public void falhaSeNaoTemNome() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");

        driver.findElement(By.id("nome")).sendKeys("Amanda Reis");
        driver.findElement(By.linkText("Enviar")).click();
        WebElement mensagem = driver.findElement(By.id("form_invalido"));

        Assert.assertEquals(mensagem.getText(),"Favor fornecer todos os dados!");

        driver.quit();
    }
    @Test
    public void falhaSeNaoTemCheck() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");

        driver.findElement(By.id("nome")).sendKeys("Amanda Reis");
        driver.findElement(By.id("btn-adc")).click();

        driver.findElement(By.linkText("Enviar")).click();
        WebElement mensagem = driver.findElement(By.id("form_invalido"));

        Assert.assertEquals(mensagem.getText(),"Favor fornecer todos os dados!");

        driver.quit();
    }

    @Test
    public void falhaSeNaoTemQuantidade() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");

        driver.findElement(By.id("nome")).sendKeys("Amanda Reis");
        driver.findElement(By.id("checkbox1")).click();

        driver.findElement(By.linkText("Enviar")).click();
        WebElement mensagem = driver.findElement(By.id("form_invalido"));

        Assert.assertEquals(mensagem.getText(),"Favor fornecer todos os dados!");

        driver.quit();
    }

    @Test
    public void falhaSeNaoTemCamposObrigatorios() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/");

        driver.findElement(By.linkText("Enviar")).click();
        WebElement mensagem = driver.findElement(By.id("form_invalido"));

        Assert.assertEquals(mensagem.getText(),"Favor fornecer todos os dados!");

        driver.quit();
    }

    @Test
    public void testeNovoPedido() {

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\User\\Documents\\Gecko-Driver\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("https://amanda-a-reis.github.io/formulario-amanda/pages/confirm.html");

        driver.findElement(By.linkText("Novo Pedido")).click();

        String URL = driver.getCurrentUrl();
        Assert.assertEquals(URL, "https://amanda-a-reis.github.io/formulario-amanda/index.html" );

        driver.quit();
    }



}
