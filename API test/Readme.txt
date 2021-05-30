https://orangehrm.github.io/orangehrm-api-doc/

newman run OrangeHRM.postman_collection.json -e OrangeHRM.postman_collection.json -r htmlextra --reporters cli,junit,htmlextra --reporter-htmlextra-export API_Report_OrangeHRM.html