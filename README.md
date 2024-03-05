C.  Customize the HTML user interface for your customer’s application. The user interface should include the shop name, the product names, and the names
of the parts.

| Commit # | change                                     | file                                                        | line #               |
|----------|--------------------------------------------|-------------------------------------------------------------|----------------------|
| 6bc13243 | changed button formatting                  | src/main/resources/templates/mainscreen.html                | 17,19,20,27,29,59,61 |
| 8e5b4a47 | Changed references of Bike Shop to PC shop | src/main/resources/templates/mainscreen.html                | 14,19                |
| 8e5b4a47 | changed names of parts and products        | src/main/java/com/example/demo/bootstrap/BootStrapData.java | 48-95                |
| 8e5b4a47 | changed about page and shop name           | src/main/resources/static/about.html                        | 15,27,29             |
| 8e5b4a47 | changed shop name                          | src/main/resources/templates/confirmationPurchase.html      | 14                   |
| 8e5b4a47 | changed shop name                          | src/main/resources/templates/confirmationdeleteproduct.html | 14                   |


D.  Add an 'About' page to the application to describe your chosen customer’s company to web viewers and include navigation to and from the “About” page and the main screen.

| Commit # | change                     | file                                         | line #                                |
|----------|----------------------------|----------------------------------------------|---------------------------------------|
| 093403b1 | added about link on navbar | src/main/resources/templates/mainscreen.html | 17-28,30,74-75,77,79-80,86-87,104-105 |
| 20aedd64 | added about page           | src/main/resources/static/about.html         | 1-35                                |
| 20aedd64 | added about page           | src/main/resources/templates/mainscreen.html | 23                                    |


E.  Add a sample inventory appropriate for your chosen store to the application. You should have five parts and five products in your sample inventory and should not overwrite existing data in the database.

| Commit # | change                                                 | file                                                        | line #            |
|----------|:-------------------------------------------------------|-------------------------------------------------------------|-------------------|
| b0756a86 | Added 5 products and 5 parts and constructors for each | src/main/java/com/example/demo/bootstrap/BootStrapData.java | 45-72,80-82,85-88 |
| b0756a86 | Added 5 products and 5 parts and constructors for each | src/main/java/com/example/demo/domain/InhousePart.java      | 20-25             |
| b0756a86 | Added 5 products and 5 parts and constructors for each | src/main/java/com/example/demo/domain/OutsourcedPart.java   | 25-28             |



F.  Add a “Buy Now” button to your product list. Your “Buy Now” button must meet each of the following parameters:

| Commit # | change                                               | file                                                                 | line #  |
|----------|------------------------------------------------------|----------------------------------------------------------------------|---------|
| 805233ed | added buy now button                                 | src/main/resources/templates/mainscreen.html                         | 113-114 |
| 594355e1 | added buy now mapping and confirmation purchase.html | src/main/java/com/example/demo/controllers/AddProductController.java | 133-145 |
| 594355e1 | added buy now mapping and confirmation purchase.html | src/main/resources/templates/confirmationPurchase.html               | 1-22    |



G. Modify the parts to track maximum and minimum inventory by doing the following:

| Commit # | change                                                                                          | file                                                      | line #                |
|----------|-------------------------------------------------------------------------------------------------|-----------------------------------------------------------|-----------------------|
| 570a5e3c | added rows in table for min and max inventory                                                   | src/main/resources/templates/mainscreen.html              | 52-53,62-63           |
| 26752c6b | added minInventory and maxInventory fields and created constructors                             | src/main/java/com/example/demo/domain/OutsourcedPart.java | 20-28                 |
| 26752c6b | added minInventory and maxInventory fields and created constructors                             | src/main/java/com/example/demo/domain/Part.java           | 62-69,128-135,146-150 |
| c961a949 | Added min/max to the InhousePartForm and OutsourcedPartForm                                     | src/main/resources/templates/InhousePartForm.html         | 26-28                 |
| c961a949 | Added min/max to the InhousePartForm and OutsourcedPartForm                                     | src/main/resources/templates/OutsourcedPartForm.html      | 27-30                 |
| 9ba632fc | Modified the code to enforce that the inventory is between or at the minimum and maximum value. | src/main/java/com/example/demo/domain/Part.java           | 37,39                 |
	



H. Add validation for between or at the maximum and minimum fields. The validation must include the following:

| Commit # | change                                                                                                                                                    | file                                                                           | line # |
|----------|-----------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------|--------|
| 3daae636 | Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum or greater than the max number of parts | src/main/java/com/example/demo/controllers/AddOutsourcedPartController.java    | 41-52  |
| 3daae636 | Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum or greater than the max number of parts | src/main/java/com/example/demo/domain/Part.java                                | 24     |
| 3daae636 | Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum or greater than the max number of parts | src/main/java/com/example/demo/validators/MinMaxPartInventory.java             | 1-47   |
| 3daae636 | Display error messages for low inventory when adding and updating parts if the inventory is less than the minimum or greater than the max number of parts | src/main/java/com/example/demo/validators/ValidMinMaxPartInventory.java        | 1-23   |
| 31ea99e2 | Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.                                   | src/main/java/com/example/demo/validators/MinMaxProductInventoryValidator.java | 1-44   |
| 31ea99e2 | Display error messages for low inventory when adding and updating products lowers the part inventory below the minimum.                                   | src/main/java/com/example/demo/validators/ValidMinMaxInv.java                  | 1-24   |




I.	Add at least two unit tests for the maximum and minimum fields to the PartTest class in the test package.

| Commit # | change               | file                                                | line #  |
|----------|----------------------|-----------------------------------------------------|---------|
| 318731bf | added two unit tests | src/main/java/com/example/demo/domain/Product.java  | 23      |
| 318731bf | added two unit tests | src/test/java/com/example/demo/domain/PartTest.java | 159-176 |
	

J.  Remove the class files for any unused validators in order to clean your code.

| Commit # | change                      | file                                                               | line #     |
|----------|-----------------------------|--------------------------------------------------------------------|------------|
| 7b3a9dc6 | Removed deletepartvalidator | src/main/java/com/example/demo/domain/Part.java                    | 3,20       |
| 7b3a9dc6 | Removed deletepartvalidator | src/main/java/com/example/demo/validators/DeletePartValidator.java | whole file |
| 7b3a9dc6 | Removed deletepartvalidator | src/main/java/com/example/demo/validators/ValidDeletePart.java     | whole file |


