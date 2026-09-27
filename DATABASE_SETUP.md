# ShopMate database setup

## Admin product category dropdown
The Admin -> Add Product page now loads categories from the `category` table and saves the selected `category_id` into `product.category_id`.

Default categories are seeded by `src/main/resources/data.sql`.

## Original product data
The original ZIP contains product images and Java/JSP source, but it does not contain a MySQL dump or SQL INSERT statements. The exact original database rows therefore cannot be reconstructed from the ZIP alone.

To export your existing database from MySQL Workbench:
1. Server -> Data Export.
2. Select `shopmate_app`.
3. Select tables and choose `Export to Self-Contained File`.
4. Export the SQL file.

When moving to the normalized schema, make sure every existing `orders.customer_id` references a real `customer.cid` before adding the foreign key, and every `product.category_id` references a real `category.category_id`.
