import UIKit
import SwiftUI
import shared

struct ComposeView: UIViewControllerRepresentable {
    let repository: TelegramRepository
    let configStorage: IosTelegramConfigStorage

    func makeUIViewController(context: Context) -> UIViewController {
        MainKt.MainViewController(telegramRepository: repository, configStorage: configStorage)
    }

    func updateUIViewController(_ uiViewController: UIViewController, context: Context) {}
}

struct ContentView: View {
    let repository: TelegramRepository
    let configStorage: IosTelegramConfigStorage

    var body: some View {
        ComposeView(repository: repository, configStorage: configStorage)
                .ignoresSafeArea(.keyboard) // Compose has own keyboard handler
    }
}
