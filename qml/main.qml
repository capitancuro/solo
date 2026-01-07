import QtQuick
import QtQuick.Controls

Window {
    id: root
    width: 800
    height: 600
    visible: true
    title: qsTr("Solo")
    color: "#2E2E2E" // Dark gray background

    Text {
        anchors.centerIn: parent
        text: "Hello from QML"
        color: "white"
        font.pixelSize: 24
    }
}