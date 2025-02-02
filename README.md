Para Transfer Uygulaması Otomasyon Test Projesi

Bu proje, "Para Transfer Uygulaması" kapsamında gerçekleştirilecek otomasyon testlerini kapsamaktadır. 
Otomasyon testleri, uygulamanın fonksiyonelliklerini doğrulamak, API, Web ve mobil platformlarda yazılım kalitesini artırmak amacıyla uygulanmaktadır. 
Proje, Java 11, Selenium 4.10.0 ve Gauge 0.6.9 kullanarak geliştirilmiştir.

Kullanılan Teknolojiler

Java 11: Yazılım geliştirme dilidir.
Selenium 4.10.0: Web tarayıcılarını kontrol etmek için kullanılır.
Gauge 0.6.9: Test otomasyonu için kullanılan bir framework'tür.

Kurulum

Projenin çalışabilmesi için aşağıdaki adımların takip edilmesi gerekmektedir:

Java 11'in yüklü olduğundan emin olun.
Maven kullanarak gerekli bağımlılıkları yükleyin.
Selenium 4.10.0 ve Gauge 0.6.9 bağımlılıklarını pom.xml dosyasına ekleyin.

Test Çalıştırma

Test Çalıştırma Adımları

Testleri Gauge ile Çalıştırmak için:

Gauge framework'ü ile testleri çalıştırmak için komut satırına şu komutu girin:


gauge run specs

Taglere Göre Test Çalıştırma:

Tag'ler ile testleri çalıştırmak için şu komutları kullanabilirsiniz:

Örneğin, sadece smokeTest tag'li testleri çalıştırmak için:


gauge run --tags smokeTest specs

Örneğin, sadece moneyTranferCheck tag'li testleri çalıştırmak için:


gauge run --tags moneyTranferCheck specs

Örneğin, sadece addMoneyCreditCard tag'li testleri çalıştırmak için:


gauge run --tags addMoneyCreditCard specs

Testleri Maven ile Çalıştırmak için:

Maven komutları ile Gauge testlerini çalıştırabilirsiniz. Aşağıdaki komutu kullanarak testleri çalıştırabilirsiniz:

Tüm testleri çalıştırmak için:


mvn clean test

Belirli bir tag ile çalıştırmak için (örneğin smokeTest):


mvn clean test -Dgauge.tags=“smokeTest"





Test Raporları

Testler çalıştırıldığında ExtentReports kullanılarak kapsamlı raporlar oluşturulacaktır. Bu raporlar, her testin başarısı, başarısızlık durumu ve testin tamamlanma zamanı gibi önemli verileri içermektedir. Rapora proje dizininde bulunan test-output klasöründen erişebilirsiniz.
