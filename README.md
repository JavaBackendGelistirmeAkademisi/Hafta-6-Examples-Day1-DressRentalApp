
# Dress Rental App

Dress Rental App, Java backend geliştirme becerilerinin pratik uygulamasını göstermek için geliştirilmiş örnek bir projedir. Bu proje, JDBC kullanarak veritabanı işlemlerini entegre etme gibi çeşitli konuları kapsamaktadır.

## Özellikler

- **Veritabanı Entegrasyonu:** JDBC kullanılarak CRUD işlemleri gösterilmiştir.
- **Hata Yönetimi:** Kullanıcı deneyimini iyileştirmek için hata yönetimi teknikleri uygulanmıştır.
- **Transaction Yönetimi:** Backend servislerinde işlemlerin etkili bir şekilde nasıl yönetileceği gösterilmiştir.

## Başlangıç

### Gereksinimler

Projeyi çalıştırmak için sisteminizde aşağıdaki yazılımların kurulu olması gerekmektedir:

- Java 17 veya üstü
- Maven 3.8 veya üstü
- Docker ve Docker Compose
- PostgreSQL veya uyumlu başka bir SQL veritabanı

### Kurulum

1. **Projeyi klonlayın:**

   ```bash
   git clone https://github.com/JavaBackendGelistirmeAkademisi/Hafta-6-Examples-Day1-DressRentalApp.git
   cd Hafta-6-Examples-Day1-DressRentalApp
   ```

2. **Veritabanını yapılandırın:**

   - `dress_rental_db` adında bir veritabanı oluşturun (Docker ile çalıştırılacaksa bu adım gerekmez).

3. **Projeyi Maven ile derleyin:**

   ```bash
   mvn clean install
   ```

4. **Docker ile çalıştırma:**

   Projeyi Docker ile çalıştırmak için, projenin kök dizininde bulunan `docker-compose.yml` dosyasını kullanarak hem uygulama hem de PostgreSQL veritabanını çalıştırabilirsiniz:

   ```bash
   docker-compose up --build
   ```

   Bu komut, uygulamayı ve veritabanını gerekli konfigürasyonlarla birlikte ayağa kaldıracaktır.


## Kullanılan Teknolojiler

- **Java 17:** Backend mantığı için kullanılan ana programlama dili.
- **JDBC:** Veritabanı etkileşimi ve SQL sorguları yönetimi için kullanıldı.
- **Maven:** Bağımlılık yönetimi ve proje derleme işlemleri.
- **Docker & Docker Compose:** Uygulamayı ve PostgreSQL veritabanını kapsayıcı olarak çalıştırmak için kullanılır.
- **PostgreSQL:** Örneklerde kullanılan veritabanı yönetim sistemi.

## Katkıda Bulunanlar
Bu proje, Java Backend Geliştirme Akademisi tarafından geliştirilmiştir.

