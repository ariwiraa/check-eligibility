## Prasyarat

Sebelum Anda memulai, pastikan Anda telah memenuhi prasyarat berikut:

- [Java](https://www.oracle.com/java/) 17 atau versi yang lebih tinggi
- [Maven](https://maven.apache.org/) 3.2 atau versi yang lebih tinggi

## Cara Menggunakan

1. Clone repositori ini:

    ```bash
    git clone https://github.com/ariwiraa/check-eligibility.git
    ```

2. Pindah ke direktori proyek:

    ```bash
    cd divistant
    ```

3. Jalankan aplikasi:

    ```bash
    ./mvnw spring-boot:run
    ```

    Aplikasi akan berjalan di [http://localhost:8080](http://localhost:8080).

## Konfigurasi

Anda dapat mengkonfigurasi proyek ini dengan mengedit file [application.properties](src/main/resources/application.properties) sesuai kebutuhan.

## Dokumentasi API

#### Check Eligibility

```bash
  GET /api/check-eligibility/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id dari customer|

#### Get Customer

```bash
  GET /api/customers/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

```bash
  POST /api/customers
```

| Request Body | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `nik`      | `string` | **Required**, **Min: 16**, **Max: 16**  nomor indur kependudukan |
| `name`      | `string` | **Required**. nama customer |
| `income`      | `integer` | **Required**. penghasilan|


