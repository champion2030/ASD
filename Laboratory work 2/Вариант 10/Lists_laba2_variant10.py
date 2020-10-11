from PyQt5.QtWidgets import QApplication, QMainWindow, QFileDialog
from PyQt5.uic import loadUi


class Ui(QMainWindow):
    numbers = list()

    def __init__(self):
        super(Ui, self).__init__()
        loadUi("sample.ui", self)
        self.change_hands.clicked.connect(self.set_Text)
        self.take_from_file.clicked.connect(self.read_file)
        self.change_file.clicked.connect(self.set_List)

    def printbuttonhands(self):
        self.numbers.clear()
        text = self.input_hands.text()
        if len(text) == 0:
            return False
        else:
            splitted_text = text.split()
            for item in splitted_text:
                k = len(item)
                sub_string = item[1:k]
                if item.isnumeric():
                    self.numbers.append(int(item))
                elif item.startswith("-") and sub_string.isnumeric():
                    self.numbers.append(int(item))
                else:
                    return False
            if len(self.numbers) == 0 or len(self.numbers) == 1:
                return False
            else:
                i = len(self.numbers)
                temp = self.numbers[i - 1]
                self.numbers[i - 1] = self.numbers[i - 2]
                self.numbers[i - 2] = temp
            return True

    def set_Text(self):
        if self.printbuttonhands():
            self.result_hands.setText(str(self.numbers))

    def read_file(self):
        Path = self.getFileName()
        if len(Path) == 0:
            return False
        else:
            with open(Path, "r") as file:
                line = file.readline()
            if len(line) == 0:
                return False
            else:
                self.see_file_list.setText(line)

    def check_file_information(self):
        self.numbers.clear()
        text = self.see_file_list.text()
        if len(text) == 0:
            return False
        else:
            splitted_text = text.split()
            for item in splitted_text:
                k = len(item)
                sub_string = item[1:k]
                if item.isnumeric():
                    self.numbers.append(int(item))
                elif item.startswith("-") and sub_string.isnumeric():
                    self.numbers.append(int(item))
                else:
                    return False
            if len(self.numbers) == 0 or len(self.numbers) == 1:
                return False
            else:
                i = len(self.numbers)
                temp = self.numbers[i - 1]
                self.numbers[i - 1] = self.numbers[i - 2]
                self.numbers[i - 2] = temp
            return True

    def set_List(self):
        if self.check_file_information():
            self.result_file.setText(str(self.numbers))

    def getFileName(self):
        filename, filetype = QFileDialog.getOpenFileName(self, "Выбрать файл", ".", "Text Files(*.txt);")
        return filename


if __name__ == "__main__":
    import sys

    app = QApplication(sys.argv)
    w = Ui()
    w.show()
    sys.exit(app.exec_())
