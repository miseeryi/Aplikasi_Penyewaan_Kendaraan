#include <iostream>
using namespace std;

int main() {
    int data[3][7] = {
        {10, 12, 5, 8, 6, 8, 9},   
        {7, 8, 6, 5, 7, 7, 10},    
        {4, 3, 2, 0, 0, 1, 2}      
    };

    int totalPerBarang[3] = {0};
    int totalPerHari[7] = {0};

    for (int b = 0; b < 3; b++) {
        for (int h = 0; h < 7; h++) {
            totalPerBarang[b] += data[b][h];
            totalPerHari[h] += data[b][h];
        }
    }

    cout << "Total penjualan setiap barang selama 7 hari:\n";
    for (int b = 0; b < 3; b++) {
        cout << "Barang " << b + 1 << ": " << totalPerBarang[b] << endl;
    }

    cout << "\nRata-rata penjualan per hari:\n";
    for (int h = 0; h < 7; h++) {
        cout << "Hari ke-" << h + 1 << ": " << totalPerHari[h] / 3 << endl;
    }

    int barangKonsisten = 0;
    int selisihTerkecil = 9999;

    for (int b = 0; b < 3; b++) {
        int nilaiTinggi = data[b][0];
        int nilaiRendah = data[b][0];
        for (int h = 1; h < 7; h++) {
            if (data[b][h] > nilaiTinggi) nilaiTinggi = data[b][h];
            if (data[b][h] < nilaiRendah) nilaiRendah = data[b][h];
        }
        int selisih = nilaiTinggi - nilaiRendah;
        if (selisih < selisihTerkecil) {
            selisihTerkecil = selisih;
            barangKonsisten = b;
        }
    }

    cout << "\nBarang paling konsisten: Barang " << barangKonsisten + 1 << endl;

    return 0;
}
