import BasePage from "./base.js";

export default class homePage extends BasePage {
    constructor(driver) {
        super(driver);
    }

    async getTitle(){
        const titleComponent = await this.find(
            '//android.view.View[@content-desc="Your Groceries"]'
        );

        const title = await titleComponent.getAttribute("content-desc");
        return title;
    }

    async getSampleData() {
        await this.find(
            `//android.widget.FrameLayout[@resource-id="android:id/content"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]`);
    }

    async tapPlusButton() {
        await this.click('//android.widget.Button');
        }

}