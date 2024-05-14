import { Given, When, Then, Before, After } from "@cucumber/cucumber";
import assert from "assert";

import initDriver from "../../configs/driver.js";
import HomePage from "../../pages/home.js"; 
import CreatePage from "../../pages/create.js";

let driver;
let homePage; 
let createPage;

Before({ timeout: 6000 * 10000 }, async () => { 
    try {
        driver = await initDriver();
        homePage = new HomePage(driver); 
        createPage = new CreatePage(driver);
    } catch (error) {
        console.error(error);
    }
});

When('I tap plus button', async() => {
    await homePage.tapPlusButton();
});

Then('I insert valid name product', async () => {
    const title = "bayam";
    await createPage.insertName(title);
});

Then('I insert valid quantity', async() => {
    const quantity = 2;
    await createPage.insertQuantity(quantity);
});

Then('I choose vegetables', async() => {
    await createPage.chooseVegetables();
});

Then('I tap add item button', async () => {
    await createPage.tapAddItem();
});

Then('I tap reset button', async() => {
    await createPage.tapResetButton();
});

Then('the inputs are reset', async() => {
    const createPageItemTitle = await createPage.createPageTitle();
    assert.equal(createPageItemTitle, "Add a new item");
});

Then('I redirected to the home page',{ timeout: 6000 * 10000 }, async() => {
    const pageTitle = await homePage.getTitle();
    assert.equal(pageTitle, "Your Groceries");
});

Then('I choose fruit', async() => {
    await createPage.chooseFruit();
});

Then('I choose meat', async() => {
    await createPage.chooseMeat();
});

Then('I choose dairy', async() => {
    await createPage.chooseDairy();
});

Then('I choose carbs', async() => {
    await createPage.chooseCarbs();
});

Then('I choose sweets', async() => {
    await createPage.chooseSweets();
});

Then('I choose spices', async() => {
    await createPage.chooseSpices();
});

Then('I choose convenience', async() => {
    await createPage.chooseConvenience();
});

Then('I choose hygiene', async() => {
    await createPage.chooseHygiene();
});

Then('I insert invalid quantity', async() => {
    const quantity = 0;
    await createPage.insertQuantity(quantity);
})

Then('error message is shown about empty name', async() => {
    const errorMessageEmptyNameItem = await createPage.errorMessageEmptyName();
    assert.equal(errorMessageEmptyNameItem, "Must be between 1 and 50 characters.");
})

Then('error message is shown about zero quantity', async() => {
    const errorZeroQuantity = await createPage.errorMessageNoQuantity();
    assert.equal(errorZeroQuantity, "Must be a valid positive number.");
})

After(async () => {
    await driver.deleteSession();
});