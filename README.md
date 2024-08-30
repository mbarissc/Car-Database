# Car-Database

## Açıklama
Bu proje, araçları MySQL veritabanında kayıt altına almak ve verileri JTable içinde görüntülemek için geliştirilmiştir. Bu uygulama sayesinde araç bilgilerini ekleyebilir, silebilir veya güncelleyebilirsiniz. Tablo üzerinde id, model yılı ve kilometreye göre büyükten küçüğe veya küçükten büyüğe sıralama yapabilirsiniz. 

## Kurulum

1. **Veritabanı Ayarları**: Database.java dosyasına MySQL veritabanının kullanıcı adı, parola, veritabanı ismi, host ve port bilgilerini giriniz.

2. **Tablo Oluşturma**: Aşağıdaki SQL komutunu kullanarak araba isimli tabloyu MySQL veritabanı üzerinde oluşturunuz:

  
   CREATE TABLE araba (
       id INT AUTO_INCREMENT PRIMARY KEY,
       brand VARCHAR(20),
       model VARCHAR(20),
       modelYear INT,
       color VARCHAR(20),
       km INT
   );





