import SwiftUI
import shared

@main
struct iOSApp: App {
    let repository: TelegramRepository
    let configStorage: IosTelegramConfigStorage

    init() {
        let config = IosTelegramConfigStorage()
        // Pre-fill from env vars if available (for CI / dev convenience)
        if !config.isConfigured {
            let env = ProcessInfo.processInfo.environment
            if let appIdStr = env["TELEGRAM_APP_ID"],
               let appId = Int32(appIdStr),
               let appHash = env["TELEGRAM_APP_HASH"] {
                config.appId = appId
                config.appHash = appHash
            }
        }
        self.configStorage = config
        self.repository = IosRepositoryFactoryKt.createRepository(config: config)
    }

    var body: some Scene {
        WindowGroup {
            ContentView(repository: repository, configStorage: configStorage)
        }
    }
}