import { test, expect } from '@playwright/test';

/**
 * aj@AJs-MacBook-Pro 6.0.1-swiftkickandcopartner-boost % pwd
/Users/aj/Documents/Project-Workspace/L0gN3/6-testing/6.0-automation/6.0.1-swiftkickandcopartner-boost
 * aj@AJs-MacBook-Pro 6.0.1-swiftkickandcopartner-boost % npx playwright test tests/autoboost.spec.ts --project=chromium
 */

test('auto boost clicker', async ({ page }) => {

  test.setTimeout(60000); // if timeout exceeds, it means that  - "Your account balance is not enough, Insufficient balance: 56.22"
  // test.setTimeout(120_000); 

  await page.goto('https://swiftkick-marketing.top/boost');

  await page
    .getByPlaceholder('Phone Number')
    // .fill('2016832282');
    .fill('4379893228');

  await page
    .getByPlaceholder('Password')
    // .fill('123123');
    .fill('YgTHbyffJ53jvaY');

  await page.locator(
    '//*[@id="root"]/div/div/div/div/div/div/div[1]/div/div[4]/div/div'
  ).click();

  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div/div[2]/div/div[1]/div'
  ).click();

  // TODO: aj - this is where the loop in, each page has to wait to load, conditions will be if there is an existing xpath.

  // 1
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 2
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 3
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 4
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 5
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 7
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 8
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();

  test.setTimeout(120_000);

  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 9
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 10
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 11
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 12
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 13
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 14
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 15
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 16
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();


  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 17
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();

  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 18
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();

  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  ).click();

  // 19
  await page.locator(
    '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  ).click();

  // await page.locator(
  //   '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  // ).click();

  // // 20
  // await page.locator(
  //   '//*[@id="root"]/div/div/div[3]/div/div/div[2]/div[1]/div[2]/div[3]'
  // ).click();

  // await page.locator(
  //   '//*[@id="root"]/div/div/div[3]/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div'
  // ).click();

  /**
   * 38 divided by 2 equals 19
   * 41 divided by 2 equals 20.5 - Alright, I deposited 800 and upgraded to VIP 1. The platform gave me a 100 bonus after that. I was worried I wouldn’t get a lucky package today, so my commission might be lower The number of orders has increased from 38 to 41, and the commission rate has gone up to 1.5%. So today I need your help to complete 3 more orders!
   */

});