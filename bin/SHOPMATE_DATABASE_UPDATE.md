# ShopMate Database Update

The project now uses relational JPA mappings:

- Customer 1:1 Cart
- Customer 1:N Orders
- Category 1:N Product
- Cart 1:N CartItem
- Product 1:N CartItem
- Orders 1:N OrderItem
- Product 1:N OrderItem

## Important
The project keeps the original `product.category` column as a read-only legacy field so existing category text is not lost. When products are loaded, legacy category values are migrated into the new `category` table and `product.category_id`.

## Fresh database
Run the project normally with `spring.jpa.hibernate.ddl-auto=update`. For a brand-new empty development database, Hibernate will create the new tables and foreign keys.

## Existing database
Back up your database before running the updated project. Existing product category text is migrated on product load. Existing cart data cannot be recovered because the old application stored its cart in memory rather than in MySQL.

## Cart behavior
Cart state is now customer-specific and stored in MySQL. Adding the same product again increments `CartItem.quantity` instead of creating duplicate cart rows.

## Checkout behavior
Checkout copies cart rows into `OrderItem` rows. Each order item stores the purchase-time price and subtotal, so historical orders are not affected by later product-price changes.
