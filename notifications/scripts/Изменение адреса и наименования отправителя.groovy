/*! UTF8 */
//Автор: mdemyanov
//Дата создания: 02.05.17
//Код: 
//Назначение: 
/**
 * Изменение адреса и наименования отправителя:
 * @param MAIL_HOLDER - код атрибута запроса, содержащий объект
 * с параметрами отправителя
 * @param FROM_EMAIL - код атрибута атрибута с адресом отправителя
 * @param FROM_NAME - код атрибута атрибута с наименованием
 * отправителя
 * Сценарий получает с параметрами отправителя, в случае если
 * объект не пуст, а также не пуст конкретный параметр - заменяет
 * ими значение из настроек подключения.
 */
//Версия: 4.6.*
//Категория: кастомизация почтового оповещения
//Параметры------------------------------------------------------
def MAIL_HOLDER = 'agreement'
def FROM_EMAIL = 'fromEmail'
def FROM_NAME = 'fromName'
//Функции--------------------------------------------------------
//Основной блок -------------------------------------------------
/*Получаем объект с настройками*/
def mailHolder = subject[MAIL_HOLDER]
if (mailHolder) {
	/*Получаем адрес*/
	def fromEmail = mailHolder[FROM_EMAIL]
	/*Получаем наименование*/
	def fromName = mailHolder[FROM_NAME]
	/*Если адрес не пуст - меняем отправителя*/
	if (fromEmail) {
		notification.parameters.from = fromEmail
	}
	/*Если наименование не пусто - меняем отправителя*/
	if (fromName) {
		notification.parameters.name = fromName
	}
}