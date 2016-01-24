INSERT INTO product_types (ID, VERSION, DESCRIPTION, TYPE_NAME) VALUES
	(1, 0, NULL, 'Водка'),
	(2, 0, NULL, 'Коньяк');

INSERT INTO product (ID, VERSION, DESCRIPTION, PRODUCT_NAME, PRODUCT_TYPE_ID) VALUES
	(1, 0, NULL, '10 karton', 1),
	(2, 0, NULL, '5 бутыл', 1),
	(3, 0, NULL, 'вишня', 2);

INSERT INTO storages (ID, VERSION, STORAGE_NAME) VALUES
	(1, 0, 'Завод'),
	(2, 0, 'Тольяти'),
	(3, 0, 'Офис');

INSERT INTO regions (ID, VERSION, REGION_NAME) VALUES
	(1, 0, 'Днепропетровская'),
	(2, 0, 'Запорожская');

INSERT INTO cities (ID, VERSION, CITY_NAME, REGION_ID) VALUES
	(1, 0, 'Днепропетровск', 1),
	(2, 0, 'Запорожье', 2),
	(3, 0, 'Днепродзержинск', 1),
	(4, 0, 'Энергодар', 2),
	(5, 0, 'Павлоград', 1);

INSERT INTO document_types (ID, VERSION, DOCUMENT_TYPE) VALUES
	(1, 0, 'Покупка'),
	(2, 0, 'Продажа'),
	(3, 0, 'Возврат');

INSERT INTO partners (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, FATHERNAME, FIRSTNAME, LASTNAME) VALUES
	(1, 0, '2015-09-15 00:02:07', '2015-09-15 00:02:07', 'kkm', '', 'Larisa', 'Shpak'),
	(2, 0, '2015-09-15 12:31:21', '2015-09-15 12:31:22', 'kkm', '', 'Завод', ' ');

INSERT INTO incoming_documents (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, DATE_OF_DOCUMENT, STATUS, DOCUMENT_TYPE_ID, PARTNER_ID) VALUES
	(1, 0, '2015-09-15 12:24:38', '2015-09-15 12:24:36', 'kkm', '2015-09-15', b'1', 1, 2),
	(3, 5, '2015-09-15 16:04:59', '2015-09-17 22:53:43', 'vv', '2015-09-15', b'1', 1, 2),
	(4, 0, '2015-09-15 19:09:57', '2015-09-15 19:09:57', 'kkm', '2015-09-15', b'0', 1, 2),
	(11, 0, '2015-09-15 20:03:13', '2015-09-15 20:03:13', 'kkm', '2015-09-15', b'1', 1, 2),
	(12, 0, '2015-09-15 20:09:50', '2015-09-15 20:09:50', 'kkm', '2015-09-15', b'1', 1, 2),
	(13, 3, '2015-09-15 20:22:27', '2015-12-20 22:13:20', 'new user', '2015-09-15', b'1', 1, 2);

INSERT INTO incoming_details (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, QUANTITY, SUMM, PRODUCT_ID, DOCUMENT_ID, STORAGE_TO) VALUES
	(1, 0, '2015-09-15 12:30:23', '2015-09-15 12:30:24', 'kkm', 100, 25000.00, 1, 1, 2),
	(2, 2, '2015-09-15 16:04:59', '2015-09-17 22:06:39', 'kkm', 100, 25000.00, 1, 3, 2),
	(3, 0, '2015-09-15 19:09:57', '2015-09-15 19:09:57', 'kkm', 200, 50000.00, 1, 4, 2),
	(4, 0, '2015-09-15 20:03:13', '2015-09-15 20:03:13', 'kkm', 200, 50000.00, 1, 11, 2),
	(5, 0, '2015-09-15 20:09:50', '2015-09-15 20:09:50', 'kkm', 100, 25000.00, 1, 12, 2),
	(6, 0, '2015-09-15 20:09:50', '2015-09-15 20:09:50', 'kkm', 50, 10000.00, 3, 12, 2),
	(7, 0, '2015-09-15 20:22:27', '2015-09-15 20:22:27', 'kkm', 100, 25000.00, 1, 13, 2),
	(8, 0, '2015-09-15 20:22:27', '2015-09-15 20:22:27', 'kkm', 50, 10000.00, 3, 13, 2);

INSERT INTO operations (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, QUANTITY, SUMM, DOCUMENT_ID, PRODUCT_ID, DOCUMENT_TYPE_ID, STORAGE_ID) VALUES
	(1, 0, '2015-09-15 12:34:55', '2015-09-15 12:34:55', 'kkm', 100, -25000.00, 1, 1, 1, 2),
	(2, 0, '2015-09-15 20:03:13', '2015-09-15 20:03:13', 'kkm', 200, 50000.00, 11, 1, 1, 2),
	(3, 0, '2015-09-15 20:09:50', '2015-09-15 20:09:50', 'kkm', 100, 25000.00, 12, 1, 1, 2),
	(4, 0, '2015-09-15 20:09:50', '2015-09-15 20:09:50', 'kkm', 50, 10000.00, 12, 3, 1, 2),
	(5, 0, '2015-09-15 20:22:27', '2015-09-15 20:22:27', 'kkm', 100, -25000.00, 13, 1, 1, 2),
	(6, 0, '2015-09-15 20:22:27', '2015-09-15 20:22:27', 'kkm', 50, -10000.00, 13, 3, 1, 2);

INSERT INTO outgoing_document (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, DATE_OF_DOCUMENT, STATUS, DOCUMENT_TYPE_ID, PARTNER_ID) VALUES
	(3, 0, '2015-09-15 17:12:11', '2015-09-15 17:12:11', 'kkm', '2015-09-15', b'0', 2, 1);

INSERT INTO outgoing_details (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, QUANTITY, SUMM, PRODUCT_ID, DOCUMENT_ID, STORAGE_FROM) VALUES
	(2, 0, '2015-09-15 17:12:11', '2015-09-15 17:12:11', 'kkm', 10, 3000.00, 1, 3, 2);


INSERT INTO phones (ID, VERSION, INSERT_TS, UPDATE_TS, USER_NAME, CODE, FULL_NUMBER, NUMBER, PARTNER_ID) VALUES
	(1, 0, '2015-09-15 00:02:15', '2015-09-15 00:02:16', 'kkm', '095', '0951112233', '1112233', 1);



