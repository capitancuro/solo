#include <QGuiApplication>
#include <QQmlApplicationEngine>
#include <QUrl>

int main(int argc, char *argv[])
{
    // Initialize the main GUI application
    QGuiApplication app(argc, argv);

    // Create the QML engine
    QQmlApplicationEngine engine;

    // Load the main.qml file
    // NOTE: This path works because your CMake file copies the 'qml' folder 
    // to the build directory next to the executable.
    const QUrl url(u"qml/main.qml"_qs);

    // Connect a signal to ensure the app exits if the QML file fails to load
    QObject::connect(&engine, &QQmlApplicationEngine::objectCreated,
                     &app, [url](QObject *obj, const QUrl &objUrl) {
        if (!obj && url == objUrl)
            QCoreApplication::exit(-1);
    }, Qt::QueuedConnection);

    // Load the file
    engine.load(url);

    // Start the event loop
    return app.exec();
}