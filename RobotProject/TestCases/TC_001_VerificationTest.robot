***Setting****
Library SeleniumLibrary
Resource  ../Resources/Resources1.robot

**** Variables***
${HomePage}  ${URL}
${SearchBar}  id:twotabsearchtextbox
${searchButton}  xpath://*[@id='nav-search']/form/div[2]/div
${sortButton}  //*[@id='a-autoid-0-announce']
${high_low}  id:s-result-sort-select_2
${secouneLink}

${SHORTCUTS} =  dom=document.getElementsByClassName("shortcuts")[0].childNodes

*** Test Case*****
Selenium Test Case
    Open HomePage
    Maximize Browser Window
    Search required Text
    Select sort by high to low
    Select secound product
    Assert warning



*** Keywords *****
Search required Text
    Input SearchBar  Nikon
    Click searchButton

Select sort by high to low
    click searchButton
    click high_low

Select secound product
    click secouneLink


Assert warning
    Element contain  //*[@class='a-link-normal a-text-normal']  ${givenText}

