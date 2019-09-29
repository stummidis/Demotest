*** Settings ***
Library SeleniumLibrary



*** Variables ***
${URL}  https://www.amazon.com
${Browser}  Chrome
${givenText}  Nicon D3X



*** Keywords ***
 Start Browser and Maximize
  Open Browser ${URL}  ${Browser}
   Maximize Browser Window


Close Browser Window
    ${Title}=  Get Title
    Log  ${Title}
    Close Browser