package steps;

import static org.junit.Assert.assertEquals;

import java.util.UUID;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import entities.User;
import helpers.BaseTest;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import pages.Book;
import pages.Login;
import pages.PageBookStore;
import pages.Profile;
import pages.Register;

public class BookStore {
	private WebDriver driver = BaseTest.getDriver();
	private Profile profile  = new Profile(driver);
	private PageBookStore bookStore = new PageBookStore(driver);
	private Book bookPage = new Book(driver);
	
	private entities.Book book = new entities.Book ("9781449325862", "Git Pocket Guide", "A Working Introduction", "Richard E. Silverman", 
			"O'Reilly Media", 234, "This pocket guide is the perfect on-the-job companion to Git, the distributed version control system. "
			+ "It provides a compact, readable introduction to Git for new users, as well as a reference to common commands and procedures for those of you with Git exp");
	
	@After
	public void tearDown() {
		profile.deleteBookButton();
		profile.deleteBookOKButton();
	}
	
	@Quando("no campo de pesquisa, busco pelo livro {string}")
	public void noCampoDePesquisaBuscoPeloLivro(String string) {
		bookStore.searchBoxField(book.getTitle());
		bookStore.searchButton();
	}
	@Quando("clico no livro pesquisado")
	public void clicoNoLivroPesquisado() {
		WebElement link = driver.findElement(By.linkText(book.getTitle()));
		link.click();
	}
	@Quando("clico no botão Book Store")
	public void clicoNoBotãoBookStore() {
	    profile.goToStoreButton();
	}
	@Quando("E clico no botão Add To Your Collection")
	public void clicoNoBotãoAddToYourCollection() {
		WebElement link = driver.findElement(By.linkText("Add To Your Collection"));
		link.click();
	}
	@Quando("clico no botão Profile")
	public void clicoNoBotãoProfile() {
		WebElement link = driver.findElement(By.linkText("Profile"));
		link.click();
	}
	@Quando("valido os campos isbn e author")
	public void validoOsCamposIsbnEAuthor() {
		bookPage.validateIsbnValue(book.getIsbn());
		bookPage.validateAuthorValue(book.getAuthor());
	}
	@Então("visualizo o livro que foi selecionado")
	public void visualizoOLivroQueFoiSelecionado() {
		WebElement text = driver.findElement(By.className(".mr-2 a"));
		assertEquals(text, book.getTitle());
	}
}
