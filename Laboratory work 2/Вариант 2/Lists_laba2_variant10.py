from PyQt5.QtWidgets import QApplication, QMainWindow, QFileDialog
from PyQt5.uic import loadUi


class Ui(QMainWindow):
    numbers = list()
    file_numbers = list()

    def __init__(self):
        super(Ui, self).__init__()
        loadUi("sample.ui", self)
        self.input_list.clicked.connect(self.set_Text)
        self.take_from_file_list.clicked.connect(self.read_file)
        self.take_file_list_insert.clicked.connect(self.read_second_file)
        self.add_list.clicked.connect(self.insert_list)
        self.add_to_list.clicked.connect(self.set_List)


    def printbuttonhands(self):
        self.numbers.clear()
        text = self.input_hands.text()
        if len(text) == 0:
            return False
        else:
            splitted_text = text.split()
            for item in splitted_text:
                self.numbers.append(item)
            return True

    def set_Text(self):
        if self.printbuttonhands():
            self.result_hands.setText(str(self.numbers))

    def take_add_list(self):
        text = self.add_elements.text()
        if len(str(self.result_hands.text())) == 0:
            return False
        elif len(text) == 0:
            return False
        elif self.element_number.value() > len(self.numbers) or self.element_number.value() == 0:
            return False
        else:
            splitted_text = text.split()
            k = self.element_number.value() - 1
            splitted_text.reverse()
            for item in splitted_text:
                self.numbers.insert(k, item)
            return True

    def insert_list(self):
        if self.take_add_list():
            self.result_hands.setText(str(self.numbers))


    def read_file(self):
        self.file_numbers.clear()
        Path = self.getFileName()
        if len(Path) == 0:
            return False
        else:
            with open(Path, "r") as file:
                line = file.readline()
            if len(line) == 0:
                return False
            else:
                splitted_text = line.split()
                for item in splitted_text:
                    self.file_numbers.append(item)
                self.see_file_list.setText(str(self.file_numbers))
                self.result_file.setText(str(self.file_numbers))
                return True

    def read_second_file(self):
        Path = self.getFileName()
        if len(Path) == 0:
            return False
        else:
            with open(Path, "r") as file:
                line = file.readline()
            if len(line) == 0:
                return False
            else:
                self.see_file_list_insert.setText(line)
                return True


    def set_List(self):
        if len(self.see_file_list_insert.text()) == 0:
            return False
        elif self.element_number_2.value() > len(self.file_numbers) or self.element_number_2.value() == 0:
            return False
        else:
            text = self.see_file_list_insert.text()
            splitted_text = text.split()
            splitted_text.reverse()
            k = self.element_number_2.value() - 1
            for item in splitted_text:
                self.file_numbers.insert(k, item)
            self.result_file.setText(str(self.file_numbers))
            return True

    def getFileName(self):
        filename, filetype = QFileDialog.getOpenFileName(self, "Выбрать файл", ".", "Text Files(*.txt);")
        return filename


if __name__ == "__main__":
    import sys

    app = QApplication(sys.argv)
    w = Ui()
    w.show()
    sys.exit(app.exec_())
