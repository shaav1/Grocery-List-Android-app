# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: Team 2

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

One assumption we make of the User is that he/she knows how to navigate the application. Another would be that he/she knows the product and/or product types of which they would like to put in the List.

### 1.2 Constraints

The only significant constraint is if the users system is up to date .

### 1.3 System Environment

The application is an Android Application, therefore the User would need an Android device to access and use the application. The Users Android device must also be up to date with our API level.

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

In our design diagram we have four classes; User, GroceryList, Item, ItemType. The User class allows the user to add, delete and edit their different grocery lists. The GroceryList class allows the user to add, delete, search, and save their grocery list. The class Item implements ItemType which are individual products the user can add to their list.

### 2.2 Deployment Diagram

The application has a simple system because it does not use external resources, it only works locally on the users device.

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram

![](https://tva1.sinaimg.cn/large/008eGmZEly1gp05s72tcmj315y0u0dit.jpg)

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

## 4 User Interface Design (*needs updating)
*For GUI-based systems, this section should provide the specific format/layout of the user interface of the system (e.g., in the form of graphical mockups).*

