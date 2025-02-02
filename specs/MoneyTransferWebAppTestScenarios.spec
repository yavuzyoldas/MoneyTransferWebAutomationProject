Para Transfer Uygulaması Test Senaryoları
==========================================


Para Transfer Uygulamasının başarılı şekilde açılması
-------------------------------------------------------------------------------------------------------------------
Tags: start,smokeTest
* Para Transfer Uygulaması başlatma işlemi için oturum açma ön koşulu sağlanır.
* Para Transfer Uygulaması başlatma sayfası açılır.
* Para Transfer Uygulaması başarılı şekilde açıldığı doğrulanır.

Para Transfer Uygulamasında "Checking Account" (Vadesiz Hesap) tipinde hesap isminin başarılı şekilde güncellenmesi
-------------------------------------------------------------------------------------------------------------------
Tags: updateAccountName,smokeTest

* Checking Account (Vadesiz Hesap) ismin düzenlemesi için hesap düzenleme butonuna tıklanır.
* Açılan pencerede hesap ismi yeni hesap ismi rastgele değer olarak değiştirilmek üzere metin kutusuna yazılır.
* Penceredeki güncelleme butonuna tıklanır.
* Hesap isminin yeni hesap ismi olarak güncellendiği doğrulanır.
Para Transfer Uygulamasında hesaplar arasında para transferi yapılması
-------------------------------------------------------------------------------------------------------------------
Tags: moneyTranferCheck,smokeTest
* Mevcut açık hesaptaki para miktarı kaydedilir ve Para Transferi butonuna tıklanır.
* Açılan Para Transferi pencerisinde miktar metin kutusuna yazılır.
* Gönder butonuna tıklanır.
* Para Tranferi İşlemleri listesinde işlemin oluduğu ve transfer edilen miktar kadar paranın hesaptan eksildiği doğrulanır.

Para Transfer Uygulamasında kredi kartı ile para yatırma
-------------------------------------------------------------------------------------------------------------------
Tags: addMoneyCreditCard, smokeTest

* Mevcut açık hesaptaki para miktarı kaydedilir ve Para Ekleme butonuna tıklanır.
* Para Ekleme penceresindeki kredi kartı numara alanı test verisi ile doldurulur.
* Para Ekleme penceresindeki kredi kartı sahibi alanı doldurulur.
* Para Ekleme penceresindeki kartı son kullanma tarihi alanı doldurulur.
* Para Ekleme penceresindeki kredi kartı CVV alanı doldurulur.
* Para Ekleme penceresindeki miktar alanı doldurulur.
* Ekle butonuna tıklanır.
* Para Ekleme işleminin işlemler listesinde olduğu ve eklenen paranın hesaba eklendiği doğrulanır.

Para Transfer Uygulamasında hesap bakiyesini sıfırın altına düşmesi kontrolü
-------------------------------------------------------------------------------------------------------------------
Tags: checkMoneyNegetive, test
* Mevcut açık hesaptaki para miktarı kaydedilir ve Para Transferi butonuna tıklanır.
* Açılan Para Transferi pencerisinde miktar metin kutusuna mevcut para miktarında fazla bir değer yazılır.
* Gönder butonuna tıklanır.
* Para Tranferinin gerçekleşmediği ve hesap miktarını aynı kaldığı görülür.
