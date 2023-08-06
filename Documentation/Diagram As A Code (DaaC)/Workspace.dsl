workspace {
   
   model {
      user = person "Customer" "End Users who interact with the system , browse and purchase products." "Customer"
      
      group "E-Commerce Application" {
         backoffice = person "Back Office Staff" "Administration and support staff within the e-commerce application." "Internal"
         notificationSystem = softwareSystem "Notification System" "Internal Microsoft Exchange Email System, Twillo SMS System" "External"
         authSystem = softwareSystem "Authentication Notification System" "External Authentication System like SAML" "External"
         paymentSystem = softwareSystem "Payment System" "BillDesk Payment system" "External"
         deliverySystem = softwareSystem "Delivery System" "Xpressbess delivery to deliver the shipment" "External"
         inventorySystem = softwareSystem "Mainframe Inventory System" "Stores the all the product inventory" "External"
         ecommerceApplication = softwareSystem "E-Commerce System" "Represents the main system , which would provide the ecommerce functionality." {
            singlePageApplication = container "Single-Page Application" "Provides all of the e-commerce functionality to customers via their web browser." "Angular 16" "Web Browser"
            apiApplication = container "API Application" "Provides E-Commerce functionality via a JSON/HTTPS API." "Java Springboot" {
               signinController = component "Sign In Controller" "Allows users to sign in to the E-Commerce System." "Java Springboot Controller"
               registerController = component "Register Controller" "Allows users to sign up to the E-Commerce System." "Java Springboot Controller"
               userController = component "User Controller" "Allows users to store the shipment address." "Java Springboot Controller"
               searchProductController = component "Search Product Controller" "Allows users to search any product." "Java Springboot Controller"
               categoryController = component "Category Controller" "Allows users to search products by category." "Java Springboot Controller"
               paymentController = component "Payment Controller" "Allows users for the payment." "Java Springboot Controller"
               cartController = component "Cart Controller" "Allows users to search by category." "Java Springboot Controller"
               notificationController = component "Notification Controller" "It will help to notify an user for any process." "Java Springboot Controller"
               inventoryController = component "Inventory Controller" "It will help to get the inventory list from an external warehouse application." "Java Springboot Controller"
               orderController = component "Order Controller" "It will help to place an order and process for shipment." "Java Springboot Controller"
            }
            database = container "Database" "Stores user's information, product details, inventory, authentication credentials, access logs, etc." "MySQL Server" "Database"
         }
      }
      
      user -> ecommerceApplication "Search and select products from a list of products under catagory, add products in cart, capturing delivery address and payment details."
      user -> authSystem "Customer authorized throug an external authentication."
      ecommerceApplication -> notificationSystem "Sends the required email or sms to send to the customer"
      ecommerceApplication -> deliverySystem "Places shipment order to delivery"
      ecommerceApplication -> inventorySystem "Get the product details and their quantity details."
      ecommerceApplication -> paymentSystem "Process for the payment"
      ecommerceApplication -> authSystem "Authorized a customer"
      notificationSystem -> user "Sends the email or sms to the customer"
      deliverySystem -> user "Shipping the products from the warehouse to customer address"
      paymentSystem -> user "Chooses different payment methods and pay the amount"
      backoffice -> inventorySystem "Uses"
      singlePageApplication -> signinController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> searchProductController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> categoryController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> paymentController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> userController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> cartController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> notificationController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> inventoryController "Makes API calls to" "JSON/HTTPS"
      singlePageApplication -> orderController "Makes API calls to" "JSON/HTTPS"
      user -> singlePageApplication "Search products, add to cart, place order"
      signinController -> database "Reads from and writes to" "SQL/TCP"
      
      deploymentEnvironment "Development" {
         deploymentNode "Dev Server" "" "Microsoft Windows Server 2019" {
            deploymentNode "IIS" "" "Microsoft IIS" {
               d1 = containerInstance singlePageApplication
               d2 = containerInstance apiApplication
            }
            deploymentNode "Database Server" "" "Microsoft SQL Server 2019" {
               d3 = containerInstance database
            }
         }
         
      }
      deploymentEnvironment "Production" {
         deploymentNode "ecommerce-web***" "" "Ubuntu 16.04 LTS" {
            deploymentNode "NGNIX" "" "NGNIX Web Application Server" {
               d4 = containerInstance singlePageApplication
            }
         }
         deploymentNode "ecommerce-api***" "" "Microsoft Windows Server 2019" {
            deploymentNode "IIS" "" "Microsoft IIS" {
               d5 = containerInstance apiApplication
            }
         }
         deploymentNode "ecommerce-db01***" "" "Microsoft Windows Server 2019" {
            db1 = deploymentNode "Database Primary Server" "" "Microsoft SQL Server 2019" {
               d6 = containerInstance database
            }
         }
         deploymentNode "ecommerce-db02***" "" "Microsoft Windows Server 2019" "Failover" {
            db2 = deploymentNode "Database Secondary Server" "" "Microsoft SQL Server 2019" {
               d7 = containerInstance database "Failover"
            }
         }
         db1 -> db2 "Replicates data to"
      }
   }
   
   views {
      systemlandscape "SystemLandscape" {
         include *
         autoLayout lr 300 20
      }
      systemContext ecommerceApplication "SystemContext" {
         include *
         autoLayout lr 300 20
         description "The system context diagram for the E-Commerce Application System."
         properties {
            structurizr.groups false
         }
      }
      container ecommerceApplication "Containers" {
         include *
         autoLayout lr 300 20
         description "The container diagram for the E-Commerce Application System."
      }
      component apiApplication "Components" {
         include *
         autoLayout lr 300 20
         description "The component diagram for the API Application."
      }
      deployment ecommerceApplication "Development" "DevelopmentDeployment" {
         include *
         autoLayout
         description "An example Development deployment scenario for the E-Commerce Application System."
      }
      deployment ecommerceApplication "Production" "ProductionDeployment" {
         include *
         autoLayout
         description "An example Production deployment scenario for the E-Commerce Application System."
      }
      
      styles {
         element "Person" {
            color #ffffff
            fontSize 22
            shape Person
         }
         element "Customer" {
            background #08427b
         }
         element "Software System" {
            background #1168bd
            color #ffffff
         }
         element "External" {
            background #999999
            color #ffffff
         }
         element "Internal" {
            background #999999
            color #ffffff
         }
         element "Container" {
            background #438dd5
            color #ffffff
            shape RoundedBox
         }
         element "Database" {
            shape Cylinder
         }
         element "Component" {
            background #85bbf0
            color #000000
            shape RoundedBox
         }
         element "Failover" {
            opacity 25
         }
      }
   }
   
   
}
