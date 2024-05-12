import BasePage from "./base.js";

export default class CreateItemPage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async insertName(title) {
        const itemNameElement = '//android.widget.EditText[@text="Name"]';
        await this.click(itemNameElement);
        await this.type(itemNameElement, title);
    }

    async insertQuantity(quantity) {
        const itemQuantityElement = '//android.widget.EditText[@text="1, Quantity"]';
        await this.click(itemQuantityElement);
        await this.type(itemQuantityElement, quantity);
    }

    async chooseVegetables() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Vegetables"]');
    }

    async chooseFruit() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Fruit"]');
    }

    async chooseMeat() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Meat"]');
    }

    async chooseDairy() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Dairy"]');
    }

    async chooseCarbs() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Carbs"]');
    }
    
    async chooseSweets() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Sweets"]');
    }

    async chooseSpices() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Spices"]');
    }

    async chooseConvenience() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Convenience"]');
    }

    async chooseHygiene() {
        await this.click('//android.widget.Button[@content-desc="Vegetables"]');
        await this.click('//android.view.View[@content-desc="Hygiene"]');
    }

    async tapAddItem() {
        await this.click('//android.widget.Button[@content-desc="Add Item"]');
    }

    async tapResetButton() {
        await this.click('//android.widget.Button[@content-desc="Reset"]');
    }

    async createPageTitle() {
        const createPageTitleComponent = await this.find(
            '//android.view.View[@content-desc="Add a new item"]'
        );

        const title = await createPageTitleComponent.getAttribute("content-desc");
        return title;
    }

    async errorMessageEmptyName() {
        const errorEmptyNameComponent = await this.find('//android.view.View[@content-desc="Must be between 1 and 50 characters."]');
        
        const errorEmptyName = await errorEmptyNameComponent.getAttribute("content-desc");
        return errorEmptyName;
    }

    async errorMessageNoQuantity() {
        const errorMessageNoQuantityComponent = await this.find('//android.view.View[@content-desc="Must be a valid positive number."]');

        const errorNoQuantity = await errorMessageNoQuantityComponent.getAttribute("content-desc");
        return errorNoQuantity;
    }
    

}