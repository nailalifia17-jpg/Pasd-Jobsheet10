public class AntrianKRS {
    Mahasiswa[] data;
    int front, rear, size, max;
    int sudahKRS;

    public AntrianKRS(int max) {
        this.max = max;
        data = new Mahasiswa[max];
        front = size = 0;
        rear = -1;
        sudahKRS = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == max;
    }

    public void clear() {
        front = size = 0;
        rear = -1;
        System.out.println("Antrian dikosongkan");
    }

    public void enqueue(Mahasiswa m) {
        if (isFull()) {
            System.out.println("Antrian penuh!");
            return;
        }
        rear = (rear + 1) % max;
        data[rear] = m;
        size++;
        System.out.println(m.nama + " masuk antrian");
    }

    public Mahasiswa dequeue() {
        if (isEmpty()) {
            return null;
        }
        Mahasiswa m = data[front];
        front = (front + 1) % max;
        size--;
        return m;
    }

    public void prosesKRS() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("Mahasiswa dipanggil:");
        for (int i = 0; i < 2; i++) {
            if (!isEmpty() && sudahKRS < 30) {
                Mahasiswa m = dequeue();
                m.tampilkanData();
                sudahKRS++;
            }
        }
    }

    public void tampilDepan2() {
        if (size == 0) {
            System.out.println("Antrian kosong");
            return;
        }
        System.out.println("2 antrian terdepan:");
        for (int i = 0; i < 2 && i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void tampilSemua() {
        if (isEmpty()) {
            System.out.println("Antrian kosong");
            return;
        }
        for (int i = 0; i < size; i++) {
            int index = (front + i) % max;
            data[index].tampilkanData();
        }
    }

    public void lihatAkhir() {
        if (!isEmpty()) {
            data[rear].tampilkanData();
        }
    }

    public int getJumlahAntrian() {
        return size;
    }

    public int getSudahKRS() {
        return sudahKRS;
    }

    public int getSisaKRS() {
        return 30 - sudahKRS;
    }
}