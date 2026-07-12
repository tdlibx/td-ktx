package org.drinkless.tdlib.generated

import org.drinkless.tdlib.TdKtxClient
import kotlinx.serialization.encodeToString
import kotlinx.serialization.decodeFromString

/**
 * Returns the current authorization state. This is an offline method. For informational purposes only. Use updateAuthorizationState instead to maintain the current authorization state. Can be called before initialization
 */
suspend fun TdKtxClient.getAuthorizationState(
): AuthorizationState {
    val request = GetAuthorizationState()
    val requestJson = tdJson.encodeToString(GetAuthorizationState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AuthorizationState.serializer(), responseJson)
}

/**
 * Sets the parameters for TDLib initialization. Works only when the current authorization state is authorizationStateWaitTdlibParameters
 * @param useTestDc Pass true to use Telegram test environment instead of the production environment
 * @param databaseDirectory The path to the directory for the persistent database; if empty, the current working directory will be used
 * @param filesDirectory The path to the directory for storing files; if empty, database_directory will be used
 * @param databaseEncryptionKey Encryption key for the database. If the encryption key is invalid, then an error with code 401 will be returned
 * @param useFileDatabase Pass true to keep information about downloaded and uploaded files between application restarts
 * @param useChatInfoDatabase Pass true to keep cache of users, basic groups, supergroups, channels and secret chats between restarts. Implies use_file_database
 * @param useMessageDatabase Pass true to keep cache of chats and messages between restarts. Implies use_chat_info_database
 * @param useSecretChats Pass true to enable support for secret chats
 * @param apiId Application identifier for Telegram API access, which can be obtained at https://my.telegram.org
 * @param apiHash Application identifier hash for Telegram API access, which can be obtained at https://my.telegram.org
 * @param systemLanguageCode IETF language tag of the user's operating system language; must be non-empty
 * @param deviceModel Model of the device the application is being run on; must be non-empty
 * @param systemVersion Version of the operating system the application is being run on. If empty, the version is automatically detected by TDLib
 * @param applicationVersion Application version; must be non-empty
 */
suspend fun TdKtxClient.setTdlibParameters(
    useTestDc: Boolean,
    databaseDirectory: String? = null,
    filesDirectory: String? = null,
    databaseEncryptionKey: String? = null,
    useFileDatabase: Boolean,
    useChatInfoDatabase: Boolean,
    useMessageDatabase: Boolean,
    useSecretChats: Boolean,
    apiId: Int,
    apiHash: String? = null,
    systemLanguageCode: String? = null,
    deviceModel: String? = null,
    systemVersion: String? = null,
    applicationVersion: String? = null,
): Ok {
    val request = SetTdlibParameters(useTestDc, databaseDirectory, filesDirectory, databaseEncryptionKey, useFileDatabase, useChatInfoDatabase, useMessageDatabase, useSecretChats, apiId, apiHash, systemLanguageCode, deviceModel, systemVersion, applicationVersion)
    val requestJson = tdJson.encodeToString(SetTdlibParameters.serializer(), request)
    println("TD_FLOW_DEBUG -> $requestJson")
    val responseJson = this.sendJson(requestJson)
    println("TD_FLOW_DEBUG -> $responseJson")
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the phone number of the user and sends an authentication code to the user. Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitPremiumPurchase, authorizationStateWaitEmailAddress, authorizationStateWaitEmailCode, authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword
 * @param phoneNumber The phone number of the user, in international format
 * @param settings Settings for the authentication of the user's phone number; pass null to use default settings
 */
suspend fun TdKtxClient.setAuthenticationPhoneNumber(
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null,
): Ok {
    val request = SetAuthenticationPhoneNumber(phoneNumber, settings)
    val requestJson = tdJson.encodeToString(SetAuthenticationPhoneNumber.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether an in-store purchase of Telegram Premium is possible before authorization. Works only when the current authorization state is authorizationStateWaitPremiumPurchase
 * @param premiumDayCount The number of days for which the Telegram Premium subscription will be granted
 * @param currency ISO 4217 currency code of the payment currency
 * @param amount Paid amount, in the smallest units of the currency
 */
suspend fun TdKtxClient.checkAuthenticationPremiumPurchase(
    premiumDayCount: Int,
    currency: String? = null,
    amount: Long,
): Ok {
    val request = CheckAuthenticationPremiumPurchase(premiumDayCount, currency, amount)
    val requestJson = tdJson.encodeToString(CheckAuthenticationPremiumPurchase.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs server about an in-store purchase of Telegram Premium before authorization. Works only when the current authorization state is authorizationStateWaitPremiumPurchase
 * @param transaction Information about the transaction
 * @param isRestore Pass true if this is a restore of a Telegram Premium purchase; only for App Store
 * @param premiumDayCount The number of days for which the Telegram Premium subscription will be granted
 * @param currency ISO 4217 currency code of the payment currency
 * @param amount Paid amount, in the smallest units of the currency
 */
suspend fun TdKtxClient.setAuthenticationPremiumPurchaseTransaction(
    transaction: StoreTransaction? = null,
    isRestore: Boolean,
    premiumDayCount: Int,
    currency: String? = null,
    amount: Long,
): Ok {
    val request = SetAuthenticationPremiumPurchaseTransaction(transaction, isRestore, premiumDayCount, currency, amount)
    val requestJson = tdJson.encodeToString(SetAuthenticationPremiumPurchaseTransaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the email address of the user and sends an authentication code to the email address. Works only when the current authorization state is authorizationStateWaitEmailAddress @email_address The email address of the user
 */
suspend fun TdKtxClient.setAuthenticationEmailAddress(
    emailAddress: String? = null,
): Ok {
    val request = SetAuthenticationEmailAddress(emailAddress)
    val requestJson = tdJson.encodeToString(SetAuthenticationEmailAddress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resends an authentication code to the user. Works only when the current authorization state is authorizationStateWaitCode, the next_code_type of the result is not null and the server-specified timeout has passed, or when the current authorization state is authorizationStateWaitEmailCode
 * @param reason Reason of code resending; pass null if unknown
 */
suspend fun TdKtxClient.resendAuthenticationCode(
    reason: ResendCodeReason? = null,
): Ok {
    val request = ResendAuthenticationCode(reason)
    val requestJson = tdJson.encodeToString(ResendAuthenticationCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the authentication of an email address. Works only when the current authorization state is authorizationStateWaitEmailCode @code Email address authentication to check
 */
suspend fun TdKtxClient.checkAuthenticationEmailCode(
    code: EmailAddressAuthentication? = null,
): Ok {
    val request = CheckAuthenticationEmailCode(code)
    val requestJson = tdJson.encodeToString(CheckAuthenticationEmailCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the authentication code. Works only when the current authorization state is authorizationStateWaitCode @code Authentication code to check
 */
suspend fun TdKtxClient.checkAuthenticationCode(
    code: String? = null,
): Ok {
    val request = CheckAuthenticationCode(code)
    val requestJson = tdJson.encodeToString(CheckAuthenticationCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Requests QR code authentication by scanning a QR code on another logged in device. Works only when the current authorization state is authorizationStateWaitPhoneNumber, or if there is no pending authentication query and the current authorization state is authorizationStateWaitPremiumPurchase, authorizationStateWaitEmailAddress, authorizationStateWaitEmailCode, authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword
 * @param otherUserIds List of user identifiers of other users currently using the application
 */
suspend fun TdKtxClient.requestQrCodeAuthentication(
    otherUserIds: List<Long>? = null,
): Ok {
    val request = RequestQrCodeAuthentication(otherUserIds)
    val requestJson = tdJson.encodeToString(RequestQrCodeAuthentication.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns parameters for authentication using a passkey as JSON-serialized string
 */
suspend fun TdKtxClient.getAuthenticationPasskeyParameters(
): Text {
    val request = GetAuthenticationPasskeyParameters()
    val requestJson = tdJson.encodeToString(GetAuthenticationPasskeyParameters.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Checks a passkey to log in to the corresponding account. Call getAuthenticationPasskeyParameters to get parameters for the passkey. Works only when the current authorization state is authorizationStateWaitPhoneNumber or authorizationStateWaitOtherDeviceConfirmation, or if there is no pending authentication query and the current authorization state is authorizationStateWaitPremiumPurchase, authorizationStateWaitEmailAddress, authorizationStateWaitEmailCode, authorizationStateWaitCode, authorizationStateWaitRegistration, or authorizationStateWaitPassword
 * @param credentialId Base64url-encoded identifier of the credential
 * @param clientData JSON-encoded client data
 * @param authenticatorData Authenticator data of the application that created the credential
 * @param signature Cryptographic signature of the credential
 * @param userHandle User handle of the passkey
 */
suspend fun TdKtxClient.checkAuthenticationPasskey(
    credentialId: String? = null,
    clientData: String? = null,
    authenticatorData: String? = null,
    signature: String? = null,
    userHandle: String? = null,
): Ok {
    val request = CheckAuthenticationPasskey(credentialId, clientData, authenticatorData, signature, userHandle)
    val requestJson = tdJson.encodeToString(CheckAuthenticationPasskey.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks a web token to log in to the corresponding account; for official Telegram apps only. Works only when the current authorization state is authorizationStateWaitPhoneNumber or authorizationStateWaitOtherDeviceConfirmation
 * @param token The token to check
 * @param dcId Identifier of the datacenter of the user
 */
suspend fun TdKtxClient.checkAuthenticationWebToken(
    token: String? = null,
    dcId: Int,
): Ok {
    val request = CheckAuthenticationWebToken(token, dcId)
    val requestJson = tdJson.encodeToString(CheckAuthenticationWebToken.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Finishes user registration. Works only when the current authorization state is authorizationStateWaitRegistration
 * @param firstName The first name of the user; 1-64 characters
 * @param lastName The last name of the user; 0-64 characters
 * @param disableNotification Pass true to disable notification about the current user joining Telegram for other users that added them to contact list
 */
suspend fun TdKtxClient.registerUser(
    firstName: String? = null,
    lastName: String? = null,
    disableNotification: Boolean,
): Ok {
    val request = RegisterUser(firstName, lastName, disableNotification)
    val requestJson = tdJson.encodeToString(RegisterUser.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resets the login email address. May return an error with a message "TASK_ALREADY_EXISTS" if reset is still pending. Works only when the current authorization state is authorizationStateWaitEmailCode and authorization_state.can_reset_email_address == true
 */
suspend fun TdKtxClient.resetAuthenticationEmailAddress(
): Ok {
    val request = ResetAuthenticationEmailAddress()
    val requestJson = tdJson.encodeToString(ResetAuthenticationEmailAddress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the 2-step verification password for correctness. Works only when the current authorization state is authorizationStateWaitPassword @password The 2-step verification password to check
 */
suspend fun TdKtxClient.checkAuthenticationPassword(
    password: String? = null,
): Ok {
    val request = CheckAuthenticationPassword(password)
    val requestJson = tdJson.encodeToString(CheckAuthenticationPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Requests to send a 2-step verification password recovery code to an email address that was previously set up. Works only when the current authorization state is authorizationStateWaitPassword
 */
suspend fun TdKtxClient.requestAuthenticationPasswordRecovery(
): Ok {
    val request = RequestAuthenticationPasswordRecovery()
    val requestJson = tdJson.encodeToString(RequestAuthenticationPasswordRecovery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether a 2-step verification password recovery code sent to an email address is valid. Works only when the current authorization state is authorizationStateWaitPassword @recovery_code Recovery code to check
 */
suspend fun TdKtxClient.checkAuthenticationPasswordRecoveryCode(
    recoveryCode: String? = null,
): Ok {
    val request = CheckAuthenticationPasswordRecoveryCode(recoveryCode)
    val requestJson = tdJson.encodeToString(CheckAuthenticationPasswordRecoveryCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Recovers the 2-step verification password with a password recovery code sent to an email address that was previously set up. Works only when the current authorization state is authorizationStateWaitPassword
 * @param recoveryCode Recovery code to check
 * @param newPassword New 2-step verification password of the user; may be empty to remove the password
 * @param newHint New password hint; may be empty
 */
suspend fun TdKtxClient.recoverAuthenticationPassword(
    recoveryCode: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
): Ok {
    val request = RecoverAuthenticationPassword(recoveryCode, newPassword, newHint)
    val requestJson = tdJson.encodeToString(RecoverAuthenticationPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends Firebase Authentication SMS to the phone number of the user. Works only when the current authorization state is authorizationStateWaitCode and the server returned code of the type authenticationCodeTypeFirebaseAndroid or authenticationCodeTypeFirebaseIos
 * @param token Play Integrity API or SafetyNet Attestation API token for the Android application, or secret from push notification for the iOS application
 */
suspend fun TdKtxClient.sendAuthenticationFirebaseSms(
    token: String? = null,
): Ok {
    val request = SendAuthenticationFirebaseSms(token)
    val requestJson = tdJson.encodeToString(SendAuthenticationFirebaseSms.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports that authentication code wasn't delivered via SMS; for official mobile applications only. Works only when the current authorization state is authorizationStateWaitCode @mobile_network_code Current mobile network code
 */
suspend fun TdKtxClient.reportAuthenticationCodeMissing(
    mobileNetworkCode: String? = null,
): Ok {
    val request = ReportAuthenticationCodeMissing(mobileNetworkCode)
    val requestJson = tdJson.encodeToString(ReportAuthenticationCodeMissing.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the authentication token of a bot; to log in as a bot. Works only when the current authorization state is authorizationStateWaitPhoneNumber. Can be used instead of setAuthenticationPhoneNumber and checkAuthenticationCode to log in @token The bot token
 */
suspend fun TdKtxClient.checkAuthenticationBotToken(
    token: String? = null,
): Ok {
    val request = CheckAuthenticationBotToken(token)
    val requestJson = tdJson.encodeToString(CheckAuthenticationBotToken.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Closes the TDLib instance after a proper logout. Requires an available network connection. All local data will be destroyed. After the logout completes, updateAuthorizationState with authorizationStateClosed will be sent
 */
suspend fun TdKtxClient.logOut(
): Ok {
    val request = LogOut()
    val requestJson = tdJson.encodeToString(LogOut.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Closes the TDLib instance. All databases will be flushed to disk and properly closed. After the close completes, updateAuthorizationState with authorizationStateClosed will be sent. Can be called before initialization
 */
suspend fun TdKtxClient.close(
): Ok {
    val request = Close()
    val requestJson = tdJson.encodeToString(Close.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Closes the TDLib instance, destroying all local data without a proper logout. The current user session will remain in the list of all active sessions. All local data will be destroyed. After the destruction completes updateAuthorizationState with authorizationStateClosed will be sent. Can be called before authorization
 */
suspend fun TdKtxClient.destroy(
): Ok {
    val request = Destroy()
    val requestJson = tdJson.encodeToString(Destroy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Confirms QR code authentication on another device. Returns created session on success @link A link from a QR code. The link must be scanned by the in-app camera
 */
suspend fun TdKtxClient.confirmQrCodeAuthentication(
    link: String? = null,
): Session {
    val request = ConfirmQrCodeAuthentication(link)
    val requestJson = tdJson.encodeToString(ConfirmQrCodeAuthentication.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Session.serializer(), responseJson)
}

/**
 * Returns all updates needed to restore current TDLib state, i.e. all actual updateAuthorizationState/updateUser/updateNewChat and others. This is especially useful if TDLib is run in a separate process. Can be called before initialization
 */
suspend fun TdKtxClient.getCurrentState(
): Updates {
    val request = GetCurrentState()
    val requestJson = tdJson.encodeToString(GetCurrentState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Updates.serializer(), responseJson)
}

/**
 * Changes the database encryption key. Usually the encryption key is never changed and is stored in some OS keychain @new_encryption_key New encryption key
 */
suspend fun TdKtxClient.setDatabaseEncryptionKey(
    newEncryptionKey: String? = null,
): Ok {
    val request = SetDatabaseEncryptionKey(newEncryptionKey)
    val requestJson = tdJson.encodeToString(SetDatabaseEncryptionKey.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the current state of 2-step verification
 */
suspend fun TdKtxClient.getPasswordState(
): PasswordState {
    val request = GetPasswordState()
    val requestJson = tdJson.encodeToString(GetPasswordState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Changes the 2-step verification password for the current user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed
 * @param oldPassword Previous 2-step verification password of the user
 * @param newPassword New 2-step verification password of the user; may be empty to remove the password
 * @param newHint New password hint; may be empty
 * @param setRecoveryEmailAddress Pass true to change also the recovery email address
 * @param newRecoveryEmailAddress New recovery email address; may be empty
 */
suspend fun TdKtxClient.setPassword(
    oldPassword: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
    setRecoveryEmailAddress: Boolean,
    newRecoveryEmailAddress: String? = null,
): PasswordState {
    val request = SetPassword(oldPassword, newPassword, newHint, setRecoveryEmailAddress, newRecoveryEmailAddress)
    val requestJson = tdJson.encodeToString(SetPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Checks whether the current user is required to set login email address
 */
suspend fun TdKtxClient.isLoginEmailAddressRequired(
): Ok {
    val request = IsLoginEmailAddressRequired()
    val requestJson = tdJson.encodeToString(IsLoginEmailAddressRequired.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the login email address of the user. The email address can be changed only if the current user already has login email and passwordState.login_email_address_pattern is non-empty, or the user received suggestedActionSetLoginEmailAddress and isLoginEmailAddressRequired succeeds. The change will not be applied until the new login email address is confirmed with checkLoginEmailAddressCode. To use Apple ID/Google ID instead of an email address, call checkLoginEmailAddressCode directly
 * @param newLoginEmailAddress New login email address
 */
suspend fun TdKtxClient.setLoginEmailAddress(
    newLoginEmailAddress: String? = null,
): EmailAddressAuthenticationCodeInfo {
    val request = SetLoginEmailAddress(newLoginEmailAddress)
    val requestJson = tdJson.encodeToString(SetLoginEmailAddress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmailAddressAuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Resends the login email address verification code
 */
suspend fun TdKtxClient.resendLoginEmailAddressCode(
): EmailAddressAuthenticationCodeInfo {
    val request = ResendLoginEmailAddressCode()
    val requestJson = tdJson.encodeToString(ResendLoginEmailAddressCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmailAddressAuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Checks the login email address authentication @code Email address authentication to check
 */
suspend fun TdKtxClient.checkLoginEmailAddressCode(
    code: EmailAddressAuthentication? = null,
): Ok {
    val request = CheckLoginEmailAddressCode(code)
    val requestJson = tdJson.encodeToString(CheckLoginEmailAddressCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a 2-step verification recovery email address that was previously set up. This method can be used to verify a password provided by the user @password The 2-step verification password for the current user
 */
suspend fun TdKtxClient.getRecoveryEmailAddress(
    password: String? = null,
): RecoveryEmailAddress {
    val request = GetRecoveryEmailAddress(password)
    val requestJson = tdJson.encodeToString(GetRecoveryEmailAddress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RecoveryEmailAddress.serializer(), responseJson)
}

/**
 * Changes the 2-step verification recovery email address of the user. If a new recovery email address is specified, then the change will not be applied until the new recovery email address is confirmed. If new_recovery_email_address is the same as the email address that is currently set up, this call succeeds immediately and aborts all other requests waiting for an email confirmation
 * @param password The 2-step verification password of the current user
 * @param newRecoveryEmailAddress New recovery email address
 */
suspend fun TdKtxClient.setRecoveryEmailAddress(
    password: String? = null,
    newRecoveryEmailAddress: String? = null,
): PasswordState {
    val request = SetRecoveryEmailAddress(password, newRecoveryEmailAddress)
    val requestJson = tdJson.encodeToString(SetRecoveryEmailAddress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Checks the 2-step verification recovery email address verification code @code Verification code to check
 */
suspend fun TdKtxClient.checkRecoveryEmailAddressCode(
    code: String? = null,
): PasswordState {
    val request = CheckRecoveryEmailAddressCode(code)
    val requestJson = tdJson.encodeToString(CheckRecoveryEmailAddressCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Resends the 2-step verification recovery email address verification code
 */
suspend fun TdKtxClient.resendRecoveryEmailAddressCode(
): PasswordState {
    val request = ResendRecoveryEmailAddressCode()
    val requestJson = tdJson.encodeToString(ResendRecoveryEmailAddressCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Cancels verification of the 2-step verification recovery email address
 */
suspend fun TdKtxClient.cancelRecoveryEmailAddressVerification(
): PasswordState {
    val request = CancelRecoveryEmailAddressVerification()
    val requestJson = tdJson.encodeToString(CancelRecoveryEmailAddressVerification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Requests to send a 2-step verification password recovery code to an email address that was previously set up
 */
suspend fun TdKtxClient.requestPasswordRecovery(
): EmailAddressAuthenticationCodeInfo {
    val request = RequestPasswordRecovery()
    val requestJson = tdJson.encodeToString(RequestPasswordRecovery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmailAddressAuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Checks whether a 2-step verification password recovery code sent to an email address is valid @recovery_code Recovery code to check
 */
suspend fun TdKtxClient.checkPasswordRecoveryCode(
    recoveryCode: String? = null,
): Ok {
    val request = CheckPasswordRecoveryCode(recoveryCode)
    val requestJson = tdJson.encodeToString(CheckPasswordRecoveryCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Recovers the 2-step verification password using a recovery code sent to an email address that was previously set up
 * @param recoveryCode Recovery code to check
 * @param newPassword New 2-step verification password of the user; may be empty to remove the password
 * @param newHint New password hint; may be empty
 */
suspend fun TdKtxClient.recoverPassword(
    recoveryCode: String? = null,
    newPassword: String? = null,
    newHint: String? = null,
): PasswordState {
    val request = RecoverPassword(recoveryCode, newPassword, newHint)
    val requestJson = tdJson.encodeToString(RecoverPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PasswordState.serializer(), responseJson)
}

/**
 * Removes 2-step verification password without previous password and access to recovery email address. The password can't be reset immediately and the request needs to be repeated after the specified time
 */
suspend fun TdKtxClient.resetPassword(
): ResetPasswordResult {
    val request = ResetPassword()
    val requestJson = tdJson.encodeToString(ResetPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ResetPasswordResult.serializer(), responseJson)
}

/**
 * Cancels reset of 2-step verification password. The method can be called if passwordState.pending_reset_date > 0
 */
suspend fun TdKtxClient.cancelPasswordReset(
): Ok {
    val request = CancelPasswordReset()
    val requestJson = tdJson.encodeToString(CancelPasswordReset.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Creates a new temporary password for processing payments @password The 2-step verification password of the current user @valid_for Time during which the temporary password will be valid, in seconds; must be between 60 and 86400
 */
suspend fun TdKtxClient.createTemporaryPassword(
    password: String? = null,
    validFor: Int,
): TemporaryPasswordState {
    val request = CreateTemporaryPassword(password, validFor)
    val requestJson = tdJson.encodeToString(CreateTemporaryPassword.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TemporaryPasswordState.serializer(), responseJson)
}

/**
 * Returns information about the current temporary password
 */
suspend fun TdKtxClient.getTemporaryPasswordState(
): TemporaryPasswordState {
    val request = GetTemporaryPasswordState()
    val requestJson = tdJson.encodeToString(GetTemporaryPasswordState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TemporaryPasswordState.serializer(), responseJson)
}

/**
 * Returns the current user
 */
suspend fun TdKtxClient.getMe(
): User {
    val request = GetMe()
    val requestJson = tdJson.encodeToString(GetMe.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Returns information about a user by their identifier. This is an offline method if the current user is not a bot @user_id User identifier
 */
suspend fun TdKtxClient.getUser(
    userId: Long,
): User {
    val request = GetUser(userId)
    val requestJson = tdJson.encodeToString(GetUser.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Returns full information about a user by their identifier @user_id User identifier
 */
suspend fun TdKtxClient.getUserFullInfo(
    userId: Long,
): UserFullInfo {
    val request = GetUserFullInfo(userId)
    val requestJson = tdJson.encodeToString(GetUserFullInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UserFullInfo.serializer(), responseJson)
}

/**
 * Returns information about a basic group by its identifier. This is an offline method if the current user is not a bot @basic_group_id Basic group identifier
 */
suspend fun TdKtxClient.getBasicGroup(
    basicGroupId: Long,
): BasicGroup {
    val request = GetBasicGroup(basicGroupId)
    val requestJson = tdJson.encodeToString(GetBasicGroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BasicGroup.serializer(), responseJson)
}

/**
 * Returns full information about a basic group by its identifier @basic_group_id Basic group identifier
 */
suspend fun TdKtxClient.getBasicGroupFullInfo(
    basicGroupId: Long,
): BasicGroupFullInfo {
    val request = GetBasicGroupFullInfo(basicGroupId)
    val requestJson = tdJson.encodeToString(GetBasicGroupFullInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BasicGroupFullInfo.serializer(), responseJson)
}

/**
 * Returns information about a supergroup or a channel by its identifier. This is an offline method if the current user is not a bot @supergroup_id Supergroup or channel identifier
 */
suspend fun TdKtxClient.getSupergroup(
    supergroupId: Long,
): Supergroup {
    val request = GetSupergroup(supergroupId)
    val requestJson = tdJson.encodeToString(GetSupergroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Supergroup.serializer(), responseJson)
}

/**
 * Returns full information about a supergroup or a channel by its identifier, cached for up to 1 minute @supergroup_id Supergroup or channel identifier
 */
suspend fun TdKtxClient.getSupergroupFullInfo(
    supergroupId: Long,
): SupergroupFullInfo {
    val request = GetSupergroupFullInfo(supergroupId)
    val requestJson = tdJson.encodeToString(GetSupergroupFullInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(SupergroupFullInfo.serializer(), responseJson)
}

/**
 * Returns information about a secret chat by its identifier. This is an offline method @secret_chat_id Secret chat identifier
 */
suspend fun TdKtxClient.getSecretChat(
    secretChatId: Int,
): SecretChat {
    val request = GetSecretChat(secretChatId)
    val requestJson = tdJson.encodeToString(GetSecretChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(SecretChat.serializer(), responseJson)
}

/**
 * Returns information about a chat by its identifier. This is an offline method if the current user is not a bot @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChat(
    chatId: Long,
): Chat {
    val request = GetChat(chatId)
    val requestJson = tdJson.encodeToString(GetChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Returns information about a message. Returns a 404 error if the message doesn't exist
 * @param chatId Identifier of the chat the message belongs to
 * @param messageId Identifier of the message to get
 */
suspend fun TdKtxClient.getMessage(
    chatId: Long,
    messageId: Long,
): Message {
    val request = GetMessage(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns information about a message, if it is available without sending network request. Returns a 404 error if message isn't available locally. This is an offline method
 * @param chatId Identifier of the chat the message belongs to
 * @param messageId Identifier of the message to get
 */
suspend fun TdKtxClient.getMessageLocally(
    chatId: Long,
    messageId: Long,
): Message {
    val request = GetMessageLocally(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageLocally.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns information about a non-bundled message that is replied by a given message. Also, returns the pinned message for messagePinMessage, the game message for messageGameScore, the invoice message for messagePaymentSuccessful, the message with a previously set same background for messageChatSetBackground, the giveaway message for messageGiveawayCompleted, the checklist message for messageChecklistTasksDone, messageChecklistTasksAdded, the message with suggested post information for messageSuggestedPostApprovalFailed, messageSuggestedPostApproved, messageSuggestedPostDeclined, messageSuggestedPostPaid, messageSuggestedPostRefunded, the message with the regular gift that was upgraded for messageUpgradedGift with origin of the type upgradedGiftOriginUpgrade, the message with gift purchase offer for messageUpgradedGiftPurchaseOfferRejected, the message with the request to disable content protection for messageChatHasProtectedContentToggled, the message with the poll for messagePollOptionAdded and messagePollOptionDeleted, and the topic creation message for topic messages without non-bundled replied message. Returns a 404 error if the message doesn't exist
 * @param chatId Identifier of the chat the message belongs to
 * @param messageId Identifier of the reply message
 */
suspend fun TdKtxClient.getRepliedMessage(
    chatId: Long,
    messageId: Long,
): Message {
    val request = GetRepliedMessage(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetRepliedMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns information about a newest pinned message in the chat. Returns a 404 error if the message doesn't exist @chat_id Identifier of the chat the message belongs to
 */
suspend fun TdKtxClient.getChatPinnedMessage(
    chatId: Long,
): Message {
    val request = GetChatPinnedMessage(chatId)
    val requestJson = tdJson.encodeToString(GetChatPinnedMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns information about a message with the callback button that originated a callback query; for bots only @chat_id Identifier of the chat the message belongs to @message_id Message identifier @callback_query_id Identifier of the callback query
 */
suspend fun TdKtxClient.getCallbackQueryMessage(
    chatId: Long,
    messageId: Long,
    callbackQueryId: Long,
): Message {
    val request = GetCallbackQueryMessage(chatId, messageId, callbackQueryId)
    val requestJson = tdJson.encodeToString(GetCallbackQueryMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns information about messages. If a message is not found, returns null on the corresponding position of the result @chat_id Identifier of the chat the messages belong to @message_ids Identifiers of the messages to get
 */
suspend fun TdKtxClient.getMessages(
    chatId: Long,
    messageIds: List<Long>? = null,
): Messages {
    val request = GetMessages(chatId, messageIds)
    val requestJson = tdJson.encodeToString(GetMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns the full version of a rich message @chat_id Identifier of the chat the messages belong to @message_id Identifier of the message
 */
suspend fun TdKtxClient.getFullRichMessage(
    chatId: Long,
    messageId: Long,
): RichMessage {
    val request = GetFullRichMessage(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetFullRichMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RichMessage.serializer(), responseJson)
}

/**
 * Returns properties of a message. This is an offline method @chat_id Chat identifier @message_id Identifier of the message
 */
suspend fun TdKtxClient.getMessageProperties(
    chatId: Long,
    messageId: Long,
): MessageProperties {
    val request = GetMessageProperties(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageProperties.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageProperties.serializer(), responseJson)
}

/**
 * Returns properties of a poll option. This is an offline method
 * @param chatId Chat identifier
 * @param messageId Identifier of the message
 * @param pollOptionId Unique identifier of the answer option, which properties will be returned
 */
suspend fun TdKtxClient.getPollOptionProperties(
    chatId: Long,
    messageId: Long,
    pollOptionId: String? = null,
): PollOptionProperties {
    val request = GetPollOptionProperties(chatId, messageId, pollOptionId)
    val requestJson = tdJson.encodeToString(GetPollOptionProperties.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PollOptionProperties.serializer(), responseJson)
}

/**
 * Returns information about a message thread. Can be used only if messageProperties.can_get_message_thread == true @chat_id Chat identifier @message_id Identifier of the message
 */
suspend fun TdKtxClient.getMessageThread(
    chatId: Long,
    messageId: Long,
): MessageThreadInfo {
    val request = GetMessageThread(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageThread.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageThreadInfo.serializer(), responseJson)
}

/**
 * Returns read date of a recent outgoing message in a private chat. The method can be called if messageProperties.can_get_read_date == true
 * @param chatId Chat identifier
 * @param messageId Identifier of the message
 */
suspend fun TdKtxClient.getMessageReadDate(
    chatId: Long,
    messageId: Long,
): MessageReadDate {
    val request = GetMessageReadDate(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageReadDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageReadDate.serializer(), responseJson)
}

/**
 * Returns viewers of a recent outgoing message in a basic group or a supergroup chat. For video notes and voice notes only users, opened content of the message, are returned. The method can be called if messageProperties.can_get_viewers == true
 * @param chatId Chat identifier
 * @param messageId Identifier of the message
 */
suspend fun TdKtxClient.getMessageViewers(
    chatId: Long,
    messageId: Long,
): MessageViewers {
    val request = GetMessageViewers(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageViewers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageViewers.serializer(), responseJson)
}

/**
 * Returns information about actual author of a message sent on behalf of a channel. The method can be called if messageProperties.can_get_author == true
 * @param chatId Chat identifier
 * @param messageId Identifier of the message
 */
suspend fun TdKtxClient.getMessageAuthor(
    chatId: Long,
    messageId: Long,
): User {
    val request = GetMessageAuthor(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetMessageAuthor.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Returns information about a file. This is an offline method @file_id Identifier of the file to get
 */
suspend fun TdKtxClient.getFile(
    fileId: Int,
): File {
    val request = GetFile(fileId)
    val requestJson = tdJson.encodeToString(GetFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Returns information about a file by its remote identifier. This is an offline method. Can be used to register a URL as a file for further uploading, or sending as a message. Even if the request succeeds, the file can be used only if it is still accessible to the user. For example, if the file is from a message, then the message must be not deleted and accessible to the user. If the file database is disabled, then the corresponding object with the file must be preloaded by the application
 * @param remoteFileId Remote identifier of the file to get
 * @param fileType File type; pass null if unknown
 */
suspend fun TdKtxClient.getRemoteFile(
    remoteFileId: String? = null,
    fileType: FileType? = null,
): File {
    val request = GetRemoteFile(remoteFileId, fileType)
    val requestJson = tdJson.encodeToString(GetRemoteFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Loads more chats from a chat list. The loaded chats and their positions in the chat list will be sent through updates. Chats are sorted by the pair (chat.position.order, chat.id) in descending order. Returns a 404 error if all chats have been loaded
 * @param chatList The chat list in which to load chats; pass null to load chats from the main chat list
 * @param limit The maximum number of chats to be loaded. For optimal performance, the number of loaded chats is chosen by TDLib and can be smaller than the specified limit, even if the end of the list is not reached
 */
suspend fun TdKtxClient.loadChats(
    chatList: ChatList? = null,
    limit: Int,
): Ok {
    val request = LoadChats(chatList, limit)
    val requestJson = tdJson.encodeToString(LoadChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns an ordered list of chats from the beginning of a chat list. For informational purposes only. Use loadChats and updates processing instead to maintain chat lists in a consistent state
 * @param chatList The chat list in which to return chats; pass null to get chats from the main chat list
 * @param limit The maximum number of chats to be returned
 */
suspend fun TdKtxClient.getChats(
    chatList: ChatList? = null,
    limit: Int,
): Chats {
    val request = GetChats(chatList, limit)
    val requestJson = tdJson.encodeToString(GetChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Searches a public chat by its username. Currently, only private chats, supergroups and channels can be public. Returns the chat if found; otherwise, an error is returned @username Username to be resolved
 */
suspend fun TdKtxClient.searchPublicChat(
    username: String? = null,
): Chat {
    val request = SearchPublicChat(username)
    val requestJson = tdJson.encodeToString(SearchPublicChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Searches public chats by looking for specified query in their username and title. Currently, only private chats, supergroups and channels can be public. Returns a meaningful number of results. Excludes private chats with contacts and chats from the chat list from the results
 * @param query Query to search for
 * @param typeFilter Additional filter for type of the chats to be returned; pass null to search for chats of all types
 */
suspend fun TdKtxClient.searchPublicChats(
    query: String? = null,
    typeFilter: SearchChatTypeFilter? = null,
): Chats {
    val request = SearchPublicChats(query, typeFilter)
    val requestJson = tdJson.encodeToString(SearchPublicChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Searches for the specified query in the title and username of already known chats. This is an offline method. Returns chats in the order seen in the main chat list
 * @param query Query to search for. If the query is empty, returns up to 50 recently found chats
 * @param typeFilter Additional filter for type of the chats to be returned; pass null to search for chats of all types
 * @param limit The maximum number of chats to be returned
 */
suspend fun TdKtxClient.searchChats(
    query: String? = null,
    typeFilter: SearchChatTypeFilter? = null,
    limit: Int,
): Chats {
    val request = SearchChats(query, typeFilter, limit)
    val requestJson = tdJson.encodeToString(SearchChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Searches for the specified query in the title and username of already known chats via request to the server. Returns chats in the order seen in the main chat list
 * @param query Query to search for
 * @param typeFilter Additional filter for type of the chats to be returned; pass null to search for chats of all types
 * @param limit The maximum number of chats to be returned
 */
suspend fun TdKtxClient.searchChatsOnServer(
    query: String? = null,
    typeFilter: SearchChatTypeFilter? = null,
    limit: Int,
): Chats {
    val request = SearchChatsOnServer(query, typeFilter, limit)
    val requestJson = tdJson.encodeToString(SearchChatsOnServer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns a list of channel chats recommended to the current user
 */
suspend fun TdKtxClient.getRecommendedChats(
): Chats {
    val request = GetRecommendedChats()
    val requestJson = tdJson.encodeToString(GetRecommendedChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns a list of chats similar to the given chat @chat_id Identifier of the target chat; must be an identifier of a channel chat
 */
suspend fun TdKtxClient.getChatSimilarChats(
    chatId: Long,
): Chats {
    val request = GetChatSimilarChats(chatId)
    val requestJson = tdJson.encodeToString(GetChatSimilarChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns approximate number of chats similar to the given chat
 * @param chatId Identifier of the target chat; must be an identifier of a channel chat
 * @param returnLocal Pass true to get the number of chats without sending network requests, or -1 if the number of chats is unknown locally
 */
suspend fun TdKtxClient.getChatSimilarChatCount(
    chatId: Long,
    returnLocal: Boolean,
): Count {
    val request = GetChatSimilarChatCount(chatId, returnLocal)
    val requestJson = tdJson.encodeToString(GetChatSimilarChatCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Informs TDLib that a chat was opened from the list of similar chats. The method is independent of openChat and closeChat methods
 * @param chatId Identifier of the original chat, which similar chats were requested
 * @param openedChatId Identifier of the opened chat
 */
suspend fun TdKtxClient.openChatSimilarChat(
    chatId: Long,
    openedChatId: Long,
): Ok {
    val request = OpenChatSimilarChat(chatId, openedChatId)
    val requestJson = tdJson.encodeToString(OpenChatSimilarChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of bots similar to the given bot @bot_user_id User identifier of the target bot
 */
suspend fun TdKtxClient.getBotSimilarBots(
    botUserId: Long,
): Users {
    val request = GetBotSimilarBots(botUserId)
    val requestJson = tdJson.encodeToString(GetBotSimilarBots.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Returns approximate number of bots similar to the given bot
 * @param botUserId User identifier of the target bot
 * @param returnLocal Pass true to get the number of bots without sending network requests, or -1 if the number of bots is unknown locally
 */
suspend fun TdKtxClient.getBotSimilarBotCount(
    botUserId: Long,
    returnLocal: Boolean,
): Count {
    val request = GetBotSimilarBotCount(botUserId, returnLocal)
    val requestJson = tdJson.encodeToString(GetBotSimilarBotCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Informs TDLib that a bot was opened from the list of similar bots
 * @param botUserId Identifier of the original bot, which similar bots were requested
 * @param openedBotUserId Identifier of the opened bot
 */
suspend fun TdKtxClient.openBotSimilarBot(
    botUserId: Long,
    openedBotUserId: Long,
): Ok {
    val request = OpenBotSimilarBot(botUserId, openedBotUserId)
    val requestJson = tdJson.encodeToString(OpenBotSimilarBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of frequently used chats @category Category of chats to be returned @limit The maximum number of chats to be returned; up to 30
 */
suspend fun TdKtxClient.getTopChats(
    category: TopChatCategory? = null,
    limit: Int,
): Chats {
    val request = GetTopChats(category, limit)
    val requestJson = tdJson.encodeToString(GetTopChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Removes a chat from the list of frequently used chats. Supported only if the chat info database is enabled @category Category of frequently used chats @chat_id Chat identifier
 */
suspend fun TdKtxClient.removeTopChat(
    category: TopChatCategory? = null,
    chatId: Long,
): Ok {
    val request = RemoveTopChat(category, chatId)
    val requestJson = tdJson.encodeToString(RemoveTopChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches for the specified query in the title and username of up to 50 recently found chats. This is an offline method
 * @param query Query to search for
 * @param typeFilter Additional filter for type of the chats to be returned; pass null to search for chats of all types
 * @param limit The maximum number of chats to be returned
 */
suspend fun TdKtxClient.searchRecentlyFoundChats(
    query: String? = null,
    typeFilter: SearchChatTypeFilter? = null,
    limit: Int,
): Chats {
    val request = SearchRecentlyFoundChats(query, typeFilter, limit)
    val requestJson = tdJson.encodeToString(SearchRecentlyFoundChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Adds a chat to the list of recently found chats. The chat is added to the beginning of the list. If the chat is already in the list, it will be removed from the list first @chat_id Identifier of the chat to add
 */
suspend fun TdKtxClient.addRecentlyFoundChat(
    chatId: Long,
): Ok {
    val request = AddRecentlyFoundChat(chatId)
    val requestJson = tdJson.encodeToString(AddRecentlyFoundChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a chat from the list of recently found chats @chat_id Identifier of the chat to be removed
 */
suspend fun TdKtxClient.removeRecentlyFoundChat(
    chatId: Long,
): Ok {
    val request = RemoveRecentlyFoundChat(chatId)
    val requestJson = tdJson.encodeToString(RemoveRecentlyFoundChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Clears the list of recently found chats
 */
suspend fun TdKtxClient.clearRecentlyFoundChats(
): Ok {
    val request = ClearRecentlyFoundChats()
    val requestJson = tdJson.encodeToString(ClearRecentlyFoundChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns recently opened chats. This is an offline method. Returns chats in the order of last opening @limit The maximum number of chats to be returned
 */
suspend fun TdKtxClient.getRecentlyOpenedChats(
    limit: Int,
): Chats {
    val request = GetRecentlyOpenedChats(limit)
    val requestJson = tdJson.encodeToString(GetRecentlyOpenedChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Checks whether a username can be set for a chat @chat_id Chat identifier; must be identifier of a supergroup chat, or a channel chat, or a private chat with self, or 0 if the chat is being created @username Username to be checked
 */
suspend fun TdKtxClient.checkChatUsername(
    chatId: Long,
    username: String? = null,
): CheckChatUsernameResult {
    val request = CheckChatUsername(chatId, username)
    val requestJson = tdJson.encodeToString(CheckChatUsername.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CheckChatUsernameResult.serializer(), responseJson)
}

/**
 * Returns a list of public chats of the specified type, owned by the user @type Type of the public chats to return
 */
suspend fun TdKtxClient.getCreatedPublicChats(
    type: PublicChatType? = null,
): Chats {
    val request = GetCreatedPublicChats(type)
    val requestJson = tdJson.encodeToString(GetCreatedPublicChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Checks whether the maximum number of owned public chats has been reached. Returns corresponding error if the limit was reached. The limit can be increased with Telegram Premium @type Type of the public chats, for which to check the limit
 */
suspend fun TdKtxClient.checkCreatedPublicChatsLimit(
    type: PublicChatType? = null,
): Ok {
    val request = CheckCreatedPublicChatsLimit(type)
    val requestJson = tdJson.encodeToString(CheckCreatedPublicChatsLimit.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of basic group and supergroup chats, which can be used as a discussion group for a channel. Returned basic group chats must be first upgraded to supergroups before they can be set as a discussion group. To set a returned supergroup as a discussion group, access to its old messages must be enabled using toggleSupergroupIsAllHistoryAvailable first
 */
suspend fun TdKtxClient.getSuitableDiscussionChats(
): Chats {
    val request = GetSuitableDiscussionChats()
    val requestJson = tdJson.encodeToString(GetSuitableDiscussionChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns a list of recently inactive supergroups and channels. Can be used when user reaches limit on the number of joined supergroups and channels and receives the error "CHANNELS_TOO_MUCH". Also, the limit can be increased with Telegram Premium
 */
suspend fun TdKtxClient.getInactiveSupergroupChats(
): Chats {
    val request = GetInactiveSupergroupChats()
    val requestJson = tdJson.encodeToString(GetInactiveSupergroupChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns a list of channel chats, which can be used as a personal chat
 */
suspend fun TdKtxClient.getSuitablePersonalChats(
): Chats {
    val request = GetSuitablePersonalChats()
    val requestJson = tdJson.encodeToString(GetSuitablePersonalChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Loads more topics in a channel direct messages chat administered by the current user. The loaded topics will be sent through updateDirectMessagesChatTopic. Topics are sorted by their topic.order in descending order. Returns a 404 error if all topics have been loaded
 * @param chatId Chat identifier of the channel direct messages chat
 * @param limit The maximum number of topics to be loaded. For optimal performance, the number of loaded topics is chosen by TDLib and can be smaller than the specified limit, even if the end of the list is not reached
 */
suspend fun TdKtxClient.loadDirectMessagesChatTopics(
    chatId: Long,
    limit: Int,
): Ok {
    val request = LoadDirectMessagesChatTopics(chatId, limit)
    val requestJson = tdJson.encodeToString(LoadDirectMessagesChatTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about the topic in a channel direct messages chat administered by the current user
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Identifier of the topic to get
 */
suspend fun TdKtxClient.getDirectMessagesChatTopic(
    chatId: Long,
    topicId: Long,
): DirectMessagesChatTopic {
    val request = GetDirectMessagesChatTopic(chatId, topicId)
    val requestJson = tdJson.encodeToString(GetDirectMessagesChatTopic.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(DirectMessagesChatTopic.serializer(), responseJson)
}

/**
 * Returns messages in the topic in a channel direct messages chat administered by the current user. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id)
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Identifier of the topic which messages will be fetched
 * @param fromMessageId Identifier of the message starting from which messages must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number from -99 to -1 to get additionally -offset newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than or equal to -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getDirectMessagesChatTopicHistory(
    chatId: Long,
    topicId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
): Messages {
    val request = GetDirectMessagesChatTopicHistory(chatId, topicId, fromMessageId, offset, limit)
    val requestJson = tdJson.encodeToString(GetDirectMessagesChatTopicHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns the last message sent in the topic in a channel direct messages chat administered by the current user no later than the specified date
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Identifier of the topic which messages will be fetched
 * @param date Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TdKtxClient.getDirectMessagesChatTopicMessageByDate(
    chatId: Long,
    topicId: Long,
    date: Int,
): Message {
    val request = GetDirectMessagesChatTopicMessageByDate(chatId, topicId, date)
    val requestJson = tdJson.encodeToString(GetDirectMessagesChatTopicMessageByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Deletes all messages in the topic in a channel direct messages chat administered by the current user
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Identifier of the topic which messages will be deleted
 */
suspend fun TdKtxClient.deleteDirectMessagesChatTopicHistory(
    chatId: Long,
    topicId: Long,
): Ok {
    val request = DeleteDirectMessagesChatTopicHistory(chatId, topicId)
    val requestJson = tdJson.encodeToString(DeleteDirectMessagesChatTopicHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages between the specified dates in the topic in a channel direct messages chat administered by the current user. Messages sent in the last 30 seconds will not be deleted
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Identifier of the topic which messages will be deleted
 * @param minDate The minimum date of the messages to delete
 * @param maxDate The maximum date of the messages to delete
 */
suspend fun TdKtxClient.deleteDirectMessagesChatTopicMessagesByDate(
    chatId: Long,
    topicId: Long,
    minDate: Int,
    maxDate: Int,
): Ok {
    val request = DeleteDirectMessagesChatTopicMessagesByDate(chatId, topicId, minDate, maxDate)
    val requestJson = tdJson.encodeToString(DeleteDirectMessagesChatTopicMessagesByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the marked as unread state of the topic in a channel direct messages chat administered by the current user
 * @param chatId Chat identifier of the channel direct messages chat
 * @param topicId Topic identifier
 * @param isMarkedAsUnread New value of is_marked_as_unread
 */
suspend fun TdKtxClient.setDirectMessagesChatTopicIsMarkedAsUnread(
    chatId: Long,
    topicId: Long,
    isMarkedAsUnread: Boolean,
): Ok {
    val request = SetDirectMessagesChatTopicIsMarkedAsUnread(chatId, topicId, isMarkedAsUnread)
    val requestJson = tdJson.encodeToString(SetDirectMessagesChatTopicIsMarkedAsUnread.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all pinned messages from the topic in a channel direct messages chat administered by the current user
 * @param chatId Identifier of the chat
 * @param topicId Topic identifier
 */
suspend fun TdKtxClient.unpinAllDirectMessagesChatTopicMessages(
    chatId: Long,
    topicId: Long,
): Ok {
    val request = UnpinAllDirectMessagesChatTopicMessages(chatId, topicId)
    val requestJson = tdJson.encodeToString(UnpinAllDirectMessagesChatTopicMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all unread reactions in the topic in a channel direct messages chat administered by the current user
 * @param chatId Identifier of the chat
 * @param topicId Topic identifier
 */
suspend fun TdKtxClient.readAllDirectMessagesChatTopicReactions(
    chatId: Long,
    topicId: Long,
): Ok {
    val request = ReadAllDirectMessagesChatTopicReactions(chatId, topicId)
    val requestJson = tdJson.encodeToString(ReadAllDirectMessagesChatTopicReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the total number of Telegram Stars received by the channel chat for direct messages from the given topic
 * @param chatId Chat identifier of the channel direct messages chat administered by the current user
 * @param topicId Identifier of the topic
 */
suspend fun TdKtxClient.getDirectMessagesChatTopicRevenue(
    chatId: Long,
    topicId: Long,
): StarCount {
    val request = GetDirectMessagesChatTopicRevenue(chatId, topicId)
    val requestJson = tdJson.encodeToString(GetDirectMessagesChatTopicRevenue.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarCount.serializer(), responseJson)
}

/**
 * Allows to send unpaid messages to the given topic of the channel direct messages chat administered by the current user
 * @param chatId Chat identifier
 * @param topicId Identifier of the topic
 * @param canSendUnpaidMessages Pass true to allow unpaid messages; pass false to disallow unpaid messages
 * @param refundPayments Pass true to refund the user previously paid messages
 */
suspend fun TdKtxClient.toggleDirectMessagesChatTopicCanSendUnpaidMessages(
    chatId: Long,
    topicId: Long,
    canSendUnpaidMessages: Boolean,
    refundPayments: Boolean,
): Ok {
    val request = ToggleDirectMessagesChatTopicCanSendUnpaidMessages(chatId, topicId, canSendUnpaidMessages, refundPayments)
    val requestJson = tdJson.encodeToString(ToggleDirectMessagesChatTopicCanSendUnpaidMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Loads more Saved Messages topics. The loaded topics will be sent through updateSavedMessagesTopic. Topics are sorted by their topic.order in descending order. Returns a 404 error if all topics have been loaded
 * @param limit The maximum number of topics to be loaded. For optimal performance, the number of loaded topics is chosen by TDLib and can be smaller than the specified limit, even if the end of the list is not reached
 */
suspend fun TdKtxClient.loadSavedMessagesTopics(
    limit: Int,
): Ok {
    val request = LoadSavedMessagesTopics(limit)
    val requestJson = tdJson.encodeToString(LoadSavedMessagesTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns messages in a Saved Messages topic. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id)
 * @param savedMessagesTopicId Identifier of Saved Messages topic which messages will be fetched
 * @param fromMessageId Identifier of the message starting from which messages must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number from -99 to -1 to get additionally -offset newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than or equal to -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getSavedMessagesTopicHistory(
    savedMessagesTopicId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
): Messages {
    val request = GetSavedMessagesTopicHistory(savedMessagesTopicId, fromMessageId, offset, limit)
    val requestJson = tdJson.encodeToString(GetSavedMessagesTopicHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns the last message sent in a Saved Messages topic no later than the specified date
 * @param savedMessagesTopicId Identifier of Saved Messages topic which message will be returned
 * @param date Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TdKtxClient.getSavedMessagesTopicMessageByDate(
    savedMessagesTopicId: Long,
    date: Int,
): Message {
    val request = GetSavedMessagesTopicMessageByDate(savedMessagesTopicId, date)
    val requestJson = tdJson.encodeToString(GetSavedMessagesTopicMessageByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Deletes all messages in a Saved Messages topic @saved_messages_topic_id Identifier of Saved Messages topic which messages will be deleted
 */
suspend fun TdKtxClient.deleteSavedMessagesTopicHistory(
    savedMessagesTopicId: Long,
): Ok {
    val request = DeleteSavedMessagesTopicHistory(savedMessagesTopicId)
    val requestJson = tdJson.encodeToString(DeleteSavedMessagesTopicHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages between the specified dates in a Saved Messages topic. Messages sent in the last 30 seconds will not be deleted
 * @param savedMessagesTopicId Identifier of Saved Messages topic which messages will be deleted
 * @param minDate The minimum date of the messages to delete
 * @param maxDate The maximum date of the messages to delete
 */
suspend fun TdKtxClient.deleteSavedMessagesTopicMessagesByDate(
    savedMessagesTopicId: Long,
    minDate: Int,
    maxDate: Int,
): Ok {
    val request = DeleteSavedMessagesTopicMessagesByDate(savedMessagesTopicId, minDate, maxDate)
    val requestJson = tdJson.encodeToString(DeleteSavedMessagesTopicMessagesByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the pinned state of a Saved Messages topic. There can be up to getOption("pinned_saved_messages_topic_count_max") pinned topics. The limit can be increased with Telegram Premium
 * @param savedMessagesTopicId Identifier of Saved Messages topic to pin or unpin
 * @param isPinned Pass true to pin the topic; pass false to unpin it
 */
suspend fun TdKtxClient.toggleSavedMessagesTopicIsPinned(
    savedMessagesTopicId: Long,
    isPinned: Boolean,
): Ok {
    val request = ToggleSavedMessagesTopicIsPinned(savedMessagesTopicId, isPinned)
    val requestJson = tdJson.encodeToString(ToggleSavedMessagesTopicIsPinned.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the order of pinned Saved Messages topics @saved_messages_topic_ids Identifiers of the new pinned Saved Messages topics
 */
suspend fun TdKtxClient.setPinnedSavedMessagesTopics(
    savedMessagesTopicIds: List<Long>? = null,
): Ok {
    val request = SetPinnedSavedMessagesTopics(savedMessagesTopicIds)
    val requestJson = tdJson.encodeToString(SetPinnedSavedMessagesTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of common group chats with a given user. Chats are sorted by their type and creation date
 * @param userId User identifier
 * @param offsetChatId Chat identifier starting from which to return chats; use 0 for the first request
 * @param limit The maximum number of chats to be returned; up to 100
 */
suspend fun TdKtxClient.getGroupsInCommon(
    userId: Long,
    offsetChatId: Long,
    limit: Int,
): Chats {
    val request = GetGroupsInCommon(userId, offsetChatId, limit)
    val requestJson = tdJson.encodeToString(GetGroupsInCommon.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns messages in a chat. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id). For optimal performance, the number of returned messages is chosen by TDLib. This is an offline method if only_local is true
 * @param chatId Chat identifier
 * @param fromMessageId Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number from -99 to -1 to get additionally -offset newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than or equal to -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param onlyLocal Pass true to get only messages that are available without sending network requests
 */
suspend fun TdKtxClient.getChatHistory(
    chatId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
    onlyLocal: Boolean,
): Messages {
    val request = GetChatHistory(chatId, fromMessageId, offset, limit, onlyLocal)
    val requestJson = tdJson.encodeToString(GetChatHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns messages in a message thread of a message. Can be used only if messageProperties.can_get_message_thread == true. Message thread of a channel message is in the channel's linked supergroup. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id). For optimal performance, the number of returned messages is chosen by TDLib
 * @param chatId Chat identifier
 * @param messageId Message identifier, which thread history needs to be returned
 * @param fromMessageId Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number from -99 to -1 to get additionally -offset newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than or equal to -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getMessageThreadHistory(
    chatId: Long,
    messageId: Long,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
): Messages {
    val request = GetMessageThreadHistory(chatId, messageId, fromMessageId, offset, limit)
    val requestJson = tdJson.encodeToString(GetMessageThreadHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Deletes all messages in the chat. Use chat.can_be_deleted_only_for_self and chat.can_be_deleted_for_all_users fields to find whether and how the method can be applied to the chat
 * @param chatId Chat identifier
 * @param removeFromChatList Pass true to remove the chat from all chat lists
 * @param revoke Pass true to delete chat history for all users
 */
suspend fun TdKtxClient.deleteChatHistory(
    chatId: Long,
    removeFromChatList: Boolean,
    revoke: Boolean,
): Ok {
    val request = DeleteChatHistory(chatId, removeFromChatList, revoke)
    val requestJson = tdJson.encodeToString(DeleteChatHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a chat along with all messages in the corresponding chat for all chat members. For group chats this will release the usernames and remove all members. Use the field chat.can_be_deleted_for_all_users to find whether the method can be applied to the chat
 * @param chatId Chat identifier
 */
suspend fun TdKtxClient.deleteChat(
    chatId: Long,
): Ok {
    val request = DeleteChat(chatId)
    val requestJson = tdJson.encodeToString(DeleteChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches for messages with given words in the chat. Returns the results in reverse chronological order, i.e. in order of decreasing message_id. Cannot be used in secret chats with a non-empty query (searchSecretMessages must be used instead), or without an enabled message database. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit. A combination of query, sender_id, filter and topic_id search criteria is expected to be supported, only if it is required for Telegram official application implementation
 * @param chatId Identifier of the chat in which to search messages
 * @param topicId Pass topic identifier to search messages only in specific topic; pass null to search for messages in all topics
 * @param query Query to search for
 * @param senderId Identifier of the sender of messages to search for; pass null to search for messages from any sender. Not supported in secret chats
 * @param fromMessageId Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number to get the specified message and some newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param filter Additional filter for messages to search; pass null to search for all messages
 */
suspend fun TdKtxClient.searchChatMessages(
    chatId: Long,
    topicId: MessageTopic? = null,
    query: String? = null,
    senderId: MessageSender? = null,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
    filter: SearchMessagesFilter? = null,
): FoundChatMessages {
    val request = SearchChatMessages(chatId, topicId, query, senderId, fromMessageId, offset, limit, filter)
    val requestJson = tdJson.encodeToString(SearchChatMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundChatMessages.serializer(), responseJson)
}

/**
 * Searches for messages in all chats except secret chats. Returns the results in reverse chronological order (i.e., in order of decreasing (date, chat_id, message_id)). For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param chatList Chat list in which to search messages; pass null to search in all chats regardless of their chat list. Only Main and Archive chat lists are supported
 * @param query Query to search for
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages to be returned; up to 100. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param filter Additional filter for messages to search; pass null to search for all messages. Filters searchMessagesFilterMention, searchMessagesFilterUnreadMention, searchMessagesFilterUnreadReaction, searchMessagesFilterUnreadPollVote, searchMessagesFilterFailedToSend, and searchMessagesFilterPinned are unsupported in this function
 * @param chatTypeFilter Additional filter for type of the chat of the searched messages; pass null to search for messages in all chats
 * @param minDate If not 0, the minimum date of the messages to return
 * @param maxDate If not 0, the maximum date of the messages to return
 */
suspend fun TdKtxClient.searchMessages(
    chatList: ChatList? = null,
    query: String? = null,
    offset: String? = null,
    limit: Int,
    filter: SearchMessagesFilter? = null,
    chatTypeFilter: SearchMessagesChatTypeFilter? = null,
    minDate: Int,
    maxDate: Int,
): FoundMessages {
    val request = SearchMessages(chatList, query, offset, limit, filter, chatTypeFilter, minDate, maxDate)
    val requestJson = tdJson.encodeToString(SearchMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundMessages.serializer(), responseJson)
}

/**
 * Searches for messages in secret chats. Returns the results in reverse chronological order. For optimal performance, the number of returned messages is chosen by TDLib
 * @param chatId Identifier of the chat in which to search. Specify 0 to search in all secret chats
 * @param query Query to search for. If empty, searchChatMessages must be used instead
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages to be returned; up to 100. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param filter Additional filter for messages to search; pass null to search for all messages
 */
suspend fun TdKtxClient.searchSecretMessages(
    chatId: Long,
    query: String? = null,
    offset: String? = null,
    limit: Int,
    filter: SearchMessagesFilter? = null,
): FoundMessages {
    val request = SearchSecretMessages(chatId, query, offset, limit, filter)
    val requestJson = tdJson.encodeToString(SearchSecretMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundMessages.serializer(), responseJson)
}

/**
 * Searches for messages tagged by the given reaction and with the given words in the Saved Messages chat; for Telegram Premium users only. Returns the results in reverse chronological order, i.e. in order of decreasing message_id. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param savedMessagesTopicId If not 0, only messages in the specified Saved Messages topic will be considered; pass 0 to consider all messages
 * @param tag Tag to search for; pass null to return all suitable messages
 * @param query Query to search for
 * @param fromMessageId Identifier of the message starting from which messages must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number to get the specified message and some newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.searchSavedMessages(
    savedMessagesTopicId: Long,
    tag: ReactionType? = null,
    query: String? = null,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
): FoundChatMessages {
    val request = SearchSavedMessages(savedMessagesTopicId, tag, query, fromMessageId, offset, limit)
    val requestJson = tdJson.encodeToString(SearchSavedMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundChatMessages.serializer(), responseJson)
}

/**
 * Searches for call and group call messages. Returns the results in reverse chronological order (i.e., in order of decreasing message_id). For optimal performance, the number of returned messages is chosen by TDLib
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages to be returned; up to 100. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param onlyMissed Pass true to search only for messages with missed/declined calls
 */
suspend fun TdKtxClient.searchCallMessages(
    offset: String? = null,
    limit: Int,
    onlyMissed: Boolean,
): FoundMessages {
    val request = SearchCallMessages(offset, limit, onlyMissed)
    val requestJson = tdJson.encodeToString(SearchCallMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundMessages.serializer(), responseJson)
}

/**
 * Searches for outgoing messages with content of the type messageDocument in all chats except secret chats. Returns the results in reverse chronological order
 * @param query Query to search for in document file name and message caption
 * @param limit The maximum number of messages to be returned; up to 100
 */
suspend fun TdKtxClient.searchOutgoingDocumentMessages(
    query: String? = null,
    limit: Int,
): FoundMessages {
    val request = SearchOutgoingDocumentMessages(query, limit)
    val requestJson = tdJson.encodeToString(SearchOutgoingDocumentMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundMessages.serializer(), responseJson)
}

/**
 * Checks public post search limits without actually performing the search @query Query that will be searched for
 */
suspend fun TdKtxClient.getPublicPostSearchLimits(
    query: String? = null,
): PublicPostSearchLimits {
    val request = GetPublicPostSearchLimits(query)
    val requestJson = tdJson.encodeToString(GetPublicPostSearchLimits.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PublicPostSearchLimits.serializer(), responseJson)
}

/**
 * Searches for public channel posts using the given query. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param query Query to search for
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages to be returned; up to 100. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param starCount The Telegram Star amount the user agreed to pay for the search; pass 0 for free searches
 */
suspend fun TdKtxClient.searchPublicPosts(
    query: String? = null,
    offset: String? = null,
    limit: Int,
    starCount: Long,
): FoundPublicPosts {
    val request = SearchPublicPosts(query, offset, limit, starCount)
    val requestJson = tdJson.encodeToString(SearchPublicPosts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundPublicPosts.serializer(), responseJson)
}

/**
 * Searches for public channel posts containing the given hashtag or cashtag. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 * @param tag Hashtag or cashtag to search for
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages to be returned; up to 100. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.searchPublicMessagesByTag(
    tag: String? = null,
    offset: String? = null,
    limit: Int,
): FoundMessages {
    val request = SearchPublicMessagesByTag(tag, offset, limit)
    val requestJson = tdJson.encodeToString(SearchPublicMessagesByTag.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundMessages.serializer(), responseJson)
}

/**
 * Searches for public stories containing the given hashtag or cashtag. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 * @param storyPosterChatId Identifier of the chat that posted the stories to search for; pass 0 to search stories in all chats
 * @param tag Hashtag or cashtag to search for
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of stories to be returned; up to 100. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.searchPublicStoriesByTag(
    storyPosterChatId: Long,
    tag: String? = null,
    offset: String? = null,
    limit: Int,
): FoundStories {
    val request = SearchPublicStoriesByTag(storyPosterChatId, tag, offset, limit)
    val requestJson = tdJson.encodeToString(SearchPublicStoriesByTag.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundStories.serializer(), responseJson)
}

/**
 * Searches for public stories by the given address location. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 * @param address Address of the location
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of stories to be returned; up to 100. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.searchPublicStoriesByLocation(
    address: LocationAddress? = null,
    offset: String? = null,
    limit: Int,
): FoundStories {
    val request = SearchPublicStoriesByLocation(address, offset, limit)
    val requestJson = tdJson.encodeToString(SearchPublicStoriesByLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundStories.serializer(), responseJson)
}

/**
 * Searches for public stories from the given venue. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 * @param venueProvider Provider of the venue
 * @param venueId Identifier of the venue in the provider database
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of stories to be returned; up to 100. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.searchPublicStoriesByVenue(
    venueProvider: String? = null,
    venueId: String? = null,
    offset: String? = null,
    limit: Int,
): FoundStories {
    val request = SearchPublicStoriesByVenue(venueProvider, venueId, offset, limit)
    val requestJson = tdJson.encodeToString(SearchPublicStoriesByVenue.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundStories.serializer(), responseJson)
}

/**
 * Returns recently searched for hashtags or cashtags by their prefix @tag_prefix Prefix of hashtags or cashtags to return @limit The maximum number of items to be returned
 */
suspend fun TdKtxClient.getSearchedForTags(
    tagPrefix: String? = null,
    limit: Int,
): Hashtags {
    val request = GetSearchedForTags(tagPrefix, limit)
    val requestJson = tdJson.encodeToString(GetSearchedForTags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Hashtags.serializer(), responseJson)
}

/**
 * Removes a hashtag or a cashtag from the list of recently searched for hashtags or cashtags @tag Hashtag or cashtag to delete
 */
suspend fun TdKtxClient.removeSearchedForTag(
    tag: String? = null,
): Ok {
    val request = RemoveSearchedForTag(tag)
    val requestJson = tdJson.encodeToString(RemoveSearchedForTag.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Clears the list of recently searched for hashtags or cashtags @clear_cashtags Pass true to clear the list of recently searched for cashtags; otherwise, the list of recently searched for hashtags will be cleared
 */
suspend fun TdKtxClient.clearSearchedForTags(
    clearCashtags: Boolean,
): Ok {
    val request = ClearSearchedForTags(clearCashtags)
    val requestJson = tdJson.encodeToString(ClearSearchedForTags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all call messages @revoke Pass true to delete the messages for all users
 */
suspend fun TdKtxClient.deleteAllCallMessages(
    revoke: Boolean,
): Ok {
    val request = DeleteAllCallMessages(revoke)
    val requestJson = tdJson.encodeToString(DeleteAllCallMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about the recent live locations of chat members that were sent to the chat. Returns at most one live location message per user @chat_id Chat identifier @limit The maximum number of messages to be returned
 */
suspend fun TdKtxClient.searchChatRecentLocationMessages(
    chatId: Long,
    limit: Int,
): Messages {
    val request = SearchChatRecentLocationMessages(chatId, limit)
    val requestJson = tdJson.encodeToString(SearchChatRecentLocationMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns the last message sent in a chat no later than the specified date. Returns a 404 error if such message doesn't exist
 * @param chatId Chat identifier
 * @param date Point in time (Unix timestamp) relative to which to search for messages
 */
suspend fun TdKtxClient.getChatMessageByDate(
    chatId: Long,
    date: Int,
): Message {
    val request = GetChatMessageByDate(chatId, date)
    val requestJson = tdJson.encodeToString(GetChatMessageByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Returns sparse positions of messages of the specified type in the chat to be used for Shared Media scroll implementation. Returns the results in reverse chronological order (i.e., in order of decreasing message_id). Cannot be used in secret chats or with searchMessagesFilterFailedToSend filter without an enabled message database
 * @param chatId Identifier of the chat in which to return information about message positions
 * @param filter Filter for message content. Filters searchMessagesFilterEmpty, searchMessagesFilterMention, searchMessagesFilterUnreadMention, searchMessagesFilterUnreadReaction, and searchMessagesFilterUnreadPollVote are unsupported in this function
 * @param fromMessageId The message identifier from which to return information about message positions
 * @param limit The expected number of message positions to be returned; 50-2000. A smaller number of positions can be returned, if there are not enough appropriate messages
 * @param savedMessagesTopicId If not 0, only messages in the specified Saved Messages topic will be considered; pass 0 to consider all messages, or for chats other than Saved Messages
 */
suspend fun TdKtxClient.getChatSparseMessagePositions(
    chatId: Long,
    filter: SearchMessagesFilter? = null,
    fromMessageId: Long,
    limit: Int,
    savedMessagesTopicId: Long,
): MessagePositions {
    val request = GetChatSparseMessagePositions(chatId, filter, fromMessageId, limit, savedMessagesTopicId)
    val requestJson = tdJson.encodeToString(GetChatSparseMessagePositions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessagePositions.serializer(), responseJson)
}

/**
 * Returns information about the next messages of the specified type in the chat split by days. Returns the results in reverse chronological order. Can return partial result for the last returned day. Behavior of this method depends on the value of the option "utc_time_offset"
 * @param chatId Identifier of the chat in which to return information about messages
 * @param topicId Pass topic identifier to get the result only in specific topic; pass null to get the result in all topics; forum topics and message threads aren't supported
 * @param filter Filter for message content. Filters searchMessagesFilterEmpty, searchMessagesFilterMention, searchMessagesFilterUnreadMention, searchMessagesFilterUnreadReaction, and searchMessagesFilterUnreadPollVote are unsupported in this function
 * @param fromMessageId The message identifier from which to return information about messages; use 0 to get results from the last message
 */
suspend fun TdKtxClient.getChatMessageCalendar(
    chatId: Long,
    topicId: MessageTopic? = null,
    filter: SearchMessagesFilter? = null,
    fromMessageId: Long,
): MessageCalendar {
    val request = GetChatMessageCalendar(chatId, topicId, filter, fromMessageId)
    val requestJson = tdJson.encodeToString(GetChatMessageCalendar.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageCalendar.serializer(), responseJson)
}

/**
 * Returns approximate number of messages of the specified type in the chat or its topic
 * @param chatId Identifier of the chat in which to count messages
 * @param topicId Pass topic identifier to get number of messages only in specific topic; pass null to get number of messages in all topics; message threads aren't supported
 * @param filter Filter for message content; searchMessagesFilterEmpty is unsupported in this function
 * @param returnLocal Pass true to get the number of messages without sending network requests, or -1 if the number of messages is unknown locally
 */
suspend fun TdKtxClient.getChatMessageCount(
    chatId: Long,
    topicId: MessageTopic? = null,
    filter: SearchMessagesFilter? = null,
    returnLocal: Boolean,
): Count {
    val request = GetChatMessageCount(chatId, topicId, filter, returnLocal)
    val requestJson = tdJson.encodeToString(GetChatMessageCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Returns approximate 1-based position of a message among messages, which can be found by the specified filter in the chat and topic. Cannot be used in secret chats
 * @param chatId Identifier of the chat in which to find message position
 * @param topicId Pass topic identifier to get position among messages only in specific topic; pass null to get position among all chat messages; message threads aren't supported
 * @param filter Filter for message content; searchMessagesFilterEmpty, searchMessagesFilterUnreadMention, searchMessagesFilterUnreadReaction, searchMessagesFilterUnreadPollVote, and searchMessagesFilterFailedToSend are unsupported in this function
 * @param messageId Message identifier
 */
suspend fun TdKtxClient.getChatMessagePosition(
    chatId: Long,
    topicId: MessageTopic? = null,
    filter: SearchMessagesFilter? = null,
    messageId: Long,
): Count {
    val request = GetChatMessagePosition(chatId, topicId, filter, messageId)
    val requestJson = tdJson.encodeToString(GetChatMessagePosition.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Returns all scheduled messages in a chat. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id) @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatScheduledMessages(
    chatId: Long,
): Messages {
    val request = GetChatScheduledMessages(chatId)
    val requestJson = tdJson.encodeToString(GetChatScheduledMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns sponsored messages to be shown in a chat; for channel chats and chats with bots only @chat_id Identifier of the chat
 */
suspend fun TdKtxClient.getChatSponsoredMessages(
    chatId: Long,
): SponsoredMessages {
    val request = GetChatSponsoredMessages(chatId)
    val requestJson = tdJson.encodeToString(GetChatSponsoredMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(SponsoredMessages.serializer(), responseJson)
}

/**
 * Informs TDLib that the user opened the sponsored chat via the button, the name, the chat photo, a mention in the sponsored message text, or the media in the sponsored message
 * @param chatId Chat identifier of the sponsored message
 * @param messageId Identifier of the sponsored message
 * @param isMediaClick Pass true if the media was clicked in the sponsored message
 * @param fromFullscreen Pass true if the user expanded the video from the sponsored message fullscreen before the click
 */
suspend fun TdKtxClient.clickChatSponsoredMessage(
    chatId: Long,
    messageId: Long,
    isMediaClick: Boolean,
    fromFullscreen: Boolean,
): Ok {
    val request = ClickChatSponsoredMessage(chatId, messageId, isMediaClick, fromFullscreen)
    val requestJson = tdJson.encodeToString(ClickChatSponsoredMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports a sponsored message to Telegram moderators
 * @param chatId Chat identifier of the sponsored message
 * @param messageId Identifier of the sponsored message
 * @param optionId Option identifier chosen by the user; leave empty for the initial request
 */
suspend fun TdKtxClient.reportChatSponsoredMessage(
    chatId: Long,
    messageId: Long,
    optionId: String? = null,
): ReportSponsoredResult {
    val request = ReportChatSponsoredMessage(chatId, messageId, optionId)
    val requestJson = tdJson.encodeToString(ReportChatSponsoredMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReportSponsoredResult.serializer(), responseJson)
}

/**
 * Returns sponsored chats to be shown in the search results @query Query the user searches for
 */
suspend fun TdKtxClient.getSearchSponsoredChats(
    query: String? = null,
): SponsoredChats {
    val request = GetSearchSponsoredChats(query)
    val requestJson = tdJson.encodeToString(GetSearchSponsoredChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(SponsoredChats.serializer(), responseJson)
}

/**
 * Informs TDLib that the user fully viewed a sponsored chat @sponsored_chat_unique_id Unique identifier of the sponsored chat
 */
suspend fun TdKtxClient.viewSponsoredChat(
    sponsoredChatUniqueId: Long,
): Ok {
    val request = ViewSponsoredChat(sponsoredChatUniqueId)
    val requestJson = tdJson.encodeToString(ViewSponsoredChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the user opened a sponsored chat @sponsored_chat_unique_id Unique identifier of the sponsored chat
 */
suspend fun TdKtxClient.openSponsoredChat(
    sponsoredChatUniqueId: Long,
): Ok {
    val request = OpenSponsoredChat(sponsoredChatUniqueId)
    val requestJson = tdJson.encodeToString(OpenSponsoredChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports a sponsored chat to Telegram moderators
 * @param sponsoredChatUniqueId Unique identifier of the sponsored chat
 * @param optionId Option identifier chosen by the user; leave empty for the initial request
 */
suspend fun TdKtxClient.reportSponsoredChat(
    sponsoredChatUniqueId: Long,
    optionId: String? = null,
): ReportSponsoredResult {
    val request = ReportSponsoredChat(sponsoredChatUniqueId, optionId)
    val requestJson = tdJson.encodeToString(ReportSponsoredChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReportSponsoredResult.serializer(), responseJson)
}

/**
 * Returns advertisements to be shown while a video from a message is watched. Available only if messageProperties.can_get_video_advertisements
 * @param chatId Identifier of the chat with the message
 * @param messageId Identifier of the message
 */
suspend fun TdKtxClient.getVideoMessageAdvertisements(
    chatId: Long,
    messageId: Long,
): VideoMessageAdvertisements {
    val request = GetVideoMessageAdvertisements(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetVideoMessageAdvertisements.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(VideoMessageAdvertisements.serializer(), responseJson)
}

/**
 * Informs TDLib that the user viewed a video message advertisement @advertisement_unique_id Unique identifier of the advertisement
 */
suspend fun TdKtxClient.viewVideoMessageAdvertisement(
    advertisementUniqueId: Long,
): Ok {
    val request = ViewVideoMessageAdvertisement(advertisementUniqueId)
    val requestJson = tdJson.encodeToString(ViewVideoMessageAdvertisement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the user clicked a video message advertisement @advertisement_unique_id Unique identifier of the advertisement
 */
suspend fun TdKtxClient.clickVideoMessageAdvertisement(
    advertisementUniqueId: Long,
): Ok {
    val request = ClickVideoMessageAdvertisement(advertisementUniqueId)
    val requestJson = tdJson.encodeToString(ClickVideoMessageAdvertisement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports a video message advertisement to Telegram moderators
 * @param advertisementUniqueId Unique identifier of the advertisement
 * @param optionId Option identifier chosen by the user; leave empty for the initial request
 */
suspend fun TdKtxClient.reportVideoMessageAdvertisement(
    advertisementUniqueId: Long,
    optionId: String? = null,
): ReportSponsoredResult {
    val request = ReportVideoMessageAdvertisement(advertisementUniqueId, optionId)
    val requestJson = tdJson.encodeToString(ReportVideoMessageAdvertisement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReportSponsoredResult.serializer(), responseJson)
}

/**
 * Removes an active notification from notification list. Needs to be called only if the notification is removed by the current user @notification_group_id Identifier of notification group to which the notification belongs @notification_id Identifier of removed notification
 */
suspend fun TdKtxClient.removeNotification(
    notificationGroupId: Int,
    notificationId: Int,
): Ok {
    val request = RemoveNotification(notificationGroupId, notificationId)
    val requestJson = tdJson.encodeToString(RemoveNotification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a group of active notifications. Needs to be called only if the notification group is removed by the current user @notification_group_id Notification group identifier @max_notification_id The maximum identifier of removed notifications
 */
suspend fun TdKtxClient.removeNotificationGroup(
    notificationGroupId: Int,
    maxNotificationId: Int,
): Ok {
    val request = RemoveNotificationGroup(notificationGroupId, maxNotificationId)
    val requestJson = tdJson.encodeToString(RemoveNotificationGroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns an HTTPS link to a message in a chat. Available only if messageProperties.can_get_link, or if messageProperties.can_get_media_timestamp_links and a media timestamp link is generated. This is an offline method
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param mediaTimestamp If not 0, timestamp from which the video/audio/video note/voice note/story playing must start, in seconds. The media can be in the message content or in its link preview
 * @param checklistTaskId If not 0, identifier of the checklist task in the message to be linked
 * @param pollOptionId If not empty, identifier of the poll option in the message to be linked
 * @param forAlbum Pass true to create a link for the whole media album
 * @param inMessageThread Pass true to create a link to the message as a channel post comment, in a message thread, or a forum topic
 */
suspend fun TdKtxClient.getMessageLink(
    chatId: Long,
    messageId: Long,
    mediaTimestamp: Int,
    checklistTaskId: Int,
    pollOptionId: String? = null,
    forAlbum: Boolean,
    inMessageThread: Boolean,
): MessageLink {
    val request = GetMessageLink(chatId, messageId, mediaTimestamp, checklistTaskId, pollOptionId, forAlbum, inMessageThread)
    val requestJson = tdJson.encodeToString(GetMessageLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageLink.serializer(), responseJson)
}

/**
 * Returns an HTML code for embedding the message. Available only if messageProperties.can_get_embedding_code
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param forAlbum Pass true to return an HTML code for embedding of the whole media album
 */
suspend fun TdKtxClient.getMessageEmbeddingCode(
    chatId: Long,
    messageId: Long,
    forAlbum: Boolean,
): Text {
    val request = GetMessageEmbeddingCode(chatId, messageId, forAlbum)
    val requestJson = tdJson.encodeToString(GetMessageEmbeddingCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns information about a public or private message link. Can be called for any internal link of the type internalLinkTypeMessage @url The message link
 */
suspend fun TdKtxClient.getMessageLinkInfo(
    url: String? = null,
): MessageLinkInfo {
    val request = GetMessageLinkInfo(url)
    val requestJson = tdJson.encodeToString(GetMessageLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageLinkInfo.serializer(), responseJson)
}

/**
 * Creates a custom text composition style. May return an error with a message "TONES_SAVED_TOO_MANY" if the maximum number of added custom styles has been reached
 * @param title Title of the style; 1-getOption("text_composition_style_title_length_max") characters
 * @param customEmojiId Identifier of the custom emoji corresponding to the style
 * @param prompt Prompt that will be used for text composition; 1-getOption("text_composition_style_prompt_length_max") characters
 * @param showCreator Pass true if the current user must be shown as the creator of the style
 */
suspend fun TdKtxClient.createTextCompositionStyle(
    title: String? = null,
    customEmojiId: Long,
    prompt: String? = null,
    showCreator: Boolean,
): TextCompositionStyle {
    val request = CreateTextCompositionStyle(title, customEmojiId, prompt, showCreator)
    val requestJson = tdJson.encodeToString(CreateTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TextCompositionStyle.serializer(), responseJson)
}

/**
 * Edits a custom text composition style that was created by the current user
 * @param name Name of the style
 * @param title Title of the style; 1-getOption("text_composition_style_title_length_max") characters
 * @param customEmojiId Identifier of the custom emoji corresponding to the style
 * @param prompt Prompt that will be used for text composition; 1-getOption("text_composition_style_prompt_length_max") characters
 * @param showCreator Pass true if the current user must be shown as the creator of the style
 */
suspend fun TdKtxClient.editTextCompositionStyle(
    name: String? = null,
    title: String? = null,
    customEmojiId: Long,
    prompt: String? = null,
    showCreator: Boolean,
): TextCompositionStyle {
    val request = EditTextCompositionStyle(name, title, customEmojiId, prompt, showCreator)
    val requestJson = tdJson.encodeToString(EditTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TextCompositionStyle.serializer(), responseJson)
}

/**
 * Deletes a custom text composition style that was created by the current user
 * @param name Name of the style
 */
suspend fun TdKtxClient.deleteTextCompositionStyle(
    name: String? = null,
): Ok {
    val request = DeleteTextCompositionStyle(name)
    val requestJson = tdJson.encodeToString(DeleteTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches a custom text composition style by its name @name Name of the style
 */
suspend fun TdKtxClient.searchTextCompositionStyle(
    name: String? = null,
): TextCompositionStyle {
    val request = SearchTextCompositionStyle(name)
    val requestJson = tdJson.encodeToString(SearchTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TextCompositionStyle.serializer(), responseJson)
}

/**
 * Returns an example of usage of a custom text composition style
 * @param name Name of the style
 * @param exampleNumber 0-based unique number of the requested example; must be non-negative and less than getOption("text_composition_style_example_count")
 */
suspend fun TdKtxClient.getTextCompositionStyleExample(
    name: String? = null,
    exampleNumber: Int,
): TextCompositionStyleExample {
    val request = GetTextCompositionStyleExample(name, exampleNumber)
    val requestJson = tdJson.encodeToString(GetTextCompositionStyleExample.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TextCompositionStyleExample.serializer(), responseJson)
}

/**
 * Adds a custom text composition style to the list of used by the user styles. May return an error with a message "TONES_SAVED_TOO_MANY" if the maximum number of added custom styles has been reached
 * @param name Name of the style
 */
suspend fun TdKtxClient.addTextCompositionStyle(
    name: String? = null,
): Ok {
    val request = AddTextCompositionStyle(name)
    val requestJson = tdJson.encodeToString(AddTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a custom text composition style from the list of used by the user styles. If the style was created by the current user, then it can only be deleted
 * @param name Name of the style
 */
suspend fun TdKtxClient.removeTextCompositionStyle(
    name: String? = null,
): Ok {
    val request = RemoveTextCompositionStyle(name)
    val requestJson = tdJson.encodeToString(RemoveTextCompositionStyle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Translates a text to the given language; must not be used in secret chats. If the current user is a Telegram Premium user, then text formatting is preserved
 * @param text Text to translate
 * @param toLanguageCode Language code of the language to which the message is translated. Must be one of "af", "sq", "am", "ar", "hy", "az", "eu", "be", "bn", "bs", "bg", "ca", "ceb", "zh-CN", "zh", "zh-Hans", "zh-TW", "zh-Hant", "co", "hr", "cs", "da", "nl", "en", "eo", "et", "fi", "fr", "fy", "gl", "ka", "de", "el", "gu", "ht", "ha", "haw", "he", "iw", "hi", "hmn", "hu", "is", "ig", "id", "in", "ga", "it", "ja", "jv", "kn", "kk", "km", "rw", "ko", "ku", "ky", "lo", "la", "lv", "lt", "lb", "mk", "mg", "ms", "ml", "mt", "mi", "mr", "mn", "my", "ne", "no", "ny", "or", "ps", "fa", "pl", "pt", "pt-BR", "pa", "ro", "ru", "sm", "gd", "sr", "st", "sn", "sd", "si", "sk", "sl", "so", "es", "su", "sw", "sv", "tl", "tg", "ta", "tt", "te", "th", "tr", "tk", "uk", "ur", "ug", "uz", "vi", "cy", "xh", "yi", "ji", "yo", "zu"
 * @param tone Tone of the translation; must be one of "", "formal", "neutral", "casual"; defaults to "neutral"
 */
suspend fun TdKtxClient.translateText(
    text: FormattedText? = null,
    toLanguageCode: String? = null,
    tone: String? = null,
): FormattedText {
    val request = TranslateText(text, toLanguageCode, tone)
    val requestJson = tdJson.encodeToString(TranslateText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Extracts text or caption of the given message and translates it to the given language; must not be used in secret chats. If the current user is a Telegram Premium user, then text formatting is preserved
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param toLanguageCode Language code of the language to which the message is translated. See translateText.to_language_code for the list of supported values
 * @param tone Tone of the translation; see translateText.tone for the list of supported values
 */
suspend fun TdKtxClient.translateMessageText(
    chatId: Long,
    messageId: Long,
    toLanguageCode: String? = null,
    tone: String? = null,
): FormattedText {
    val request = TranslateMessageText(chatId, messageId, toLanguageCode, tone)
    val requestJson = tdJson.encodeToString(TranslateMessageText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Summarizes content of the message with non-empty summary_language_code
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param translateToLanguageCode Pass a language code to which the summary will be translated; pass an empty string if translation isn't needed. See translateText.to_language_code for the list of supported values
 * @param tone Tone of the summarization; see translateText.tone for the list of supported values
 */
suspend fun TdKtxClient.summarizeMessage(
    chatId: Long,
    messageId: Long,
    translateToLanguageCode: String? = null,
    tone: String? = null,
): FormattedText {
    val request = SummarizeMessage(chatId, messageId, translateToLanguageCode, tone)
    val requestJson = tdJson.encodeToString(SummarizeMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Changes text using an AI model; must not be used in secret chats. May return an error with a message "AICOMPOSE_FLOOD_PREMIUM" if Telegram Premium is required to send further requests
 * @param text The original text
 * @param translateToLanguageCode Pass a language code to which the text will be translated; pass an empty string if translation isn't needed. See translateText.to_language_code for the list of supported values
 * @param styleName Name of the style of the resulted text; handle updateTextCompositionStyles to get the list of supported styles; pass an empty string to keep the current style of the text
 * @param addEmojis Pass true to add emoji to the text
 */
suspend fun TdKtxClient.composeTextWithAi(
    text: FormattedText? = null,
    translateToLanguageCode: String? = null,
    styleName: String? = null,
    addEmojis: Boolean,
): FormattedText {
    val request = ComposeTextWithAi(text, translateToLanguageCode, styleName, addEmojis)
    val requestJson = tdJson.encodeToString(ComposeTextWithAi.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Fixes text using an AI model; must not be used in secret chats. May return an error with a message "AICOMPOSE_FLOOD_PREMIUM" if Telegram Premium is required to send further requests
 * @param text The original text
 */
suspend fun TdKtxClient.fixTextWithAi(
    text: FormattedText? = null,
): FixedText {
    val request = FixTextWithAi(text)
    val requestJson = tdJson.encodeToString(FixTextWithAi.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FixedText.serializer(), responseJson)
}

/**
 * Recognizes speech in a video note or a voice note message
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message. Use messageProperties.can_recognize_speech to check whether the message is suitable
 */
suspend fun TdKtxClient.recognizeSpeech(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = RecognizeSpeech(chatId, messageId)
    val requestJson = tdJson.encodeToString(RecognizeSpeech.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Rates recognized speech in a video note or a voice note message @chat_id Identifier of the chat to which the message belongs @message_id Identifier of the message @is_good Pass true if the speech recognition is good
 */
suspend fun TdKtxClient.rateSpeechRecognition(
    chatId: Long,
    messageId: Long,
    isGood: Boolean,
): Ok {
    val request = RateSpeechRecognition(chatId, messageId, isGood)
    val requestJson = tdJson.encodeToString(RateSpeechRecognition.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of message sender identifiers, which can be used to send messages in a chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatAvailableMessageSenders(
    chatId: Long,
): ChatMessageSenders {
    val request = GetChatAvailableMessageSenders(chatId)
    val requestJson = tdJson.encodeToString(GetChatAvailableMessageSenders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatMessageSenders.serializer(), responseJson)
}

/**
 * Selects a message sender to send messages in a chat @chat_id Chat identifier @message_sender_id New message sender for the chat
 */
suspend fun TdKtxClient.setChatMessageSender(
    chatId: Long,
    messageSenderId: MessageSender? = null,
): Ok {
    val request = SetChatMessageSender(chatId, messageSenderId)
    val requestJson = tdJson.encodeToString(SetChatMessageSender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a message. Returns the sent message
 * @param chatId Target chat
 * @param topicId Topic in which the message will be sent; pass null if none
 * @param replyTo Information about the message or story to be replied; pass null if none
 * @param options Options to be used to send the message; pass null to use default options
 * @param replyMarkup Markup for replying to the message; pass null if none; for bots only
 * @param inputMessageContent The content of the message to be sent
 */
suspend fun TdKtxClient.sendMessage(
    chatId: Long,
    topicId: MessageTopic? = null,
    replyTo: InputMessageReplyTo? = null,
    options: MessageSendOptions? = null,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): Message {
    val request = SendMessage(chatId, topicId, replyTo, options, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(SendMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Sends 2-10 messages grouped together into an album. Currently, only audio, document, photo and video messages can be grouped into an album. Documents and audio files can be only grouped in an album with messages of the same type. Returns sent messages
 * @param chatId Target chat
 * @param topicId Topic in which the messages will be sent; pass null if none
 * @param replyTo Information about the message or story to be replied; pass null if none
 * @param options Options to be used to send the messages; pass null to use default options
 * @param inputMessageContents Contents of messages to be sent. At most 10 messages can be added to an album. All messages must have the same value of show_caption_above_media
 */
suspend fun TdKtxClient.sendMessageAlbum(
    chatId: Long,
    topicId: MessageTopic? = null,
    replyTo: InputMessageReplyTo? = null,
    options: MessageSendOptions? = null,
    inputMessageContents: List<InputMessageContent>? = null,
): Messages {
    val request = SendMessageAlbum(chatId, topicId, replyTo, options, inputMessageContents)
    val requestJson = tdJson.encodeToString(SendMessageAlbum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Invites a bot to a chat (if it is not yet a member) and sends it the /start command; requires can_invite_users member right. Bots can't be invited to a private chat other than the chat with the bot. Bots can't be invited to channels (although they can be added as admins) and secret chats. Returns the sent message
 * @param botUserId Identifier of the bot
 * @param chatId Identifier of the target chat
 * @param parameter A hidden parameter sent to the bot for deep linking purposes (https://core.telegram.org/bots#deep-linking)
 */
suspend fun TdKtxClient.sendBotStartMessage(
    botUserId: Long,
    chatId: Long,
    parameter: String? = null,
): Message {
    val request = SendBotStartMessage(botUserId, chatId, parameter)
    val requestJson = tdJson.encodeToString(SendBotStartMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Sends the result of an inline query as a message. Returns the sent message. Always clears a chat draft message
 * @param chatId Target chat
 * @param topicId Topic in which the message will be sent; pass null if none
 * @param replyTo Information about the message or story to be replied; pass null if none
 * @param options Options to be used to send the message; pass null to use default options
 * @param queryId Identifier of the inline query
 * @param resultId Identifier of the inline query result
 * @param hideViaBot Pass true to hide the bot, via which the message is sent. Can be used only for bots getOption("animation_search_bot_username"), getOption("photo_search_bot_username"), and getOption("venue_search_bot_username")
 */
suspend fun TdKtxClient.sendInlineQueryResultMessage(
    chatId: Long,
    topicId: MessageTopic? = null,
    replyTo: InputMessageReplyTo? = null,
    options: MessageSendOptions? = null,
    queryId: Long,
    resultId: String? = null,
    hideViaBot: Boolean,
): Message {
    val request = SendInlineQueryResultMessage(chatId, topicId, replyTo, options, queryId, resultId, hideViaBot)
    val requestJson = tdJson.encodeToString(SendInlineQueryResultMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Forwards previously sent messages. Returns the forwarded messages in the same order as the message identifiers passed in message_ids. If a message can't be forwarded, null will be returned instead of the message
 * @param chatId Identifier of the chat to which to forward messages
 * @param topicId Topic in which the messages will be forwarded; message threads aren't supported; pass null if none
 * @param fromChatId Identifier of the chat from which to forward messages
 * @param messageIds Identifiers of the messages to forward. Message identifiers must be in a strictly increasing order. At most 100 messages can be forwarded simultaneously. A message can be forwarded only if messageProperties.can_be_forwarded
 * @param options Options to be used to send the messages; pass null to use default options
 * @param sendCopy Pass true to copy content of the messages without reference to the original sender. Always true if the messages are forwarded to a secret chat or are local. Use messageProperties.can_be_copied and messageProperties.can_be_copied_to_secret_chat to check whether the message is suitable
 * @param removeCaption Pass true to remove media captions of message copies. Ignored if send_copy is false
 */
suspend fun TdKtxClient.forwardMessages(
    chatId: Long,
    topicId: MessageTopic? = null,
    fromChatId: Long,
    messageIds: List<Long>? = null,
    options: MessageSendOptions? = null,
    sendCopy: Boolean,
    removeCaption: Boolean,
): Messages {
    val request = ForwardMessages(chatId, topicId, fromChatId, messageIds, options, sendCopy, removeCaption)
    val requestJson = tdJson.encodeToString(ForwardMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Sends messages from a quick reply shortcut. Requires Telegram Business subscription. Can't be used to send paid messages
 * @param chatId Identifier of the chat to which to send messages. The chat must be a private chat with a regular user
 * @param shortcutId Unique identifier of the quick reply shortcut
 * @param sendingId Non-persistent identifier, which will be returned back in messageSendingStatePending object and can be used to match sent messages and corresponding updateNewMessage updates
 */
suspend fun TdKtxClient.sendQuickReplyShortcutMessages(
    chatId: Long,
    shortcutId: Int,
    sendingId: Int,
): Messages {
    val request = SendQuickReplyShortcutMessages(chatId, shortcutId, sendingId)
    val requestJson = tdJson.encodeToString(SendQuickReplyShortcutMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Resends messages which failed to send. Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed. If a message is re-sent, the corresponding failed to send message is deleted. Returns the sent messages in the same order as the message identifiers passed in message_ids. If a message can't be re-sent, null will be returned instead of the message
 * @param chatId Identifier of the chat to send messages
 * @param messageIds Identifiers of the messages to resend. Message identifiers must be in a strictly increasing order
 * @param quote New manually chosen quote from the message to be replied; pass null if none. Ignored if more than one message is re-sent, or if messageSendingStateFailed.need_another_reply_quote == false
 * @param paidMessageStarCount The number of Telegram Stars the user agreed to pay to send the messages. Ignored if messageSendingStateFailed.required_paid_message_star_count == 0
 */
suspend fun TdKtxClient.resendMessages(
    chatId: Long,
    messageIds: List<Long>? = null,
    quote: InputTextQuote? = null,
    paidMessageStarCount: Long,
): Messages {
    val request = ResendMessages(chatId, messageIds, quote, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(ResendMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Adds a local message to a chat. The message is persistent across application restarts only if the message database is used. Returns the added message
 * @param chatId Target chat; channel direct messages chats aren't supported
 * @param senderId Identifier of the sender of the message
 * @param replyTo Information about the message or story to be replied; pass null if none
 * @param disableNotification Pass true to disable notification for the message
 * @param inputMessageContent The content of the message to be added
 */
suspend fun TdKtxClient.addLocalMessage(
    chatId: Long,
    senderId: MessageSender? = null,
    replyTo: InputMessageReplyTo? = null,
    disableNotification: Boolean,
    inputMessageContent: InputMessageContent? = null,
): Message {
    val request = AddLocalMessage(chatId, senderId, replyTo, disableNotification, inputMessageContent)
    val requestJson = tdJson.encodeToString(AddLocalMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Deletes messages
 * @param chatId Chat identifier
 * @param messageIds Identifiers of the messages to be deleted. Use messageProperties.can_be_deleted_only_for_self and messageProperties.can_be_deleted_for_all_users to get suitable messages
 * @param revoke Pass true to delete messages for all chat members. Always true for supergroups, channels and secret chats
 */
suspend fun TdKtxClient.deleteMessages(
    chatId: Long,
    messageIds: List<Long>? = null,
    revoke: Boolean,
): Ok {
    val request = DeleteMessages(chatId, messageIds, revoke)
    val requestJson = tdJson.encodeToString(DeleteMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages sent by the specified message sender in a chat. Supported only for supergroups; requires can_delete_messages administrator right @chat_id Chat identifier @sender_id Identifier of the sender of messages to delete
 */
suspend fun TdKtxClient.deleteChatMessagesBySender(
    chatId: Long,
    senderId: MessageSender? = null,
): Ok {
    val request = DeleteChatMessagesBySender(chatId, senderId)
    val requestJson = tdJson.encodeToString(DeleteChatMessagesBySender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages between the specified dates in a chat. Supported only for private chats and basic groups. Messages sent in the last 30 seconds will not be deleted
 * @param chatId Chat identifier
 * @param minDate The minimum date of the messages to delete
 * @param maxDate The maximum date of the messages to delete
 * @param revoke Pass true to delete chat messages for all users; private chats only
 */
suspend fun TdKtxClient.deleteChatMessagesByDate(
    chatId: Long,
    minDate: Int,
    maxDate: Int,
    revoke: Boolean,
): Ok {
    val request = DeleteChatMessagesByDate(chatId, minDate, maxDate, revoke)
    val requestJson = tdJson.encodeToString(DeleteChatMessagesByDate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the text of a message (or a text of a game message). Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_be_edited to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param inputMessageContent New text content of the message. Must be of type inputMessageText or inputMessageRichMessage
 */
suspend fun TdKtxClient.editMessageText(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): Message {
    val request = EditMessageText(chatId, messageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditMessageText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the message content of a live location. Messages can be edited for a limited period of time specified in the live location. Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_be_edited to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param location New live location of the message; pass null to stop sharing the live location. If the new live_period isn't set to 0x7FFFFFFF, then it must not exceed the current live_period by more than a day, and the live location expiration date must remain in the next 90 days
 */
suspend fun TdKtxClient.editMessageLiveLocation(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    location: LiveLocation? = null,
): Message {
    val request = EditMessageLiveLocation(chatId, messageId, replyMarkup, location)
    val requestJson = tdJson.encodeToString(EditMessageLiveLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the message content of a checklist. Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_be_edited to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param checklist The new checklist. If some tasks were completed, this information will be kept
 */
suspend fun TdKtxClient.editMessageChecklist(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    checklist: InputChecklist? = null,
): Message {
    val request = EditMessageChecklist(chatId, messageId, replyMarkup, checklist)
    val requestJson = tdJson.encodeToString(EditMessageChecklist.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the media content of a message, including message caption. If only the caption needs to be edited, use editMessageCaption instead. The type of message content in an album can't be changed with exception of replacing a photo with a video or vice versa. Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_edit_media to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param inputMessageContent New content of the message. Must be one of the following types: inputMessageAnimation, inputMessageAudio, inputMessageDocument, inputMessagePhoto or inputMessageVideo
 */
suspend fun TdKtxClient.editMessageMedia(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): Message {
    val request = EditMessageMedia(chatId, messageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditMessageMedia.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the message content caption. Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_be_edited to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param caption New message content caption; 0-getOption("message_caption_length_max") characters; pass null to remove caption
 * @param showCaptionAboveMedia Pass true to show the caption above the media; otherwise, the caption will be shown below the media. May be true only for animation, photo, and video messages
 */
suspend fun TdKtxClient.editMessageCaption(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null,
    showCaptionAboveMedia: Boolean,
): Message {
    val request = EditMessageCaption(chatId, messageId, replyMarkup, caption, showCaptionAboveMedia)
    val requestJson = tdJson.encodeToString(EditMessageCaption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the message reply markup; for bots only. Returns the edited message after the edit is completed on the server side
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_be_edited to check whether the message can be edited
 * @param replyMarkup The new message reply markup; pass null if none
 */
suspend fun TdKtxClient.editMessageReplyMarkup(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
): Message {
    val request = EditMessageReplyMarkup(chatId, messageId, replyMarkup)
    val requestJson = tdJson.encodeToString(EditMessageReplyMarkup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Edits the text of an inline text or game message sent via a bot; for bots only
 * @param inlineMessageId Inline message identifier
 * @param replyMarkup The new message reply markup; pass null if none
 * @param inputMessageContent New text content of the message. Must be of type inputMessageText or inputMessageRichMessage
 */
suspend fun TdKtxClient.editInlineMessageText(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): Ok {
    val request = EditInlineMessageText(inlineMessageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditInlineMessageText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the content of a live location in an inline message sent via a bot; for bots only
 * @param inlineMessageId Inline message identifier
 * @param replyMarkup The new message reply markup; pass null if none
 * @param location New live location of the message; pass null to stop sharing the live location. If the new live_period isn't set to 0x7FFFFFFF, then it must not exceed the current live_period by more than a day, and the live location expiration date must remain in the next 90 days
 */
suspend fun TdKtxClient.editInlineMessageLiveLocation(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    location: LiveLocation? = null,
): Ok {
    val request = EditInlineMessageLiveLocation(inlineMessageId, replyMarkup, location)
    val requestJson = tdJson.encodeToString(EditInlineMessageLiveLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the media content of a message with a text, an animation, an audio, a document, a photo or a video in an inline message sent via a bot; for bots only
 * @param inlineMessageId Inline message identifier
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param inputMessageContent New content of the message. Must be one of the following types: inputMessageAnimation, inputMessageAudio, inputMessageDocument, inputMessagePhoto or inputMessageVideo
 */
suspend fun TdKtxClient.editInlineMessageMedia(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): Ok {
    val request = EditInlineMessageMedia(inlineMessageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditInlineMessageMedia.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the caption of an inline message sent via a bot; for bots only
 * @param inlineMessageId Inline message identifier
 * @param replyMarkup The new message reply markup; pass null if none
 * @param caption New message content caption; pass null to remove caption; 0-getOption("message_caption_length_max") characters
 * @param showCaptionAboveMedia Pass true to show the caption above the media; otherwise, the caption will be shown below the media. May be true only for animation, photo, and video messages
 */
suspend fun TdKtxClient.editInlineMessageCaption(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null,
    showCaptionAboveMedia: Boolean,
): Ok {
    val request = EditInlineMessageCaption(inlineMessageId, replyMarkup, caption, showCaptionAboveMedia)
    val requestJson = tdJson.encodeToString(EditInlineMessageCaption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the reply markup of an inline message sent via a bot; for bots only
 * @param inlineMessageId Inline message identifier
 * @param replyMarkup The new message reply markup; pass null if none
 */
suspend fun TdKtxClient.editInlineMessageReplyMarkup(
    inlineMessageId: String? = null,
    replyMarkup: ReplyMarkup? = null,
): Ok {
    val request = EditInlineMessageReplyMarkup(inlineMessageId, replyMarkup)
    val requestJson = tdJson.encodeToString(EditInlineMessageReplyMarkup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits the time when a scheduled message will be sent. Scheduling state of all messages in the same album or forwarded together with the message will be also changed
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message. Use messageProperties.can_edit_scheduling_state to check whether the message is suitable
 * @param schedulingState The new message scheduling state; pass null to send the message immediately. Must be null for messages in the state messageSchedulingStateSendWhenVideoProcessed
 */
suspend fun TdKtxClient.editMessageSchedulingState(
    chatId: Long,
    messageId: Long,
    schedulingState: MessageSchedulingState? = null,
): Ok {
    val request = EditMessageSchedulingState(chatId, messageId, schedulingState)
    val requestJson = tdJson.encodeToString(EditMessageSchedulingState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the fact-check of a message. Can be only used if messageProperties.can_set_fact_check == true
 * @param chatId The channel chat the message belongs to
 * @param messageId Identifier of the message
 * @param text New text of the fact-check; 0-getOption("fact_check_length_max") characters; pass null to remove it. Only Bold, Italic, and TextUrl entities with https://t.me/ links are supported
 */
suspend fun TdKtxClient.setMessageFactCheck(
    chatId: Long,
    messageId: Long,
    text: FormattedText? = null,
): Ok {
    val request = SetMessageFactCheck(chatId, messageId, text)
    val requestJson = tdJson.encodeToString(SetMessageFactCheck.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a message on behalf of a business account; for bots only. Returns the message after it was sent
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request
 * @param chatId Target chat
 * @param replyTo Information about the message to be replied; pass null if none
 * @param disableNotification Pass true to disable notification for the message
 * @param protectContent Pass true if the content of the message must be protected from forwarding and saving
 * @param effectId Identifier of the effect to apply to the message
 * @param replyMarkup Markup for replying to the message; pass null if none
 * @param inputMessageContent The content of the message to be sent
 */
suspend fun TdKtxClient.sendBusinessMessage(
    businessConnectionId: String? = null,
    chatId: Long,
    replyTo: InputMessageReplyTo? = null,
    disableNotification: Boolean,
    protectContent: Boolean,
    effectId: Long,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): BusinessMessage {
    val request = SendBusinessMessage(businessConnectionId, chatId, replyTo, disableNotification, protectContent, effectId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(SendBusinessMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Sends 2-10 messages grouped together into an album on behalf of a business account; for bots only. Currently, only audio, document, photo and video messages can be grouped into an album. Documents and audio files can be only grouped in an album with messages of the same type. Returns sent messages
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request
 * @param chatId Target chat
 * @param replyTo Information about the message to be replied; pass null if none
 * @param disableNotification Pass true to disable notification for the message
 * @param protectContent Pass true if the content of the message must be protected from forwarding and saving
 * @param effectId Identifier of the effect to apply to the message
 * @param inputMessageContents Contents of messages to be sent. At most 10 messages can be added to an album. All messages must have the same value of show_caption_above_media
 */
suspend fun TdKtxClient.sendBusinessMessageAlbum(
    businessConnectionId: String? = null,
    chatId: Long,
    replyTo: InputMessageReplyTo? = null,
    disableNotification: Boolean,
    protectContent: Boolean,
    effectId: Long,
    inputMessageContents: List<InputMessageContent>? = null,
): BusinessMessages {
    val request = SendBusinessMessageAlbum(businessConnectionId, chatId, replyTo, disableNotification, protectContent, effectId, inputMessageContents)
    val requestJson = tdJson.encodeToString(SendBusinessMessageAlbum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessages.serializer(), responseJson)
}

/**
 * Edits the text of a text or game message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none
 * @param inputMessageContent New text content of the message. Must be of type inputMessageText or inputMessageRichMessage
 */
suspend fun TdKtxClient.editBusinessMessageText(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): BusinessMessage {
    val request = EditBusinessMessageText(businessConnectionId, chatId, messageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditBusinessMessageText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Edits the content of a live location in a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none
 * @param location New live location of the message; pass null to stop sharing the live location. If the new live_period isn't set to 0x7FFFFFFF, then it must not exceed the current live_period by more than a day, and the live location expiration date must remain in the next 90 days
 */
suspend fun TdKtxClient.editBusinessMessageLiveLocation(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    location: LiveLocation? = null,
): BusinessMessage {
    val request = EditBusinessMessageLiveLocation(businessConnectionId, chatId, messageId, replyMarkup, location)
    val requestJson = tdJson.encodeToString(EditBusinessMessageLiveLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Edits the content of a checklist in a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none
 * @param checklist The new checklist. If some tasks were completed, this information will be kept
 */
suspend fun TdKtxClient.editBusinessMessageChecklist(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    checklist: InputChecklist? = null,
): BusinessMessage {
    val request = EditBusinessMessageChecklist(businessConnectionId, chatId, messageId, replyMarkup, checklist)
    val requestJson = tdJson.encodeToString(EditBusinessMessageChecklist.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Edits the media content of a message with a text, an animation, an audio, a document, a photo or a video in a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 * @param inputMessageContent New content of the message. Must be one of the following types: inputMessageAnimation, inputMessageAudio, inputMessageDocument, inputMessagePhoto or inputMessageVideo
 */
suspend fun TdKtxClient.editBusinessMessageMedia(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    inputMessageContent: InputMessageContent? = null,
): BusinessMessage {
    val request = EditBusinessMessageMedia(businessConnectionId, chatId, messageId, replyMarkup, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditBusinessMessageMedia.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Edits the caption of a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none
 * @param caption New message content caption; pass null to remove caption; 0-getOption("message_caption_length_max") characters
 * @param showCaptionAboveMedia Pass true to show the caption above the media; otherwise, the caption will be shown below the media. May be true only for animation, photo, and video messages
 */
suspend fun TdKtxClient.editBusinessMessageCaption(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
    caption: FormattedText? = null,
    showCaptionAboveMedia: Boolean,
): BusinessMessage {
    val request = EditBusinessMessageCaption(businessConnectionId, chatId, messageId, replyMarkup, caption, showCaptionAboveMedia)
    val requestJson = tdJson.encodeToString(EditBusinessMessageCaption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Edits the reply markup of a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param replyMarkup The new message reply markup; pass null if none
 */
suspend fun TdKtxClient.editBusinessMessageReplyMarkup(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
): BusinessMessage {
    val request = EditBusinessMessageReplyMarkup(businessConnectionId, chatId, messageId, replyMarkup)
    val requestJson = tdJson.encodeToString(EditBusinessMessageReplyMarkup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Stops a poll sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message with the poll was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message containing the poll
 * @param replyMarkup The new message reply markup; pass null if none
 */
suspend fun TdKtxClient.stopBusinessPoll(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
): BusinessMessage {
    val request = StopBusinessPoll(businessConnectionId, chatId, messageId, replyMarkup)
    val requestJson = tdJson.encodeToString(StopBusinessPoll.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessMessage.serializer(), responseJson)
}

/**
 * Pins or unpins a message sent on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which the message was sent
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 * @param isPinned Pass true to pin the message, pass false to unpin it
 */
suspend fun TdKtxClient.setBusinessMessageIsPinned(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
    isPinned: Boolean,
): Ok {
    val request = SetBusinessMessageIsPinned(businessConnectionId, chatId, messageId, isPinned)
    val requestJson = tdJson.encodeToString(SetBusinessMessageIsPinned.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reads a message on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection through which the message was received
 * @param chatId The chat the message belongs to
 * @param messageId Identifier of the message
 */
suspend fun TdKtxClient.readBusinessMessage(
    businessConnectionId: String? = null,
    chatId: Long,
    messageId: Long,
): Ok {
    val request = ReadBusinessMessage(businessConnectionId, chatId, messageId)
    val requestJson = tdJson.encodeToString(ReadBusinessMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes messages on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection through which the messages were received
 * @param messageIds Identifier of the messages
 */
suspend fun TdKtxClient.deleteBusinessMessages(
    businessConnectionId: String? = null,
    messageIds: List<Long>? = null,
): Ok {
    val request = DeleteBusinessMessages(businessConnectionId, messageIds)
    val requestJson = tdJson.encodeToString(DeleteBusinessMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes a story posted by the bot on behalf of a business account; for bots only
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Identifier of the story to edit
 * @param content New content of the story
 * @param areas New clickable rectangle areas to be shown on the story media
 * @param caption New story caption
 * @param privacySettings The new privacy settings for the story
 */
suspend fun TdKtxClient.editBusinessStory(
    storyPosterChatId: Long,
    storyId: Int,
    content: InputStoryContent? = null,
    areas: InputStoryAreas? = null,
    caption: FormattedText? = null,
    privacySettings: StoryPrivacySettings? = null,
): Story {
    val request = EditBusinessStory(storyPosterChatId, storyId, content, areas, caption, privacySettings)
    val requestJson = tdJson.encodeToString(EditBusinessStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Story.serializer(), responseJson)
}

/**
 * Deletes a story posted by the bot on behalf of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param storyId Identifier of the story to delete
 */
suspend fun TdKtxClient.deleteBusinessStory(
    businessConnectionId: String? = null,
    storyId: Int,
): Ok {
    val request = DeleteBusinessStory(businessConnectionId, storyId)
    val requestJson = tdJson.encodeToString(DeleteBusinessStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the first and last name of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param firstName The new value of the first name for the business account; 1-64 characters
 * @param lastName The new value of the optional last name for the business account; 0-64 characters
 */
suspend fun TdKtxClient.setBusinessAccountName(
    businessConnectionId: String? = null,
    firstName: String? = null,
    lastName: String? = null,
): Ok {
    val request = SetBusinessAccountName(businessConnectionId, firstName, lastName)
    val requestJson = tdJson.encodeToString(SetBusinessAccountName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the bio of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param bio The new value of the bio; 0-getOption("bio_length_max") characters without line feeds
 */
suspend fun TdKtxClient.setBusinessAccountBio(
    businessConnectionId: String? = null,
    bio: String? = null,
): Ok {
    val request = SetBusinessAccountBio(businessConnectionId, bio)
    val requestJson = tdJson.encodeToString(SetBusinessAccountBio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes a profile photo of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param photo Profile photo to set; pass null to remove the photo
 * @param isPublic Pass true to set the public photo, which will be visible even if the main photo is hidden by privacy settings
 */
suspend fun TdKtxClient.setBusinessAccountProfilePhoto(
    businessConnectionId: String? = null,
    photo: InputChatPhoto? = null,
    isPublic: Boolean,
): Ok {
    val request = SetBusinessAccountProfilePhoto(businessConnectionId, photo, isPublic)
    val requestJson = tdJson.encodeToString(SetBusinessAccountProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the editable username of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param username The new value of the username
 */
suspend fun TdKtxClient.setBusinessAccountUsername(
    businessConnectionId: String? = null,
    username: String? = null,
): Ok {
    val request = SetBusinessAccountUsername(businessConnectionId, username)
    val requestJson = tdJson.encodeToString(SetBusinessAccountUsername.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes settings for gift receiving of a business account; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param settings The new settings
 */
suspend fun TdKtxClient.setBusinessAccountGiftSettings(
    businessConnectionId: String? = null,
    settings: GiftSettings? = null,
): Ok {
    val request = SetBusinessAccountGiftSettings(businessConnectionId, settings)
    val requestJson = tdJson.encodeToString(SetBusinessAccountGiftSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the Telegram Star amount owned by a business account; for bots only @business_connection_id Unique identifier of business connection
 */
suspend fun TdKtxClient.getBusinessAccountStarAmount(
    businessConnectionId: String? = null,
): StarAmount {
    val request = GetBusinessAccountStarAmount(businessConnectionId)
    val requestJson = tdJson.encodeToString(GetBusinessAccountStarAmount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarAmount.serializer(), responseJson)
}

/**
 * Transfers Telegram Stars from the business account to the business bot; for bots only
 * @param businessConnectionId Unique identifier of business connection
 * @param starCount Number of Telegram Stars to transfer
 */
suspend fun TdKtxClient.transferBusinessAccountStars(
    businessConnectionId: String? = null,
    starCount: Long,
): Ok {
    val request = TransferBusinessAccountStars(businessConnectionId, starCount)
    val requestJson = tdJson.encodeToString(TransferBusinessAccountStars.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks validness of a name for a quick reply shortcut. Can be called synchronously @name The name of the shortcut; 1-32 characters
 */
suspend fun TdKtxClient.checkQuickReplyShortcutName(
    name: String? = null,
): Ok {
    val request = CheckQuickReplyShortcutName(name)
    val requestJson = tdJson.encodeToString(CheckQuickReplyShortcutName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Loads quick reply shortcuts created by the current user. The loaded data will be sent through updateQuickReplyShortcut and updateQuickReplyShortcuts
 */
suspend fun TdKtxClient.loadQuickReplyShortcuts(
): Ok {
    val request = LoadQuickReplyShortcuts()
    val requestJson = tdJson.encodeToString(LoadQuickReplyShortcuts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes name of a quick reply shortcut @shortcut_id Unique identifier of the quick reply shortcut @name New name for the shortcut. Use checkQuickReplyShortcutName to check its validness
 */
suspend fun TdKtxClient.setQuickReplyShortcutName(
    shortcutId: Int,
    name: String? = null,
): Ok {
    val request = SetQuickReplyShortcutName(shortcutId, name)
    val requestJson = tdJson.encodeToString(SetQuickReplyShortcutName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a quick reply shortcut @shortcut_id Unique identifier of the quick reply shortcut
 */
suspend fun TdKtxClient.deleteQuickReplyShortcut(
    shortcutId: Int,
): Ok {
    val request = DeleteQuickReplyShortcut(shortcutId)
    val requestJson = tdJson.encodeToString(DeleteQuickReplyShortcut.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the order of quick reply shortcuts @shortcut_ids The new order of quick reply shortcuts
 */
suspend fun TdKtxClient.reorderQuickReplyShortcuts(
    shortcutIds: List<Int>? = null,
): Ok {
    val request = ReorderQuickReplyShortcuts(shortcutIds)
    val requestJson = tdJson.encodeToString(ReorderQuickReplyShortcuts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Loads quick reply messages that can be sent by a given quick reply shortcut. The loaded messages will be sent through updateQuickReplyShortcutMessages
 * @param shortcutId Unique identifier of the quick reply shortcut
 */
suspend fun TdKtxClient.loadQuickReplyShortcutMessages(
    shortcutId: Int,
): Ok {
    val request = LoadQuickReplyShortcutMessages(shortcutId)
    val requestJson = tdJson.encodeToString(LoadQuickReplyShortcutMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes specified quick reply messages
 * @param shortcutId Unique identifier of the quick reply shortcut to which the messages belong
 * @param messageIds Unique identifiers of the messages
 */
suspend fun TdKtxClient.deleteQuickReplyShortcutMessages(
    shortcutId: Int,
    messageIds: List<Long>? = null,
): Ok {
    val request = DeleteQuickReplyShortcutMessages(shortcutId, messageIds)
    val requestJson = tdJson.encodeToString(DeleteQuickReplyShortcutMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a message to a quick reply shortcut. If shortcut doesn't exist and there are less than getOption("quick_reply_shortcut_count_max") shortcuts, then a new shortcut is created. The shortcut must not contain more than getOption("quick_reply_shortcut_message_count_max") messages after adding the new message. Returns the added message
 * @param shortcutName Name of the target shortcut
 * @param replyToMessageId Identifier of a quick reply message in the same shortcut to be replied; pass 0 if none
 * @param inputMessageContent The content of the message to be added; inputMessagePaidMedia, inputMessageForwarded and inputMessageLiveLocation
 */
suspend fun TdKtxClient.addQuickReplyShortcutMessage(
    shortcutName: String? = null,
    replyToMessageId: Long,
    inputMessageContent: InputMessageContent? = null,
): QuickReplyMessage {
    val request = AddQuickReplyShortcutMessage(shortcutName, replyToMessageId, inputMessageContent)
    val requestJson = tdJson.encodeToString(AddQuickReplyShortcutMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(QuickReplyMessage.serializer(), responseJson)
}

/**
 * Adds a message to a quick reply shortcut via inline bot. If shortcut doesn't exist and there are less than getOption("quick_reply_shortcut_count_max") shortcuts, then a new shortcut is created. The shortcut must not contain more than getOption("quick_reply_shortcut_message_count_max") messages after adding the new message. Returns the added message
 * @param shortcutName Name of the target shortcut
 * @param replyToMessageId Identifier of a quick reply message in the same shortcut to be replied; pass 0 if none
 * @param queryId Identifier of the inline query
 * @param resultId Identifier of the inline query result
 * @param hideViaBot Pass true to hide the bot, via which the message is sent. Can be used only for bots getOption("animation_search_bot_username"), getOption("photo_search_bot_username"), and getOption("venue_search_bot_username")
 */
suspend fun TdKtxClient.addQuickReplyShortcutInlineQueryResultMessage(
    shortcutName: String? = null,
    replyToMessageId: Long,
    queryId: Long,
    resultId: String? = null,
    hideViaBot: Boolean,
): QuickReplyMessage {
    val request = AddQuickReplyShortcutInlineQueryResultMessage(shortcutName, replyToMessageId, queryId, resultId, hideViaBot)
    val requestJson = tdJson.encodeToString(AddQuickReplyShortcutInlineQueryResultMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(QuickReplyMessage.serializer(), responseJson)
}

/**
 * Adds 2-10 messages grouped together into an album to a quick reply shortcut. Currently, only audio, document, photo and video messages can be grouped into an album. Documents and audio files can be only grouped in an album with messages of the same type. Returns sent messages
 * @param shortcutName Name of the target shortcut
 * @param replyToMessageId Identifier of a quick reply message in the same shortcut to be replied; pass 0 if none
 * @param inputMessageContents Contents of messages to be sent. At most 10 messages can be added to an album. All messages must have the same value of show_caption_above_media
 */
suspend fun TdKtxClient.addQuickReplyShortcutMessageAlbum(
    shortcutName: String? = null,
    replyToMessageId: Long,
    inputMessageContents: List<InputMessageContent>? = null,
): QuickReplyMessages {
    val request = AddQuickReplyShortcutMessageAlbum(shortcutName, replyToMessageId, inputMessageContents)
    val requestJson = tdJson.encodeToString(AddQuickReplyShortcutMessageAlbum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(QuickReplyMessages.serializer(), responseJson)
}

/**
 * Readds quick reply messages which failed to add. Can be called only for messages for which messageSendingStateFailed.can_retry is true and after specified in messageSendingStateFailed.retry_after time passed. If a message is readded, the corresponding failed to send message is deleted. Returns the sent messages in the same order as the message identifiers passed in message_ids. If a message can't be readded, null will be returned instead of the message
 * @param shortcutName Name of the target shortcut
 * @param messageIds Identifiers of the quick reply messages to readd. Message identifiers must be in a strictly increasing order
 */
suspend fun TdKtxClient.readdQuickReplyShortcutMessages(
    shortcutName: String? = null,
    messageIds: List<Long>? = null,
): QuickReplyMessages {
    val request = ReaddQuickReplyShortcutMessages(shortcutName, messageIds)
    val requestJson = tdJson.encodeToString(ReaddQuickReplyShortcutMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(QuickReplyMessages.serializer(), responseJson)
}

/**
 * Asynchronously edits the text, media or caption of a quick reply message. Use quickReplyMessage.can_be_edited to check whether a message can be edited. Media message can be edited only to a media message. Checklist messages can be edited only to a checklist message. The type of message content in an album can't be changed with exception of replacing a photo with a video or vice versa
 * @param shortcutId Unique identifier of the quick reply shortcut with the message
 * @param messageId Identifier of the message
 * @param inputMessageContent New content of the message. Must be one of the following types: inputMessageAnimation, inputMessageAudio, inputMessageChecklist, inputMessageDocument, inputMessagePhoto, inputMessageRichMessage, inputMessageText, or inputMessageVideo
 */
suspend fun TdKtxClient.editQuickReplyMessage(
    shortcutId: Int,
    messageId: Long,
    inputMessageContent: InputMessageContent? = null,
): Ok {
    val request = EditQuickReplyMessage(shortcutId, messageId, inputMessageContent)
    val requestJson = tdJson.encodeToString(EditQuickReplyMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of custom emoji, which can be used as forum topic icon by all users
 */
suspend fun TdKtxClient.getForumTopicDefaultIcons(
): Stickers {
    val request = GetForumTopicDefaultIcons()
    val requestJson = tdJson.encodeToString(GetForumTopicDefaultIcons.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Creates a topic in a forum supergroup chat or a chat with a bot with topics; requires can_manage_topics administrator or can_create_topics member right in the supergroup
 * @param chatId Identifier of the chat
 * @param name Name of the topic; 1-128 characters
 * @param isNameImplicit Pass true if the name of the topic wasn't entered explicitly; for chats with bots only
 * @param icon Icon of the topic. Icon color must be one of 0x6FB9F0, 0xFFD67E, 0xCB86DB, 0x8EEE98, 0xFF93B2, or 0xFB6F5F. Telegram Premium users can use any custom emoji as topic icon, other users can use only a custom emoji returned by getForumTopicDefaultIcons
 */
suspend fun TdKtxClient.createForumTopic(
    chatId: Long,
    name: String? = null,
    isNameImplicit: Boolean,
    icon: ForumTopicIcon? = null,
): ForumTopicInfo {
    val request = CreateForumTopic(chatId, name, isNameImplicit, icon)
    val requestJson = tdJson.encodeToString(CreateForumTopic.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ForumTopicInfo.serializer(), responseJson)
}

/**
 * Edits title and icon of a topic in a forum supergroup chat or a chat with a bot with topics; for supergroup chats requires can_manage_topics administrator right unless the user is creator of the topic
 * @param chatId Identifier of the chat
 * @param forumTopicId Forum topic identifier
 * @param name New name of the topic; 0-128 characters. If empty, the previous topic name is kept
 * @param editIconCustomEmoji Pass true to edit the icon of the topic. Icon of the General topic can't be edited
 * @param iconCustomEmojiId Identifier of the new custom emoji for topic icon; pass 0 to remove the custom emoji. Ignored if edit_icon_custom_emoji is false. Telegram Premium users can use any custom emoji, other users can use only a custom emoji returned by getForumTopicDefaultIcons
 */
suspend fun TdKtxClient.editForumTopic(
    chatId: Long,
    forumTopicId: Int,
    name: String? = null,
    editIconCustomEmoji: Boolean,
    iconCustomEmojiId: Long,
): Ok {
    val request = EditForumTopic(chatId, forumTopicId, name, editIconCustomEmoji, iconCustomEmojiId)
    val requestJson = tdJson.encodeToString(EditForumTopic.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a topic in a forum supergroup chat or a chat with a bot with topics
 * @param chatId Identifier of the chat
 * @param forumTopicId Forum topic identifier
 */
suspend fun TdKtxClient.getForumTopic(
    chatId: Long,
    forumTopicId: Int,
): ForumTopic {
    val request = GetForumTopic(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(GetForumTopic.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ForumTopic.serializer(), responseJson)
}

/**
 * Returns messages in a topic in a forum supergroup chat or a chat with a bot with topics. The messages are returned in reverse chronological order (i.e., in order of decreasing message_id). For optimal performance, the number of returned messages is chosen by TDLib
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier
 * @param fromMessageId Identifier of the message starting from which history must be fetched; use 0 to get results from the last message
 * @param offset Specify 0 to get results from exactly the message from_message_id or a negative number from -99 to -1 to get additionally -offset newer messages
 * @param limit The maximum number of messages to be returned; must be positive and can't be greater than 100. If the offset is negative, then the limit must be greater than or equal to -offset. For optimal performance, the number of returned messages is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getForumTopicHistory(
    chatId: Long,
    forumTopicId: Int,
    fromMessageId: Long,
    offset: Int,
    limit: Int,
): Messages {
    val request = GetForumTopicHistory(chatId, forumTopicId, fromMessageId, offset, limit)
    val requestJson = tdJson.encodeToString(GetForumTopicHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Returns an HTTPS link to a topic in a forum supergroup chat. This is an offline method @chat_id Identifier of the chat @forum_topic_id Forum topic identifier
 */
suspend fun TdKtxClient.getForumTopicLink(
    chatId: Long,
    forumTopicId: Int,
): MessageLink {
    val request = GetForumTopicLink(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(GetForumTopicLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageLink.serializer(), responseJson)
}

/**
 * Returns found forum topics in a forum supergroup chat or a chat with a bot with topics. This is a temporary method for getting information about topic list from the server
 * @param chatId Identifier of the chat
 * @param query Query to search for in the forum topic's name
 * @param offsetDate The date starting from which the results need to be fetched. Use 0 or any date in the future to get results from the last topic
 * @param offsetMessageId The message identifier of the last message in the last found topic, or 0 for the first request
 * @param offsetForumTopicId The forum topic identifier of the last found topic, or 0 for the first request
 * @param limit The maximum number of forum topics to be returned; up to 100. For optimal performance, the number of returned forum topics is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getForumTopics(
    chatId: Long,
    query: String? = null,
    offsetDate: Int,
    offsetMessageId: Long,
    offsetForumTopicId: Int,
    limit: Int,
): ForumTopics {
    val request = GetForumTopics(chatId, query, offsetDate, offsetMessageId, offsetForumTopicId, limit)
    val requestJson = tdJson.encodeToString(GetForumTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ForumTopics.serializer(), responseJson)
}

/**
 * Changes the notification settings of a forum topic in a forum supergroup chat or a chat with a bot with topics
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier
 * @param notificationSettings New notification settings for the forum topic. If the topic is muted for more than 366 days, it is considered to be muted forever
 */
suspend fun TdKtxClient.setForumTopicNotificationSettings(
    chatId: Long,
    forumTopicId: Int,
    notificationSettings: ChatNotificationSettings? = null,
): Ok {
    val request = SetForumTopicNotificationSettings(chatId, forumTopicId, notificationSettings)
    val requestJson = tdJson.encodeToString(SetForumTopicNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a topic is closed in a forum supergroup chat; requires can_manage_topics administrator right in the supergroup unless the user is creator of the topic
 * @param chatId Identifier of the chat
 * @param forumTopicId Forum topic identifier
 * @param isClosed Pass true to close the topic; pass false to reopen it
 */
suspend fun TdKtxClient.toggleForumTopicIsClosed(
    chatId: Long,
    forumTopicId: Int,
    isClosed: Boolean,
): Ok {
    val request = ToggleForumTopicIsClosed(chatId, forumTopicId, isClosed)
    val requestJson = tdJson.encodeToString(ToggleForumTopicIsClosed.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a General topic is hidden in a forum supergroup chat; requires can_manage_topics administrator right in the supergroup
 * @param chatId Identifier of the chat
 * @param isHidden Pass true to hide and close the General topic; pass false to unhide it
 */
suspend fun TdKtxClient.toggleGeneralForumTopicIsHidden(
    chatId: Long,
    isHidden: Boolean,
): Ok {
    val request = ToggleGeneralForumTopicIsHidden(chatId, isHidden)
    val requestJson = tdJson.encodeToString(ToggleGeneralForumTopicIsHidden.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the pinned state of a topic in a forum supergroup chat or a chat with a bot with topics; requires can_manage_topics administrator right in the supergroup. There can be up to getOption("pinned_forum_topic_count_max") pinned forum topics
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier
 * @param isPinned Pass true to pin the topic; pass false to unpin it
 */
suspend fun TdKtxClient.toggleForumTopicIsPinned(
    chatId: Long,
    forumTopicId: Int,
    isPinned: Boolean,
): Ok {
    val request = ToggleForumTopicIsPinned(chatId, forumTopicId, isPinned)
    val requestJson = tdJson.encodeToString(ToggleForumTopicIsPinned.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the order of pinned topics in a forum supergroup chat or a chat with a bot with topics; requires can_manage_topics administrator right in the supergroup
 * @param chatId Chat identifier
 * @param forumTopicIds The new list of identifiers of the pinned forum topics
 */
suspend fun TdKtxClient.setPinnedForumTopics(
    chatId: Long,
    forumTopicIds: List<Int>? = null,
): Ok {
    val request = SetPinnedForumTopics(chatId, forumTopicIds)
    val requestJson = tdJson.encodeToString(SetPinnedForumTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages from a topic in a forum supergroup chat or a chat with a bot with topics; requires can_delete_messages administrator right in the supergroup unless the user is creator of the topic, the topic has no messages from other users and has at most 11 messages
 * @param chatId Identifier of the chat
 * @param forumTopicId Forum topic identifier
 */
suspend fun TdKtxClient.deleteForumTopic(
    chatId: Long,
    forumTopicId: Int,
): Ok {
    val request = DeleteForumTopic(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(DeleteForumTopic.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all mentions in a topic in a forum supergroup chat as read
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier in which mentions are marked as read
 */
suspend fun TdKtxClient.readAllForumTopicMentions(
    chatId: Long,
    forumTopicId: Int,
): Ok {
    val request = ReadAllForumTopicMentions(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(ReadAllForumTopicMentions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all reactions in a topic in a forum supergroup chat or a chat with a bot with topics as read
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier in which reactions are marked as read
 */
suspend fun TdKtxClient.readAllForumTopicReactions(
    chatId: Long,
    forumTopicId: Int,
): Ok {
    val request = ReadAllForumTopicReactions(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(ReadAllForumTopicReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all poll votes in a topic in a forum supergroup chat as read
 * @param chatId Chat identifier
 * @param forumTopicId Forum topic identifier in which poll votes are marked as read
 */
suspend fun TdKtxClient.readAllForumTopicPollVotes(
    chatId: Long,
    forumTopicId: Int,
): Ok {
    val request = ReadAllForumTopicPollVotes(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(ReadAllForumTopicPollVotes.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all pinned messages from a topic in a forum supergroup chat or a chat with a bot with topics; requires can_pin_messages member right in the supergroup
 * @param chatId Identifier of the chat
 * @param forumTopicId Forum topic identifier in which messages will be unpinned
 */
suspend fun TdKtxClient.unpinAllForumTopicMessages(
    chatId: Long,
    forumTopicId: Int,
): Ok {
    val request = UnpinAllForumTopicMessages(chatId, forumTopicId)
    val requestJson = tdJson.encodeToString(UnpinAllForumTopicMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns parameters for creating of a new passkey as JSON-serialized string
 */
suspend fun TdKtxClient.getPasskeyParameters(
): Text {
    val request = GetPasskeyParameters()
    val requestJson = tdJson.encodeToString(GetPasskeyParameters.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Adds a passkey allowed to be used for the login by the current user and returns the added passkey. Call getPasskeyParameters to get parameters for creating of the passkey
 * @param clientData JSON-encoded client data
 * @param attestationObject Passkey attestation object
 */
suspend fun TdKtxClient.addLoginPasskey(
    clientData: String? = null,
    attestationObject: String? = null,
): Passkey {
    val request = AddLoginPasskey(clientData, attestationObject)
    val requestJson = tdJson.encodeToString(AddLoginPasskey.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Passkey.serializer(), responseJson)
}

/**
 * Returns the list of passkeys allowed to be used for the login by the current user
 */
suspend fun TdKtxClient.getLoginPasskeys(
): Passkeys {
    val request = GetLoginPasskeys()
    val requestJson = tdJson.encodeToString(GetLoginPasskeys.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Passkeys.serializer(), responseJson)
}

/**
 * Removes a passkey from the list of passkeys allowed to be used for the login by the current user @passkey_id Unique identifier of the passkey to remove
 */
suspend fun TdKtxClient.removeLoginPasskey(
    passkeyId: String? = null,
): Ok {
    val request = RemoveLoginPasskey(passkeyId)
    val requestJson = tdJson.encodeToString(RemoveLoginPasskey.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about an emoji reaction. Returns a 404 error if the reaction is not found @emoji Text representation of the reaction
 */
suspend fun TdKtxClient.getEmojiReaction(
    emoji: String? = null,
): EmojiReaction {
    val request = GetEmojiReaction(emoji)
    val requestJson = tdJson.encodeToString(GetEmojiReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiReaction.serializer(), responseJson)
}

/**
 * Returns TGS stickers with generic animations for custom emoji reactions
 */
suspend fun TdKtxClient.getCustomEmojiReactionAnimations(
): Stickers {
    val request = GetCustomEmojiReactionAnimations()
    val requestJson = tdJson.encodeToString(GetCustomEmojiReactionAnimations.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns reactions, which can be added to a message. The list can change after updateActiveEmojiReactions, updateChatAvailableReactions for the chat, or updateMessageInteractionInfo for the message
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param rowSize Number of reaction per row, 5-25
 */
suspend fun TdKtxClient.getMessageAvailableReactions(
    chatId: Long,
    messageId: Long,
    rowSize: Int,
): AvailableReactions {
    val request = GetMessageAvailableReactions(chatId, messageId, rowSize)
    val requestJson = tdJson.encodeToString(GetMessageAvailableReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AvailableReactions.serializer(), responseJson)
}

/**
 * Clears the list of recently used reactions
 */
suspend fun TdKtxClient.clearRecentReactions(
): Ok {
    val request = ClearRecentReactions()
    val requestJson = tdJson.encodeToString(ClearRecentReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a reaction or a tag to a message. Use getMessageAvailableReactions to receive the list of available reactions for the message
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param reactionType Type of the reaction to add. Use addPendingPaidMessageReaction instead to add the paid reaction
 * @param isBig Pass true if the reaction is added with a big animation
 * @param updateRecentReactions Pass true if the reaction needs to be added to recent reactions; tags are never added to the list of recent reactions
 */
suspend fun TdKtxClient.addMessageReaction(
    chatId: Long,
    messageId: Long,
    reactionType: ReactionType? = null,
    isBig: Boolean,
    updateRecentReactions: Boolean,
): Ok {
    val request = AddMessageReaction(chatId, messageId, reactionType, isBig, updateRecentReactions)
    val requestJson = tdJson.encodeToString(AddMessageReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a reaction from a message. A chosen reaction can always be removed
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param reactionType Type of the reaction to remove. The paid reaction can't be removed
 */
suspend fun TdKtxClient.removeMessageReaction(
    chatId: Long,
    messageId: Long,
    reactionType: ReactionType? = null,
): Ok {
    val request = RemoveMessageReaction(chatId, messageId, reactionType)
    val requestJson = tdJson.encodeToString(RemoveMessageReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all recent reactions added by the specified sender in a chat. Supported only for basic groups and supergroups; requires can_delete_messages administrator right
 * @param chatId Chat identifier
 * @param senderId Identifier of the sender of reactions to delete
 */
suspend fun TdKtxClient.deleteAllRecentMessageReactionsFromSender(
    chatId: Long,
    senderId: MessageSender? = null,
): Ok {
    val request = DeleteAllRecentMessageReactionsFromSender(chatId, senderId)
    val requestJson = tdJson.encodeToString(DeleteAllRecentMessageReactionsFromSender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all reactions added by the specified sender on a message
 * @param chatId Chat identifier
 * @param messageId Identifier of the message containing the reactions. Use messageProperties.can_delete_reactions to check whether the method can be used for a message
 * @param senderId Identifier of the sender of reactions to delete
 */
suspend fun TdKtxClient.deleteMessageReactionsFromSender(
    chatId: Long,
    messageId: Long,
    senderId: MessageSender? = null,
): Ok {
    val request = DeleteMessageReactionsFromSender(chatId, messageId, senderId)
    val requestJson = tdJson.encodeToString(DeleteMessageReactionsFromSender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of message sender identifiers, which can be used to send a paid reaction in a chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatAvailablePaidMessageReactionSenders(
    chatId: Long,
): MessageSenders {
    val request = GetChatAvailablePaidMessageReactionSenders(chatId)
    val requestJson = tdJson.encodeToString(GetChatAvailablePaidMessageReactionSenders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageSenders.serializer(), responseJson)
}

/**
 * Adds the paid message reaction to a message. Use getMessageAvailableReactions to check whether the reaction is available for the message
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param starCount Number of Telegram Stars to be used for the reaction. The total number of pending paid reactions must not exceed getOption("paid_reaction_star_count_max")
 * @param type Type of the paid reaction; pass null if the user didn't choose reaction type explicitly, for example, the reaction is set from the message bubble
 */
suspend fun TdKtxClient.addPendingPaidMessageReaction(
    chatId: Long,
    messageId: Long,
    starCount: Long,
    type: PaidReactionType? = null,
): Ok {
    val request = AddPendingPaidMessageReaction(chatId, messageId, starCount, type)
    val requestJson = tdJson.encodeToString(AddPendingPaidMessageReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Applies all pending paid reactions on a message @chat_id Identifier of the chat to which the message belongs @message_id Identifier of the message
 */
suspend fun TdKtxClient.commitPendingPaidMessageReactions(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = CommitPendingPaidMessageReactions(chatId, messageId)
    val requestJson = tdJson.encodeToString(CommitPendingPaidMessageReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all pending paid reactions on a message @chat_id Identifier of the chat to which the message belongs @message_id Identifier of the message
 */
suspend fun TdKtxClient.removePendingPaidMessageReactions(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = RemovePendingPaidMessageReactions(chatId, messageId)
    val requestJson = tdJson.encodeToString(RemovePendingPaidMessageReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes type of paid message reaction of the current user on a message. The message must have paid reaction added by the current user
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param type New type of the paid reaction
 */
suspend fun TdKtxClient.setPaidMessageReactionType(
    chatId: Long,
    messageId: Long,
    type: PaidReactionType? = null,
): Ok {
    val request = SetPaidMessageReactionType(chatId, messageId, type)
    val requestJson = tdJson.encodeToString(SetPaidMessageReactionType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets reactions on a message; for bots only
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message
 * @param reactionTypes Types of the reaction to set; pass an empty list to remove the reactions
 * @param isBig Pass true if the reactions are added with a big animation
 */
suspend fun TdKtxClient.setMessageReactions(
    chatId: Long,
    messageId: Long,
    reactionTypes: List<ReactionType>? = null,
    isBig: Boolean,
): Ok {
    val request = SetMessageReactions(chatId, messageId, reactionTypes, isBig)
    val requestJson = tdJson.encodeToString(SetMessageReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns reactions added for a message, along with their sender
 * @param chatId Identifier of the chat to which the message belongs
 * @param messageId Identifier of the message. Use message.interaction_info.reactions.can_get_added_reactions to check whether added reactions can be received for the message
 * @param reactionType Type of the reactions to return; pass null to return all added reactions; reactionTypePaid isn't supported
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of reactions to be returned; must be positive and can't be greater than 100
 */
suspend fun TdKtxClient.getMessageAddedReactions(
    chatId: Long,
    messageId: Long,
    reactionType: ReactionType? = null,
    offset: String? = null,
    limit: Int,
): AddedReactions {
    val request = GetMessageAddedReactions(chatId, messageId, reactionType, offset, limit)
    val requestJson = tdJson.encodeToString(GetMessageAddedReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AddedReactions.serializer(), responseJson)
}

/**
 * Changes type of default reaction for the current user @reaction_type New type of the default reaction. The paid reaction can't be set as default
 */
suspend fun TdKtxClient.setDefaultReactionType(
    reactionType: ReactionType? = null,
): Ok {
    val request = SetDefaultReactionType(reactionType)
    val requestJson = tdJson.encodeToString(SetDefaultReactionType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns tags used in Saved Messages or a Saved Messages topic
 * @param savedMessagesTopicId Identifier of Saved Messages topic which tags will be returned; pass 0 to get all Saved Messages tags
 */
suspend fun TdKtxClient.getSavedMessagesTags(
    savedMessagesTopicId: Long,
): SavedMessagesTags {
    val request = GetSavedMessagesTags(savedMessagesTopicId)
    val requestJson = tdJson.encodeToString(GetSavedMessagesTags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(SavedMessagesTags.serializer(), responseJson)
}

/**
 * Changes label of a Saved Messages tag; for Telegram Premium users only @tag The tag which label will be changed @label New label for the tag; 0-12 characters
 */
suspend fun TdKtxClient.setSavedMessagesTagLabel(
    tag: ReactionType? = null,
    label: String? = null,
): Ok {
    val request = SetSavedMessagesTagLabel(tag, label)
    val requestJson = tdJson.encodeToString(SetSavedMessagesTagLabel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a message effect. Returns a 404 error if the effect is not found @effect_id Unique identifier of the effect
 */
suspend fun TdKtxClient.getMessageEffect(
    effectId: Long,
): MessageEffect {
    val request = GetMessageEffect(effectId)
    val requestJson = tdJson.encodeToString(GetMessageEffect.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageEffect.serializer(), responseJson)
}

/**
 * Searches for a given quote in a text. Returns found quote start position in UTF-16 code units. Returns a 404 error if the quote is not found. Can be called synchronously
 * @param text Text in which to search for the quote
 * @param quote Quote to search for
 * @param quotePosition Approximate quote position in UTF-16 code units
 */
suspend fun TdKtxClient.searchQuote(
    text: FormattedText? = null,
    quote: FormattedText? = null,
    quotePosition: Int,
): FoundPosition {
    val request = SearchQuote(text, quote, quotePosition)
    val requestJson = tdJson.encodeToString(SearchQuote.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundPosition.serializer(), responseJson)
}

/**
 * Returns all entities (mentions, hashtags, cashtags, bot commands, bank card numbers, URLs, and email addresses) found in the text. Can be called synchronously @text The text in which to look for entities
 */
suspend fun TdKtxClient.getTextEntities(
    text: String? = null,
): TextEntities {
    val request = GetTextEntities(text)
    val requestJson = tdJson.encodeToString(GetTextEntities.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TextEntities.serializer(), responseJson)
}

/**
 * Parses Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, BlockQuote, ExpandableBlockQuote, Code, Pre, PreCode, TextUrl, MentionName, and DateTime entities from a marked-up text. Can be called synchronously
 * @param text The text to parse
 * @param parseMode Text parse mode
 */
suspend fun TdKtxClient.parseTextEntities(
    text: String? = null,
    parseMode: TextParseMode? = null,
): FormattedText {
    val request = ParseTextEntities(text, parseMode)
    val requestJson = tdJson.encodeToString(ParseTextEntities.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Parses Markdown entities in a human-friendly format, ignoring markup errors. Can be called synchronously
 * @param text The text to parse. For example, "__italic__ ~~strikethrough~~ ||spoiler|| **bold** `code` ```pre``` __[italic__ text_url](telegram.org) __italic**bold italic__bold**"
 */
suspend fun TdKtxClient.parseMarkdown(
    text: FormattedText? = null,
): FormattedText {
    val request = ParseMarkdown(text)
    val requestJson = tdJson.encodeToString(ParseMarkdown.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Replaces text entities with Markdown formatting in a human-friendly format. Entities that can't be represented in Markdown unambiguously are kept as is. Can be called synchronously @text The text
 */
suspend fun TdKtxClient.getMarkdownText(
    text: FormattedText? = null,
): FormattedText {
    val request = GetMarkdownText(text)
    val requestJson = tdJson.encodeToString(GetMarkdownText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FormattedText.serializer(), responseJson)
}

/**
 * Returns an emoji for the given country. Returns an empty string on failure. Can be called synchronously @country_code A two-letter ISO 3166-1 alpha-2 country code as received from getCountries
 */
suspend fun TdKtxClient.getCountryFlagEmoji(
    countryCode: String? = null,
): Text {
    val request = GetCountryFlagEmoji(countryCode)
    val requestJson = tdJson.encodeToString(GetCountryFlagEmoji.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns the MIME type of a file, guessed by its extension. Returns an empty string on failure. Can be called synchronously @file_name The name of the file or path to the file
 */
suspend fun TdKtxClient.getFileMimeType(
    fileName: String? = null,
): Text {
    val request = GetFileMimeType(fileName)
    val requestJson = tdJson.encodeToString(GetFileMimeType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns the extension of a file, guessed by its MIME type. Returns an empty string on failure. Can be called synchronously @mime_type The MIME type of the file
 */
suspend fun TdKtxClient.getFileExtension(
    mimeType: String? = null,
): Text {
    val request = GetFileExtension(mimeType)
    val requestJson = tdJson.encodeToString(GetFileExtension.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Removes potentially dangerous characters from the name of a file. Returns an empty string on failure. Can be called synchronously @file_name File name or path to the file
 */
suspend fun TdKtxClient.cleanFileName(
    fileName: String? = null,
): Text {
    val request = CleanFileName(fileName)
    val requestJson = tdJson.encodeToString(CleanFileName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns a string stored in the local database from the specified localization target and language pack by its key. Returns a 404 error if the string is not found. Can be called synchronously
 * @param languagePackDatabasePath Path to the language pack database in which strings are stored
 * @param localizationTarget Localization target to which the language pack belongs
 * @param languagePackId Language pack identifier
 * @param key Language pack key of the string to be returned
 */
suspend fun TdKtxClient.getLanguagePackString(
    languagePackDatabasePath: String? = null,
    localizationTarget: String? = null,
    languagePackId: String? = null,
    key: String? = null,
): LanguagePackStringValue {
    val request = GetLanguagePackString(languagePackDatabasePath, localizationTarget, languagePackId, key)
    val requestJson = tdJson.encodeToString(GetLanguagePackString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LanguagePackStringValue.serializer(), responseJson)
}

/**
 * Converts a JSON-serialized string to corresponding JsonValue object. Can be called synchronously @json The JSON-serialized string
 */
suspend fun TdKtxClient.getJsonValue(
    json: String? = null,
): JsonValue {
    val request = GetJsonValue(json)
    val requestJson = tdJson.encodeToString(GetJsonValue.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(JsonValue.serializer(), responseJson)
}

/**
 * Converts a JsonValue object to corresponding JSON-serialized string. Can be called synchronously @json_value The JsonValue object
 */
suspend fun TdKtxClient.getJsonString(
    jsonValue: JsonValue? = null,
): Text {
    val request = GetJsonString(jsonValue)
    val requestJson = tdJson.encodeToString(GetJsonString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Converts a themeParameters object to corresponding JSON-serialized string. Can be called synchronously @theme Theme parameters to convert to JSON
 */
suspend fun TdKtxClient.getThemeParametersJsonString(
    theme: ThemeParameters? = null,
): Text {
    val request = GetThemeParametersJsonString(theme)
    val requestJson = tdJson.encodeToString(GetThemeParametersJsonString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Adds an option to a poll
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll. Use messagePoll.can_add_option to check whether an option can be added
 * @param option The new option
 */
suspend fun TdKtxClient.addPollOption(
    chatId: Long,
    messageId: Long,
    option: InputPollOption? = null,
): Ok {
    val request = AddPollOption(chatId, messageId, option)
    val requestJson = tdJson.encodeToString(AddPollOption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes an option from a poll
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll
 * @param optionId Unique identifier of the option. Use pollOptionProperties.can_be_deleted to check whether the option can be deleted by the user
 */
suspend fun TdKtxClient.deletePollOption(
    chatId: Long,
    messageId: Long,
    optionId: String? = null,
): Ok {
    val request = DeletePollOption(chatId, messageId, optionId)
    val requestJson = tdJson.encodeToString(DeletePollOption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the user answer to a poll
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll
 * @param optionIds 0-based identifiers of answer options, chosen by the user. User can choose more than 1 answer option only is the poll allows multiple answers
 */
suspend fun TdKtxClient.setPollAnswer(
    chatId: Long,
    messageId: Long,
    optionIds: List<Int>? = null,
): Ok {
    val request = SetPollAnswer(chatId, messageId, optionIds)
    val requestJson = tdJson.encodeToString(SetPollAnswer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns message senders voted for the specified option in a poll; use poll.can_get_voters to check whether the method can be used. For optimal performance, the number of returned users is chosen by TDLib
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll
 * @param optionId 0-based identifier of the answer option
 * @param offset Number of voters to skip in the result; must be non-negative
 * @param limit The maximum number of voters to be returned; must be positive and can't be greater than 50. For optimal performance, the number of returned voters is chosen by TDLib and can be smaller than the specified limit, even if the end of the voter list has not been reached
 */
suspend fun TdKtxClient.getPollVoters(
    chatId: Long,
    messageId: Long,
    optionId: Int,
    offset: Int,
    limit: Int,
): PollVoters {
    val request = GetPollVoters(chatId, messageId, optionId, offset, limit)
    val requestJson = tdJson.encodeToString(GetPollVoters.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PollVoters.serializer(), responseJson)
}

/**
 * Returns statistics of poll votes in a poll
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll. Use messageProperties.can_get_poll_vote_statistics to check whether the method can be used for a message
 * @param isDark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getPollVoteStatistics(
    chatId: Long,
    messageId: Long,
    isDark: Boolean,
): PollVoteStatistics {
    val request = GetPollVoteStatistics(chatId, messageId, isDark)
    val requestJson = tdJson.encodeToString(GetPollVoteStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PollVoteStatistics.serializer(), responseJson)
}

/**
 * Stops a poll
 * @param chatId Identifier of the chat to which the poll belongs
 * @param messageId Identifier of the message containing the poll. Use messageProperties.can_be_edited to check whether the poll can be stopped
 * @param replyMarkup The new message reply markup; pass null if none; for bots only
 */
suspend fun TdKtxClient.stopPoll(
    chatId: Long,
    messageId: Long,
    replyMarkup: ReplyMarkup? = null,
): Ok {
    val request = StopPoll(chatId, messageId, replyMarkup)
    val requestJson = tdJson.encodeToString(StopPoll.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds tasks to a checklist in a message
 * @param chatId Identifier of the chat with the message
 * @param messageId Identifier of the message containing the checklist. Use messageProperties.can_add_tasks to check whether the tasks can be added
 * @param tasks List of added tasks
 */
suspend fun TdKtxClient.addChecklistTasks(
    chatId: Long,
    messageId: Long,
    tasks: List<InputChecklistTask>? = null,
): Ok {
    val request = AddChecklistTasks(chatId, messageId, tasks)
    val requestJson = tdJson.encodeToString(AddChecklistTasks.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds tasks of a checklist in a message as done or not done
 * @param chatId Identifier of the chat with the message
 * @param messageId Identifier of the message containing the checklist. Use messageProperties.can_mark_tasks_as_done to check whether the tasks can be marked as done or not done
 * @param markedAsDoneTaskIds Identifiers of tasks that were marked as done
 * @param markedAsNotDoneTaskIds Identifiers of tasks that were marked as not done
 */
suspend fun TdKtxClient.markChecklistTasksAsDone(
    chatId: Long,
    messageId: Long,
    markedAsDoneTaskIds: List<Int>? = null,
    markedAsNotDoneTaskIds: List<Int>? = null,
): Ok {
    val request = MarkChecklistTasksAsDone(chatId, messageId, markedAsDoneTaskIds, markedAsNotDoneTaskIds)
    val requestJson = tdJson.encodeToString(MarkChecklistTasksAsDone.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Hides a suggested action @action Suggested action to hide
 */
suspend fun TdKtxClient.hideSuggestedAction(
    action: SuggestedAction? = null,
): Ok {
    val request = HideSuggestedAction(action)
    val requestJson = tdJson.encodeToString(HideSuggestedAction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Hides the list of contacts that have close birthdays for 24 hours
 */
suspend fun TdKtxClient.hideContactCloseBirthdays(
): Ok {
    val request = HideContactCloseBirthdays()
    val requestJson = tdJson.encodeToString(HideContactCloseBirthdays.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a business connection by its identifier; for bots only @connection_id Identifier of the business connection to return
 */
suspend fun TdKtxClient.getBusinessConnection(
    connectionId: String? = null,
): BusinessConnection {
    val request = GetBusinessConnection(connectionId)
    val requestJson = tdJson.encodeToString(GetBusinessConnection.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessConnection.serializer(), responseJson)
}

/**
 * Returns information about a button of type inlineKeyboardButtonTypeLoginUrl. The method needs to be called when the user presses the button
 * @param chatId Chat identifier of the message with the button
 * @param messageId Message identifier of the message with the button. The message must not be scheduled
 * @param buttonId Button identifier
 */
suspend fun TdKtxClient.getLoginUrlInfo(
    chatId: Long,
    messageId: Long,
    buttonId: Long,
): LoginUrlInfo {
    val request = GetLoginUrlInfo(chatId, messageId, buttonId)
    val requestJson = tdJson.encodeToString(GetLoginUrlInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LoginUrlInfo.serializer(), responseJson)
}

/**
 * Returns an HTTP URL which can be used to automatically authorize the user on a website after clicking an inline button of type inlineKeyboardButtonTypeLoginUrl. Use the method getLoginUrlInfo to find whether a prior user confirmation is needed. If an error is returned, then the button must be handled as an ordinary URL button
 * @param chatId Chat identifier of the message with the button
 * @param messageId Message identifier of the message with the button
 * @param buttonId Button identifier
 * @param allowWriteAccess Pass true to allow the bot to send messages to the current user. Phone number access can't be requested using the button
 */
suspend fun TdKtxClient.getLoginUrl(
    chatId: Long,
    messageId: Long,
    buttonId: Long,
    allowWriteAccess: Boolean,
): HttpUrl {
    val request = GetLoginUrl(chatId, messageId, buttonId, allowWriteAccess)
    val requestJson = tdJson.encodeToString(GetLoginUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Shares users after pressing a keyboardButtonTypeRequestUsers button with the bot
 * @param source Source of the button
 * @param buttonId Identifier of the button
 * @param sharedUserIds Identifiers of the shared users
 * @param onlyCheck Pass true to check that the users can be shared by the button instead of actually sharing them
 */
suspend fun TdKtxClient.shareUsersWithBot(
    source: KeyboardButtonSource? = null,
    buttonId: Int,
    sharedUserIds: List<Long>? = null,
    onlyCheck: Boolean,
): Ok {
    val request = ShareUsersWithBot(source, buttonId, sharedUserIds, onlyCheck)
    val requestJson = tdJson.encodeToString(ShareUsersWithBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Shares a chat after pressing a keyboardButtonTypeRequestChat button with the bot
 * @param source Source of the button
 * @param buttonId Identifier of the button
 * @param sharedChatId Identifier of the shared chat
 * @param onlyCheck Pass true to check that the chat can be shared by the button instead of actually sharing it. Doesn't check bot_is_member and bot_administrator_rights restrictions. If the bot must be a member, then all chats from getGroupsInCommon and all chats, where the user can add the bot, are suitable. In the latter case the bot will be automatically added to the chat. If the bot must be an administrator, then all chats, where the bot already has requested rights or can be added to administrators by the user, are suitable. In the latter case the bot will be automatically granted requested rights
 */
suspend fun TdKtxClient.shareChatWithBot(
    source: KeyboardButtonSource? = null,
    buttonId: Int,
    sharedChatId: Long,
    onlyCheck: Boolean,
): Ok {
    val request = ShareChatWithBot(source, buttonId, sharedChatId, onlyCheck)
    val requestJson = tdJson.encodeToString(ShareChatWithBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends an inline query to a bot and returns its results. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 * @param botUserId Identifier of the target bot
 * @param chatId Identifier of the chat where the query was sent
 * @param userLocation Location of the user; pass null if unknown or the bot doesn't need user's location
 * @param query Text of the query
 * @param offset Offset of the first entry to return; use empty string to get the first chunk of results
 */
suspend fun TdKtxClient.getInlineQueryResults(
    botUserId: Long,
    chatId: Long,
    userLocation: Location? = null,
    query: String? = null,
    offset: String? = null,
): InlineQueryResults {
    val request = GetInlineQueryResults(botUserId, chatId, userLocation, query, offset)
    val requestJson = tdJson.encodeToString(GetInlineQueryResults.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(InlineQueryResults.serializer(), responseJson)
}

/**
 * Sets the result of an inline query; for bots only
 * @param inlineQueryId Identifier of the inline query
 * @param isPersonal Pass true if results may be cached and returned only for the user who sent the query. By default, results may be returned to any user who sends the same query
 * @param button Button to be shown above inline query results; pass null if none
 * @param results The results of the query
 * @param cacheTime Allowed time to cache the results of the query, in seconds
 * @param nextOffset Offset for the next inline query; pass an empty string if there are no more results
 */
suspend fun TdKtxClient.answerInlineQuery(
    inlineQueryId: Long,
    isPersonal: Boolean,
    button: InlineQueryResultsButton? = null,
    results: List<InputInlineQueryResult>? = null,
    cacheTime: Int,
    nextOffset: String? = null,
): Ok {
    val request = AnswerInlineQuery(inlineQueryId, isPersonal, button, results, cacheTime, nextOffset)
    val requestJson = tdJson.encodeToString(AnswerInlineQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the result of a guest query; for bots only
 * @param guestQueryId Identifier of the guest query
 * @param result The result of the query
 */
suspend fun TdKtxClient.answerGuestQuery(
    guestQueryId: Long,
    result: InputInlineQueryResult? = null,
): InlineMessageId {
    val request = AnswerGuestQuery(guestQueryId, result)
    val requestJson = tdJson.encodeToString(AnswerGuestQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(InlineMessageId.serializer(), responseJson)
}

/**
 * Saves an inline message to be sent by the given user; for bots only
 * @param userId Identifier of the user
 * @param result The description of the message
 * @param chatTypes Types of the chats to which the message can be sent
 */
suspend fun TdKtxClient.savePreparedInlineMessage(
    userId: Long,
    result: InputInlineQueryResult? = null,
    chatTypes: TargetChatTypes? = null,
): PreparedInlineMessageId {
    val request = SavePreparedInlineMessage(userId, result, chatTypes)
    val requestJson = tdJson.encodeToString(SavePreparedInlineMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PreparedInlineMessageId.serializer(), responseJson)
}

/**
 * Saves an inline message to be sent by the given user
 * @param botUserId Identifier of the bot that created the message
 * @param preparedMessageId Identifier of the prepared message
 */
suspend fun TdKtxClient.getPreparedInlineMessage(
    botUserId: Long,
    preparedMessageId: String? = null,
): PreparedInlineMessage {
    val request = GetPreparedInlineMessage(botUserId, preparedMessageId)
    val requestJson = tdJson.encodeToString(GetPreparedInlineMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PreparedInlineMessage.serializer(), responseJson)
}

/**
 * Saves a keyboard button to be shown to the given user; for bots only
 * @param userId Identifier of the user
 * @param button The button; must be of the type keyboardButtonTypeRequestUsers, keyboardButtonTypeRequestChat, or keyboardButtonTypeRequestManagedBot
 */
suspend fun TdKtxClient.savePreparedKeyboardButton(
    userId: Long,
    button: KeyboardButton? = null,
): Text {
    val request = SavePreparedKeyboardButton(userId, button)
    val requestJson = tdJson.encodeToString(SavePreparedKeyboardButton.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns a keyboard button prepared by the bot for the user. The button will be of the type keyboardButtonTypeRequestUsers, keyboardButtonTypeRequestChat, or keyboardButtonTypeRequestManagedBot
 * @param botUserId Identifier of the bot that created the button
 * @param preparedButtonId Identifier of the prepared button
 */
suspend fun TdKtxClient.getPreparedKeyboardButton(
    botUserId: Long,
    preparedButtonId: String? = null,
): KeyboardButton {
    val request = GetPreparedKeyboardButton(botUserId, preparedButtonId)
    val requestJson = tdJson.encodeToString(GetPreparedKeyboardButton.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(KeyboardButton.serializer(), responseJson)
}

/**
 * Returns the most grossing Web App bots
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of bots to be returned; up to 100
 */
suspend fun TdKtxClient.getGrossingWebAppBots(
    offset: String? = null,
    limit: Int,
): FoundUsers {
    val request = GetGrossingWebAppBots(offset, limit)
    val requestJson = tdJson.encodeToString(GetGrossingWebAppBots.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundUsers.serializer(), responseJson)
}

/**
 * Returns information about a Web App by its short name. Returns a 404 error if the Web App is not found
 * @param botUserId Identifier of the target bot
 * @param webAppShortName Short name of the Web App
 */
suspend fun TdKtxClient.searchWebApp(
    botUserId: Long,
    webAppShortName: String? = null,
): FoundWebApp {
    val request = SearchWebApp(botUserId, webAppShortName)
    val requestJson = tdJson.encodeToString(SearchWebApp.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundWebApp.serializer(), responseJson)
}

/**
 * Returns a default placeholder for Web Apps of a bot. This is an offline method. Returns a 404 error if the placeholder isn't known @bot_user_id Identifier of the target bot
 */
suspend fun TdKtxClient.getWebAppPlaceholder(
    botUserId: Long,
): Outline {
    val request = GetWebAppPlaceholder(botUserId)
    val requestJson = tdJson.encodeToString(GetWebAppPlaceholder.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Outline.serializer(), responseJson)
}

/**
 * Returns an HTTPS URL of a Web App to open after a link of the type internalLinkTypeWebApp is clicked
 * @param chatId Identifier of the chat in which the link was clicked; pass 0 if none
 * @param botUserId Identifier of the target bot
 * @param webAppShortName Short name of the Web App
 * @param startParameter Start parameter from internalLinkTypeWebApp
 * @param allowWriteAccess Pass true if the current user allowed the bot to send them messages
 * @param parameters Parameters to use to open the Web App
 */
suspend fun TdKtxClient.getWebAppLinkUrl(
    chatId: Long,
    botUserId: Long,
    webAppShortName: String? = null,
    startParameter: String? = null,
    allowWriteAccess: Boolean,
    parameters: WebAppOpenParameters? = null,
): WebAppUrl {
    val request = GetWebAppLinkUrl(chatId, botUserId, webAppShortName, startParameter, allowWriteAccess, parameters)
    val requestJson = tdJson.encodeToString(GetWebAppLinkUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(WebAppUrl.serializer(), responseJson)
}

/**
 * Returns information needed to open the main Web App of a bot
 * @param chatId Identifier of the chat in which the Web App is opened; pass 0 if none
 * @param botUserId Identifier of the target bot. If the bot is restricted for the current user, then show an error instead of calling the method
 * @param startParameter Start parameter from internalLinkTypeMainWebApp
 * @param parameters Parameters to use to open the Web App
 */
suspend fun TdKtxClient.getMainWebApp(
    chatId: Long,
    botUserId: Long,
    startParameter: String? = null,
    parameters: WebAppOpenParameters? = null,
): MainWebApp {
    val request = GetMainWebApp(chatId, botUserId, startParameter, parameters)
    val requestJson = tdJson.encodeToString(GetMainWebApp.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MainWebApp.serializer(), responseJson)
}

/**
 * Returns an HTTPS URL of a Web App to open from the side menu, a keyboardButtonTypeWebApp button, or an inlineQueryResultsButtonTypeWebApp button
 * @param botUserId Identifier of the target bot. If the bot is restricted for the current user, then show an error instead of calling the method
 * @param url The URL from a keyboardButtonTypeWebApp button, inlineQueryResultsButtonTypeWebApp button, or an empty string when the bot is opened from the side menu
 * @param parameters Parameters to use to open the Web App
 */
suspend fun TdKtxClient.getWebAppUrl(
    botUserId: Long,
    url: String? = null,
    parameters: WebAppOpenParameters? = null,
): WebAppUrl {
    val request = GetWebAppUrl(botUserId, url, parameters)
    val requestJson = tdJson.encodeToString(GetWebAppUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(WebAppUrl.serializer(), responseJson)
}

/**
 * Sends data received from a keyboardButtonTypeWebApp Web App to a bot
 * @param botUserId Identifier of the target bot
 * @param buttonText Text of the keyboardButtonTypeWebApp button, which opened the Web App
 * @param data The data
 */
suspend fun TdKtxClient.sendWebAppData(
    botUserId: Long,
    buttonText: String? = null,
    data: String? = null,
): Ok {
    val request = SendWebAppData(botUserId, buttonText, data)
    val requestJson = tdJson.encodeToString(SendWebAppData.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that a Web App is being opened from the attachment menu, a botMenuButton button, an internalLinkTypeAttachmentMenuBot link, or an inlineKeyboardButtonTypeWebApp button. For each bot, a confirmation alert about data sent to the bot must be shown once
 * @param chatId Identifier of the chat in which the Web App is opened. The Web App can't be opened in secret chats
 * @param botUserId Identifier of the bot, providing the Web App. If the bot is restricted for the current user, then show an error instead of calling the method
 * @param url The URL from an inlineKeyboardButtonTypeWebApp button, a botMenuButton button, an internalLinkTypeAttachmentMenuBot link, or an empty string otherwise
 * @param topicId Topic in which the message will be sent; pass null if none
 * @param replyTo Information about the message or story to be replied in the message sent by the Web App; pass null if none
 * @param parameters Parameters to use to open the Web App
 */
suspend fun TdKtxClient.openWebApp(
    chatId: Long,
    botUserId: Long,
    url: String? = null,
    topicId: MessageTopic? = null,
    replyTo: InputMessageReplyTo? = null,
    parameters: WebAppOpenParameters? = null,
): WebAppInfo {
    val request = OpenWebApp(chatId, botUserId, url, topicId, replyTo, parameters)
    val requestJson = tdJson.encodeToString(OpenWebApp.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(WebAppInfo.serializer(), responseJson)
}

/**
 * Informs TDLib that a previously opened Web App was closed @web_app_launch_id Identifier of Web App launch, received from openWebApp
 */
suspend fun TdKtxClient.closeWebApp(
    webAppLaunchId: Long,
): Ok {
    val request = CloseWebApp(webAppLaunchId)
    val requestJson = tdJson.encodeToString(CloseWebApp.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the result of interaction with a Web App and sends corresponding message on behalf of the user to the chat from which the query originated; for bots only
 * @param webAppQueryId Identifier of the Web App query
 * @param result The result of the query
 */
suspend fun TdKtxClient.answerWebAppQuery(
    webAppQueryId: String? = null,
    result: InputInlineQueryResult? = null,
): InlineMessageId {
    val request = AnswerWebAppQuery(webAppQueryId, result)
    val requestJson = tdJson.encodeToString(AnswerWebAppQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(InlineMessageId.serializer(), responseJson)
}

/**
 * Checks whether a file can be downloaded and saved locally by Web App request
 * @param botUserId Identifier of the bot, providing the Web App
 * @param fileName Name of the file
 * @param url URL of the file
 */
suspend fun TdKtxClient.checkWebAppFileDownload(
    botUserId: Long,
    fileName: String? = null,
    url: String? = null,
): Ok {
    val request = CheckWebAppFileDownload(botUserId, fileName, url)
    val requestJson = tdJson.encodeToString(CheckWebAppFileDownload.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the result of a chat join query; for bots only
 * @param queryId Identifier of the query
 * @param result The result
 * @param url URL of the Web App to open
 */
suspend fun TdKtxClient.answerChatJoinRequestQuery(
    queryId: Long,
    result: ChatJoinRequestResult? = null,
    url: String? = null,
): Ok {
    val request = AnswerChatJoinRequestQuery(queryId, result, url)
    val requestJson = tdJson.encodeToString(AnswerChatJoinRequestQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a callback query to a bot and returns an answer. Returns an error with code 502 if the bot fails to answer the query before the query timeout expires
 * @param chatId Identifier of the chat with the message
 * @param messageId Identifier of the message from which the query originated. The message must not be scheduled
 * @param payload Query payload
 */
suspend fun TdKtxClient.getCallbackQueryAnswer(
    chatId: Long,
    messageId: Long,
    payload: CallbackQueryPayload? = null,
): CallbackQueryAnswer {
    val request = GetCallbackQueryAnswer(chatId, messageId, payload)
    val requestJson = tdJson.encodeToString(GetCallbackQueryAnswer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CallbackQueryAnswer.serializer(), responseJson)
}

/**
 * Sets the result of a callback query; for bots only
 * @param callbackQueryId Identifier of the callback query
 * @param text Text of the answer
 * @param showAlert Pass true to show an alert to the user instead of a toast notification
 * @param url URL to be opened
 * @param cacheTime Time during which the result of the query can be cached, in seconds
 */
suspend fun TdKtxClient.answerCallbackQuery(
    callbackQueryId: Long,
    text: String? = null,
    showAlert: Boolean,
    url: String? = null,
    cacheTime: Int,
): Ok {
    val request = AnswerCallbackQuery(callbackQueryId, text, showAlert, url, cacheTime)
    val requestJson = tdJson.encodeToString(AnswerCallbackQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the result of a shipping query; for bots only @shipping_query_id Identifier of the shipping query @shipping_options Available shipping options @error_message An error message, empty on success
 */
suspend fun TdKtxClient.answerShippingQuery(
    shippingQueryId: Long,
    shippingOptions: List<ShippingOption>? = null,
    errorMessage: String? = null,
): Ok {
    val request = AnswerShippingQuery(shippingQueryId, shippingOptions, errorMessage)
    val requestJson = tdJson.encodeToString(AnswerShippingQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the result of a pre-checkout query; for bots only @pre_checkout_query_id Identifier of the pre-checkout query @error_message An error message, empty on success
 */
suspend fun TdKtxClient.answerPreCheckoutQuery(
    preCheckoutQueryId: Long,
    errorMessage: String? = null,
): Ok {
    val request = AnswerPreCheckoutQuery(preCheckoutQueryId, errorMessage)
    val requestJson = tdJson.encodeToString(AnswerPreCheckoutQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Updates the game score of the specified user in the game; for bots only
 * @param chatId The chat to which the message with the game belongs
 * @param messageId Identifier of the message
 * @param editMessage Pass true to edit the game message to include the current scoreboard
 * @param userId User identifier
 * @param score The new score
 * @param force Pass true to update the score even if it decreases. If the score is 0, the user will be deleted from the high score table
 */
suspend fun TdKtxClient.setGameScore(
    chatId: Long,
    messageId: Long,
    editMessage: Boolean,
    userId: Long,
    score: Int,
    force: Boolean,
): Message {
    val request = SetGameScore(chatId, messageId, editMessage, userId, score, force)
    val requestJson = tdJson.encodeToString(SetGameScore.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Updates the game score of the specified user in a game; for bots only
 * @param inlineMessageId Inline message identifier
 * @param editMessage Pass true to edit the game message to include the current scoreboard
 * @param userId User identifier
 * @param score The new score
 * @param force Pass true to update the score even if it decreases. If the score is 0, the user will be deleted from the high score table
 */
suspend fun TdKtxClient.setInlineGameScore(
    inlineMessageId: String? = null,
    editMessage: Boolean,
    userId: Long,
    score: Int,
    force: Boolean,
): Ok {
    val request = SetInlineGameScore(inlineMessageId, editMessage, userId, score, force)
    val requestJson = tdJson.encodeToString(SetInlineGameScore.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the high scores for a game and some part of the high score table in the range of the specified user; for bots only @chat_id The chat that contains the message with the game @message_id Identifier of the message @user_id User identifier
 */
suspend fun TdKtxClient.getGameHighScores(
    chatId: Long,
    messageId: Long,
    userId: Long,
): GameHighScores {
    val request = GetGameHighScores(chatId, messageId, userId)
    val requestJson = tdJson.encodeToString(GetGameHighScores.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GameHighScores.serializer(), responseJson)
}

/**
 * Returns game high scores and some part of the high score table in the range of the specified user; for bots only @inline_message_id Inline message identifier @user_id User identifier
 */
suspend fun TdKtxClient.getInlineGameHighScores(
    inlineMessageId: String? = null,
    userId: Long,
): GameHighScores {
    val request = GetInlineGameHighScores(inlineMessageId, userId)
    val requestJson = tdJson.encodeToString(GetInlineGameHighScores.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GameHighScores.serializer(), responseJson)
}

/**
 * Deletes the default reply markup from a chat. Must be called after a one-time keyboard or a replyMarkupForceReply reply markup has been used or dismissed
 * @param chatId Chat identifier
 * @param messageId The message identifier of the used keyboard
 */
suspend fun TdKtxClient.deleteChatReplyMarkup(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = DeleteChatReplyMarkup(chatId, messageId)
    val requestJson = tdJson.encodeToString(DeleteChatReplyMarkup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a notification about user activity in a chat
 * @param chatId Chat identifier
 * @param topicId Identifier of the topic in which the action is performed; pass null if none
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request; for bots only
 * @param action The action description; pass null to cancel the currently active action
 */
suspend fun TdKtxClient.sendChatAction(
    chatId: Long,
    topicId: MessageTopic? = null,
    businessConnectionId: String? = null,
    action: ChatAction? = null,
): Ok {
    val request = SendChatAction(chatId, topicId, businessConnectionId, action)
    val requestJson = tdJson.encodeToString(SendChatAction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a draft for a being generated text message; for bots only
 * @param chatId Chat identifier
 * @param forumTopicId The forum topic identifier in which the message will be sent; pass 0 if none
 * @param draftId Unique identifier of the draft
 * @param text Draft text of the message; pass null to show a "Thinking..." placeholder
 */
suspend fun TdKtxClient.sendTextMessageDraft(
    chatId: Long,
    forumTopicId: Int,
    draftId: Long,
    text: FormattedText? = null,
): Ok {
    val request = SendTextMessageDraft(chatId, forumTopicId, draftId, text)
    val requestJson = tdJson.encodeToString(SendTextMessageDraft.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a draft for a being generated rich message; for bots only
 * @param chatId Chat identifier
 * @param forumTopicId The forum topic identifier in which the message will be sent; pass 0 if none
 * @param draftId Unique identifier of the draft
 * @param message Draft of the message
 */
suspend fun TdKtxClient.sendRichMessageDraft(
    chatId: Long,
    forumTopicId: Int,
    draftId: Long,
    message: InputRichMessage? = null,
): Ok {
    val request = SendRichMessageDraft(chatId, forumTopicId, draftId, message)
    val requestJson = tdJson.encodeToString(SendRichMessageDraft.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the chat is opened by the user. Many useful activities depend on the chat being opened or closed (e.g., in supergroups and channels all updates are received only for opened chats) @chat_id Chat identifier
 */
suspend fun TdKtxClient.openChat(
    chatId: Long,
): Ok {
    val request = OpenChat(chatId)
    val requestJson = tdJson.encodeToString(OpenChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the chat is closed by the user. Many useful activities depend on the chat being opened or closed @chat_id Chat identifier
 */
suspend fun TdKtxClient.closeChat(
    chatId: Long,
): Ok {
    val request = CloseChat(chatId)
    val requestJson = tdJson.encodeToString(CloseChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that messages are being viewed by the user. Sponsored messages must be marked as viewed only when the entire text of the message is shown on the screen (excluding the button). Many useful activities depend on whether the messages are currently being viewed or not (e.g., marking messages as read, incrementing a view counter, updating a view counter, removing deleted messages in supergroups and channels)
 * @param chatId Chat identifier
 * @param messageIds The identifiers of the messages being viewed
 * @param source Source of the message view; pass null to guess the source based on chat open state
 * @param forceRead Pass true to mark as read the specified messages even if the chat is closed
 */
suspend fun TdKtxClient.viewMessages(
    chatId: Long,
    messageIds: List<Long>? = null,
    source: MessageSource? = null,
    forceRead: Boolean,
): Ok {
    val request = ViewMessages(chatId, messageIds, source, forceRead)
    val requestJson = tdJson.encodeToString(ViewMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the message content has been opened (e.g., the user has opened a photo, video, document, location or venue, or has listened to an audio file or voice note message). An updateMessageContentOpened update will be generated if something has changed
 * @param chatId Chat identifier of the message
 * @param messageId Identifier of the message with the opened content
 */
suspend fun TdKtxClient.openMessageContent(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = OpenMessageContent(chatId, messageId)
    val requestJson = tdJson.encodeToString(OpenMessageContent.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that a message with an animated emoji was clicked by the user. Returns a big animated sticker to be played or a 404 error if usual animation needs to be played @chat_id Chat identifier of the message @message_id Identifier of the clicked message
 */
suspend fun TdKtxClient.clickAnimatedEmojiMessage(
    chatId: Long,
    messageId: Long,
): Sticker {
    val request = ClickAnimatedEmojiMessage(chatId, messageId)
    val requestJson = tdJson.encodeToString(ClickAnimatedEmojiMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Sticker.serializer(), responseJson)
}

/**
 * Informs TDLib that an audio was listened by the user
 * @param audioFileId Identifier of the file with an audio
 * @param duration Duration of the listening to the audio, in seconds
 */
suspend fun TdKtxClient.listenToAudio(
    audioFileId: Int,
    duration: Int,
): Ok {
    val request = ListenToAudio(audioFileId, duration)
    val requestJson = tdJson.encodeToString(ListenToAudio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib about details of a message view by the user from a chat, a message thread or a forum topic history. The method must be called if the message wasn't seen for more than 300 milliseconds, the viewport was destroyed, or the total view duration exceeded 5 minutes
 * @param chatId Chat identifier
 * @param messageId The identifier of the message being viewed
 * @param timeInViewMs The amount of time the message was seen by at least 1 pixel; in milliseconds
 * @param activeTimeInViewMs The amount of time the message was seen by at least 1 pixel within 15 seconds after any action from the user; in milliseconds
 * @param heightToViewportRatioPerMille The ratio of the post height to the viewport height in 1/1000 fractions
 * @param seenRangeRatioPerMille The ratio of the viewed post height to the full post height in 1/1000 fractions; 0-1000
 */
suspend fun TdKtxClient.sendMessageViewMetrics(
    chatId: Long,
    messageId: Long,
    timeInViewMs: Int,
    activeTimeInViewMs: Int,
    heightToViewportRatioPerMille: Int,
    seenRangeRatioPerMille: Int,
): Ok {
    val request = SendMessageViewMetrics(chatId, messageId, timeInViewMs, activeTimeInViewMs, heightToViewportRatioPerMille, seenRangeRatioPerMille)
    val requestJson = tdJson.encodeToString(SendMessageViewMetrics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns an HTTPS or a tg: link with the given type. Can be called before authorization @type Expected type of the link @is_http Pass true to create an HTTPS link (only available for some link types); pass false to create a tg: link
 */
suspend fun TdKtxClient.getInternalLink(
    type: InternalLinkType? = null,
    isHttp: Boolean,
): HttpUrl {
    val request = GetInternalLink(type, isHttp)
    val requestJson = tdJson.encodeToString(GetInternalLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns information about the type of internal link. Returns a 404 error if the link is not internal. Can be called before authorization @link The link
 */
suspend fun TdKtxClient.getInternalLinkType(
    link: String? = null,
): InternalLinkType {
    val request = GetInternalLinkType(link)
    val requestJson = tdJson.encodeToString(GetInternalLinkType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(InternalLinkType.serializer(), responseJson)
}

/**
 * Returns information about an action to be done when the current user clicks an external link. Don't use this method for links from secret chats if link preview is disabled in secret chats, and use directly getLinkWebBrowserType
 * @param link The link
 */
suspend fun TdKtxClient.getExternalLinkInfo(
    link: String? = null,
): LoginUrlInfo {
    val request = GetExternalLinkInfo(link)
    val requestJson = tdJson.encodeToString(GetExternalLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LoginUrlInfo.serializer(), responseJson)
}

/**
 * Returns an HTTP URL which can be used to automatically authorize the current user on a website after clicking an HTTP link. Use the method getExternalLinkInfo to find whether a prior user confirmation is needed. May return an empty link if just a toast about successful login has to be shown
 * @param link The HTTP link
 * @param allowWriteAccess Pass true if the current user allowed the bot that was returned in getExternalLinkInfo, to send them messages
 */
suspend fun TdKtxClient.getExternalLink(
    link: String? = null,
    allowWriteAccess: Boolean,
): HttpUrl {
    val request = GetExternalLink(link, allowWriteAccess)
    val requestJson = tdJson.encodeToString(GetExternalLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns a type of the web browser which must be used to open the link
 * @param link The HTTP link
 */
suspend fun TdKtxClient.getLinkWebBrowserType(
    link: String? = null,
): WebBrowserType {
    val request = GetLinkWebBrowserType(link)
    val requestJson = tdJson.encodeToString(GetLinkWebBrowserType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(WebBrowserType.serializer(), responseJson)
}

/**
 * Returns information about an OAuth deep link. Use checkOauthRequestMatchCode, acceptOauthRequest or declineOauthRequest to process the link
 * @param url URL of the link
 * @param inAppOrigin Origin of the OAuth request if the request was received from the in-app browser; pass an empty string otherwise
 */
suspend fun TdKtxClient.getOauthLinkInfo(
    url: String? = null,
    inAppOrigin: String? = null,
): OauthLinkInfo {
    val request = GetOauthLinkInfo(url, inAppOrigin)
    val requestJson = tdJson.encodeToString(GetOauthLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(OauthLinkInfo.serializer(), responseJson)
}

/**
 * Checks a match-code for an OAuth authorization request. If fails, then the authorization request has failed. Otherwise, authorization confirmation dialog must be shown and the link must be processed using acceptOauthRequest or declineOauthRequest
 * @param url URL of the OAuth deep link
 * @param matchCode The matching code chosen by the user
 */
suspend fun TdKtxClient.checkOauthRequestMatchCode(
    url: String? = null,
    matchCode: String? = null,
): Ok {
    val request = CheckOauthRequestMatchCode(url, matchCode)
    val requestJson = tdJson.encodeToString(CheckOauthRequestMatchCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Accepts an OAuth authorization request. Returns an HTTP URL to open after successful authorization. May return an empty link if just a toast about successful login has to be shown
 * @param url URL of the OAuth deep link
 * @param matchCode The matching code chosen by the user
 * @param allowWriteAccess Pass true if the current user allowed the bot that was returned in getOauthLinkInfo, to send them messages
 * @param allowPhoneNumberAccess Pass true if the current user allowed the bot that was returned in getOauthLinkInfo, to access their phone number
 */
suspend fun TdKtxClient.acceptOauthRequest(
    url: String? = null,
    matchCode: String? = null,
    allowWriteAccess: Boolean,
    allowPhoneNumberAccess: Boolean,
): HttpUrl {
    val request = AcceptOauthRequest(url, matchCode, allowWriteAccess, allowPhoneNumberAccess)
    val requestJson = tdJson.encodeToString(AcceptOauthRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Declines an OAuth authorization request
 * @param url URL of the OAuth deep link
 */
suspend fun TdKtxClient.declineOauthRequest(
    url: String? = null,
): Ok {
    val request = DeclineOauthRequest(url)
    val requestJson = tdJson.encodeToString(DeclineOauthRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all mentions in a chat as read @chat_id Chat identifier
 */
suspend fun TdKtxClient.readAllChatMentions(
    chatId: Long,
): Ok {
    val request = ReadAllChatMentions(chatId)
    val requestJson = tdJson.encodeToString(ReadAllChatMentions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all reactions in a chat as read @chat_id Chat identifier
 */
suspend fun TdKtxClient.readAllChatReactions(
    chatId: Long,
): Ok {
    val request = ReadAllChatReactions(chatId)
    val requestJson = tdJson.encodeToString(ReadAllChatReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Marks all poll votes in a chat as read @chat_id Chat identifier
 */
suspend fun TdKtxClient.readAllChatPollVotes(
    chatId: Long,
): Ok {
    val request = ReadAllChatPollVotes(chatId)
    val requestJson = tdJson.encodeToString(ReadAllChatPollVotes.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns an existing chat corresponding to a given user @user_id User identifier @force Pass true to create the chat without a network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TdKtxClient.createPrivateChat(
    userId: Long,
    force: Boolean,
): Chat {
    val request = CreatePrivateChat(userId, force)
    val requestJson = tdJson.encodeToString(CreatePrivateChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Returns an existing chat corresponding to a known basic group @basic_group_id Basic group identifier @force Pass true to create the chat without a network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TdKtxClient.createBasicGroupChat(
    basicGroupId: Long,
    force: Boolean,
): Chat {
    val request = CreateBasicGroupChat(basicGroupId, force)
    val requestJson = tdJson.encodeToString(CreateBasicGroupChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Returns an existing chat corresponding to a known supergroup or channel @supergroup_id Supergroup or channel identifier @force Pass true to create the chat without a network request. In this case all information about the chat except its type, title and photo can be incorrect
 */
suspend fun TdKtxClient.createSupergroupChat(
    supergroupId: Long,
    force: Boolean,
): Chat {
    val request = CreateSupergroupChat(supergroupId, force)
    val requestJson = tdJson.encodeToString(CreateSupergroupChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Returns an existing chat corresponding to a known secret chat @secret_chat_id Secret chat identifier
 */
suspend fun TdKtxClient.createSecretChat(
    secretChatId: Int,
): Chat {
    val request = CreateSecretChat(secretChatId)
    val requestJson = tdJson.encodeToString(CreateSecretChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Creates a new basic group and sends a corresponding messageBasicGroupChatCreate. Returns information about the newly created chat
 * @param userIds Identifiers of users to be added to the basic group; may be empty to create a basic group without other members
 * @param title Title of the new basic group; 1-128 characters
 * @param messageAutoDeleteTime Message auto-delete time value, in seconds; must be from 0 up to 365 * 86400 and be divisible by 86400. If 0, then messages aren't deleted automatically
 */
suspend fun TdKtxClient.createNewBasicGroupChat(
    userIds: List<Long>? = null,
    title: String? = null,
    messageAutoDeleteTime: Int,
): CreatedBasicGroupChat {
    val request = CreateNewBasicGroupChat(userIds, title, messageAutoDeleteTime)
    val requestJson = tdJson.encodeToString(CreateNewBasicGroupChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CreatedBasicGroupChat.serializer(), responseJson)
}

/**
 * Creates a new supergroup or channel and sends a corresponding messageSupergroupChatCreate. Returns the newly created chat
 * @param title Title of the new chat; 1-128 characters
 * @param isForum Pass true to create a forum supergroup chat
 * @param isChannel Pass true to create a channel chat; ignored if a forum is created
 * @param location Chat location if a location-based supergroup is being created; pass null to create an ordinary supergroup chat
 * @param messageAutoDeleteTime Message auto-delete time value, in seconds; must be from 0 up to 365 * 86400 and be divisible by 86400. If 0, then messages aren't deleted automatically
 * @param forImport Pass true to create a supergroup for importing messages using importMessages
 */
suspend fun TdKtxClient.createNewSupergroupChat(
    title: String? = null,
    isForum: Boolean,
    isChannel: Boolean,
    description: String? = null,
    location: ChatLocation? = null,
    messageAutoDeleteTime: Int,
    forImport: Boolean,
): Chat {
    val request = CreateNewSupergroupChat(title, isForum, isChannel, description, location, messageAutoDeleteTime, forImport)
    val requestJson = tdJson.encodeToString(CreateNewSupergroupChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Creates a new secret chat. Returns the newly created chat @user_id Identifier of the target user
 */
suspend fun TdKtxClient.createNewSecretChat(
    userId: Long,
): Chat {
    val request = CreateNewSecretChat(userId)
    val requestJson = tdJson.encodeToString(CreateNewSecretChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Creates a new supergroup from an existing basic group and sends a corresponding messageChatUpgradeTo and messageChatUpgradeFrom; requires owner privileges. Deactivates the original basic group @chat_id Identifier of the chat to upgrade
 */
suspend fun TdKtxClient.upgradeBasicGroupChatToSupergroupChat(
    chatId: Long,
): Chat {
    val request = UpgradeBasicGroupChatToSupergroupChat(chatId)
    val requestJson = tdJson.encodeToString(UpgradeBasicGroupChatToSupergroupChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Returns chat lists to which the chat can be added. This is an offline method @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatListsToAddChat(
    chatId: Long,
): ChatLists {
    val request = GetChatListsToAddChat(chatId)
    val requestJson = tdJson.encodeToString(GetChatListsToAddChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatLists.serializer(), responseJson)
}

/**
 * Adds a chat to a chat list. A chat can't be simultaneously in Main and Archive chat lists, so it is automatically removed from another one if needed
 * @param chatId Chat identifier
 * @param chatList The chat list. Use getChatListsToAddChat to get suitable chat lists
 */
suspend fun TdKtxClient.addChatToList(
    chatId: Long,
    chatList: ChatList? = null,
): Ok {
    val request = AddChatToList(chatId, chatList)
    val requestJson = tdJson.encodeToString(AddChatToList.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a chat folder by its identifier @chat_folder_id Chat folder identifier
 */
suspend fun TdKtxClient.getChatFolder(
    chatFolderId: Int,
): ChatFolder {
    val request = GetChatFolder(chatFolderId)
    val requestJson = tdJson.encodeToString(GetChatFolder.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolder.serializer(), responseJson)
}

/**
 * Creates new chat folder. Returns information about the created chat folder. There can be up to getOption("chat_folder_count_max") chat folders, but the limit can be increased with Telegram Premium @folder The new chat folder
 */
suspend fun TdKtxClient.createChatFolder(
    folder: ChatFolder? = null,
): ChatFolderInfo {
    val request = CreateChatFolder(folder)
    val requestJson = tdJson.encodeToString(CreateChatFolder.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInfo.serializer(), responseJson)
}

/**
 * Edits existing chat folder. Returns information about the edited chat folder @chat_folder_id Chat folder identifier @folder The edited chat folder
 */
suspend fun TdKtxClient.editChatFolder(
    chatFolderId: Int,
    folder: ChatFolder? = null,
): ChatFolderInfo {
    val request = EditChatFolder(chatFolderId, folder)
    val requestJson = tdJson.encodeToString(EditChatFolder.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInfo.serializer(), responseJson)
}

/**
 * Deletes existing chat folder @chat_folder_id Chat folder identifier @leave_chat_ids Identifiers of the chats to leave. The chats must be pinned or always included in the folder
 */
suspend fun TdKtxClient.deleteChatFolder(
    chatFolderId: Int,
    leaveChatIds: List<Long>? = null,
): Ok {
    val request = DeleteChatFolder(chatFolderId, leaveChatIds)
    val requestJson = tdJson.encodeToString(DeleteChatFolder.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns identifiers of pinned or always included chats from a chat folder, which are suggested to be left when the chat folder is deleted @chat_folder_id Chat folder identifier
 */
suspend fun TdKtxClient.getChatFolderChatsToLeave(
    chatFolderId: Int,
): Chats {
    val request = GetChatFolderChatsToLeave(chatFolderId)
    val requestJson = tdJson.encodeToString(GetChatFolderChatsToLeave.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns approximate number of chats in a being created chat folder. Main and archive chat lists must be fully preloaded for this function to work correctly @folder The new chat folder
 */
suspend fun TdKtxClient.getChatFolderChatCount(
    folder: ChatFolder? = null,
): Count {
    val request = GetChatFolderChatCount(folder)
    val requestJson = tdJson.encodeToString(GetChatFolderChatCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Changes the order of chat folders @chat_folder_ids Identifiers of chat folders in the new correct order @main_chat_list_position Position of the main chat list among chat folders, 0-based. Can be non-zero only for Premium users
 */
suspend fun TdKtxClient.reorderChatFolders(
    chatFolderIds: List<Int>? = null,
    mainChatListPosition: Int,
): Ok {
    val request = ReorderChatFolders(chatFolderIds, mainChatListPosition)
    val requestJson = tdJson.encodeToString(ReorderChatFolders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether chat folder tags are enabled @are_tags_enabled Pass true to enable folder tags; pass false to disable them
 */
suspend fun TdKtxClient.toggleChatFolderTags(
    areTagsEnabled: Boolean,
): Ok {
    val request = ToggleChatFolderTags(areTagsEnabled)
    val requestJson = tdJson.encodeToString(ToggleChatFolderTags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns recommended chat folders for the current user
 */
suspend fun TdKtxClient.getRecommendedChatFolders(
): RecommendedChatFolders {
    val request = GetRecommendedChatFolders()
    val requestJson = tdJson.encodeToString(GetRecommendedChatFolders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RecommendedChatFolders.serializer(), responseJson)
}

/**
 * Returns default icon name for a folder. Can be called synchronously @folder Chat folder
 */
suspend fun TdKtxClient.getChatFolderDefaultIconName(
    folder: ChatFolder? = null,
): ChatFolderIcon {
    val request = GetChatFolderDefaultIconName(folder)
    val requestJson = tdJson.encodeToString(GetChatFolderDefaultIconName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderIcon.serializer(), responseJson)
}

/**
 * Returns identifiers of chats from a chat folder, suitable for adding to a chat folder invite link @chat_folder_id Chat folder identifier
 */
suspend fun TdKtxClient.getChatsForChatFolderInviteLink(
    chatFolderId: Int,
): Chats {
    val request = GetChatsForChatFolderInviteLink(chatFolderId)
    val requestJson = tdJson.encodeToString(GetChatsForChatFolderInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Creates a new invite link for a chat folder. A link can be created for a chat folder if it has only pinned and included chats
 * @param chatFolderId Chat folder identifier
 * @param name Name of the link; 0-32 characters
 * @param chatIds Identifiers of chats to be accessible by the invite link. Use getChatsForChatFolderInviteLink to get suitable chats. Basic groups will be automatically converted to supergroups before link creation
 */
suspend fun TdKtxClient.createChatFolderInviteLink(
    chatFolderId: Int,
    name: String? = null,
    chatIds: List<Long>? = null,
): ChatFolderInviteLink {
    val request = CreateChatFolderInviteLink(chatFolderId, name, chatIds)
    val requestJson = tdJson.encodeToString(CreateChatFolderInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInviteLink.serializer(), responseJson)
}

/**
 * Returns invite links created by the current user for a shareable chat folder @chat_folder_id Chat folder identifier
 */
suspend fun TdKtxClient.getChatFolderInviteLinks(
    chatFolderId: Int,
): ChatFolderInviteLinks {
    val request = GetChatFolderInviteLinks(chatFolderId)
    val requestJson = tdJson.encodeToString(GetChatFolderInviteLinks.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInviteLinks.serializer(), responseJson)
}

/**
 * Edits an invite link for a chat folder
 * @param chatFolderId Chat folder identifier
 * @param inviteLink Invite link to be edited
 * @param name New name of the link; 0-32 characters
 * @param chatIds New identifiers of chats to be accessible by the invite link. Use getChatsForChatFolderInviteLink to get suitable chats. Basic groups will be automatically converted to supergroups before link editing
 */
suspend fun TdKtxClient.editChatFolderInviteLink(
    chatFolderId: Int,
    inviteLink: String? = null,
    name: String? = null,
    chatIds: List<Long>? = null,
): ChatFolderInviteLink {
    val request = EditChatFolderInviteLink(chatFolderId, inviteLink, name, chatIds)
    val requestJson = tdJson.encodeToString(EditChatFolderInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInviteLink.serializer(), responseJson)
}

/**
 * Deletes an invite link for a chat folder
 * @param chatFolderId Chat folder identifier
 * @param inviteLink Invite link to be deleted
 */
suspend fun TdKtxClient.deleteChatFolderInviteLink(
    chatFolderId: Int,
    inviteLink: String? = null,
): Ok {
    val request = DeleteChatFolderInviteLink(chatFolderId, inviteLink)
    val requestJson = tdJson.encodeToString(DeleteChatFolderInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the validity of an invite link for a chat folder and returns information about the corresponding chat folder @invite_link Invite link to be checked
 */
suspend fun TdKtxClient.checkChatFolderInviteLink(
    inviteLink: String? = null,
): ChatFolderInviteLinkInfo {
    val request = CheckChatFolderInviteLink(inviteLink)
    val requestJson = tdJson.encodeToString(CheckChatFolderInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatFolderInviteLinkInfo.serializer(), responseJson)
}

/**
 * Adds a chat folder by an invite link @invite_link Invite link for the chat folder @chat_ids Identifiers of the chats added to the chat folder. The chats are automatically joined if they aren't joined yet
 */
suspend fun TdKtxClient.addChatFolderByInviteLink(
    inviteLink: String? = null,
    chatIds: List<Long>? = null,
): Ok {
    val request = AddChatFolderByInviteLink(inviteLink, chatIds)
    val requestJson = tdJson.encodeToString(AddChatFolderByInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns new chats added to a shareable chat folder by its owner. The method must be called at most once in getOption("chat_folder_new_chats_update_period") for the given chat folder @chat_folder_id Chat folder identifier
 */
suspend fun TdKtxClient.getChatFolderNewChats(
    chatFolderId: Int,
): Chats {
    val request = GetChatFolderNewChats(chatFolderId)
    val requestJson = tdJson.encodeToString(GetChatFolderNewChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Process new chats added to a shareable chat folder by its owner @chat_folder_id Chat folder identifier @added_chat_ids Identifiers of the new chats, which are added to the chat folder. The chats are automatically joined if they aren't joined yet
 */
suspend fun TdKtxClient.processChatFolderNewChats(
    chatFolderId: Int,
    addedChatIds: List<Long>? = null,
): Ok {
    val request = ProcessChatFolderNewChats(chatFolderId, addedChatIds)
    val requestJson = tdJson.encodeToString(ProcessChatFolderNewChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns settings for automatic moving of chats to and from the Archive chat lists
 */
suspend fun TdKtxClient.getArchiveChatListSettings(
): ArchiveChatListSettings {
    val request = GetArchiveChatListSettings()
    val requestJson = tdJson.encodeToString(GetArchiveChatListSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ArchiveChatListSettings.serializer(), responseJson)
}

/**
 * Changes settings for automatic moving of chats to and from the Archive chat lists @settings New settings
 */
suspend fun TdKtxClient.setArchiveChatListSettings(
    settings: ArchiveChatListSettings? = null,
): Ok {
    val request = SetArchiveChatListSettings(settings)
    val requestJson = tdJson.encodeToString(SetArchiveChatListSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the chat title. Supported only for basic groups, supergroups and channels. Requires can_change_info member right
 * @param chatId Chat identifier
 * @param title New title of the chat; 1-128 characters
 */
suspend fun TdKtxClient.setChatTitle(
    chatId: Long,
    title: String? = null,
): Ok {
    val request = SetChatTitle(chatId, title)
    val requestJson = tdJson.encodeToString(SetChatTitle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the photo of a chat. Supported only for basic groups, supergroups and channels. Requires can_change_info member right
 * @param chatId Chat identifier
 * @param photo New chat photo; pass null to delete the chat photo
 */
suspend fun TdKtxClient.setChatPhoto(
    chatId: Long,
    photo: InputChatPhoto? = null,
): Ok {
    val request = SetChatPhoto(chatId, photo)
    val requestJson = tdJson.encodeToString(SetChatPhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes accent color and background custom emoji of a channel chat. Requires can_change_info administrator right
 * @param chatId Chat identifier
 * @param accentColorId Identifier of the accent color to use. The chat must have at least accentColor.min_channel_chat_boost_level boost level to pass the corresponding color
 * @param backgroundCustomEmojiId Identifier of a custom emoji to be shown on the reply header and link preview background; 0 if none. Use chatBoostLevelFeatures.can_set_background_custom_emoji to check whether a custom emoji can be set
 */
suspend fun TdKtxClient.setChatAccentColor(
    chatId: Long,
    accentColorId: Int,
    backgroundCustomEmojiId: Long,
): Ok {
    val request = SetChatAccentColor(chatId, accentColorId, backgroundCustomEmojiId)
    val requestJson = tdJson.encodeToString(SetChatAccentColor.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes accent color and background custom emoji for profile of a supergroup or channel chat. Requires can_change_info administrator right
 * @param chatId Chat identifier
 * @param profileAccentColorId Identifier of the accent color to use for profile; pass -1 if none. The chat must have at least profileAccentColor.min_supergroup_chat_boost_level for supergroups or profileAccentColor.min_channel_chat_boost_level for channels boost level to pass the corresponding color
 * @param profileBackgroundCustomEmojiId Identifier of a custom emoji to be shown on the chat's profile photo background; 0 if none. Use chatBoostLevelFeatures.can_set_profile_background_custom_emoji to check whether a custom emoji can be set
 */
suspend fun TdKtxClient.setChatProfileAccentColor(
    chatId: Long,
    profileAccentColorId: Int,
    profileBackgroundCustomEmojiId: Long,
): Ok {
    val request = SetChatProfileAccentColor(chatId, profileAccentColorId, profileBackgroundCustomEmojiId)
    val requestJson = tdJson.encodeToString(SetChatProfileAccentColor.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the message auto-delete or self-destruct (for secret chats) time in a chat. Requires change_info administrator right in basic groups, supergroups and channels. Message auto-delete time can't be changed in a chat with the current user (Saved Messages) and the chat 777000 (Telegram).
 * @param chatId Chat identifier
 * @param messageAutoDeleteTime New time value, in seconds; unless the chat is secret, it must be from 0 up to 365 * 86400 and be divisible by 86400. If 0, then messages aren't deleted automatically
 */
suspend fun TdKtxClient.setChatMessageAutoDeleteTime(
    chatId: Long,
    messageAutoDeleteTime: Int,
): Ok {
    val request = SetChatMessageAutoDeleteTime(chatId, messageAutoDeleteTime)
    val requestJson = tdJson.encodeToString(SetChatMessageAutoDeleteTime.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the emoji status of a chat. Use chatBoostLevelFeatures.can_set_emoji_status to check whether an emoji status can be set. Requires can_change_info administrator right
 * @param chatId Chat identifier
 * @param emojiStatus New emoji status; pass null to remove emoji status
 */
suspend fun TdKtxClient.setChatEmojiStatus(
    chatId: Long,
    emojiStatus: EmojiStatus? = null,
): Ok {
    val request = SetChatEmojiStatus(chatId, emojiStatus)
    val requestJson = tdJson.encodeToString(SetChatEmojiStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the chat members permissions. Supported only for basic groups and supergroups. Requires can_restrict_members administrator right
 * @param chatId Chat identifier
 * @param permissions New non-administrator members permissions in the chat
 */
suspend fun TdKtxClient.setChatPermissions(
    chatId: Long,
    permissions: ChatPermissions? = null,
): Ok {
    val request = SetChatPermissions(chatId, permissions)
    val requestJson = tdJson.encodeToString(SetChatPermissions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the background in a specific chat. Supported only in private and secret chats with non-deleted users, and in chats with sufficient boost level and can_change_info administrator right
 * @param chatId Chat identifier
 * @param background The input background to use; pass null to create a new filled or chat theme background
 * @param type Background type; pass null to use default background type for the chosen background; backgroundTypeChatTheme isn't supported for private and secret chats. Use chatBoostLevelFeatures.chat_theme_background_count and chatBoostLevelFeatures.can_set_custom_background to check whether the background type can be set in the boosted chat
 * @param darkThemeDimming Dimming of the background in dark themes, as a percentage; 0-100. Applied only to Wallpaper and Fill types of background
 * @param onlyForSelf Pass true to set background only for self; pass false to set background for all chat users. Always false for backgrounds set in boosted chats. Background can be set for both users only by Telegram Premium users and if set background isn't of the type inputBackgroundPrevious
 */
suspend fun TdKtxClient.setChatBackground(
    chatId: Long,
    background: InputBackground? = null,
    type: BackgroundType? = null,
    darkThemeDimming: Int,
    onlyForSelf: Boolean,
): Ok {
    val request = SetChatBackground(chatId, background, type, darkThemeDimming, onlyForSelf)
    val requestJson = tdJson.encodeToString(SetChatBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes background in a specific chat
 * @param chatId Chat identifier
 * @param restorePrevious Pass true to restore previously set background. Can be used only in private and secret chats with non-deleted users if userFullInfo.set_chat_background == true. Supposed to be used from messageChatSetBackground messages with the currently set background that was set for both sides by the other user
 */
suspend fun TdKtxClient.deleteChatBackground(
    chatId: Long,
    restorePrevious: Boolean,
): Ok {
    val request = DeleteChatBackground(chatId, restorePrevious)
    val requestJson = tdJson.encodeToString(DeleteChatBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns available to the current user gift chat themes
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of chat themes to return
 */
suspend fun TdKtxClient.getGiftChatThemes(
    offset: String? = null,
    limit: Int,
): GiftChatThemes {
    val request = GetGiftChatThemes(offset, limit)
    val requestJson = tdJson.encodeToString(GetGiftChatThemes.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftChatThemes.serializer(), responseJson)
}

/**
 * Changes the chat theme. Supported only in private and secret chats @chat_id Chat identifier @theme New chat theme; pass null to return the default theme
 */
suspend fun TdKtxClient.setChatTheme(
    chatId: Long,
    theme: InputChatTheme? = null,
): Ok {
    val request = SetChatTheme(chatId, theme)
    val requestJson = tdJson.encodeToString(SetChatTheme.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the draft message in a chat or a topic
 * @param chatId Chat identifier
 * @param topicId Topic in which the draft will be changed; pass null to change the draft for the chat itself
 * @param draftMessage New draft message; pass null to remove the draft. All files in draft message content must be of the type inputFileLocal. Media thumbnails and captions are ignored
 */
suspend fun TdKtxClient.setChatDraftMessage(
    chatId: Long,
    topicId: MessageTopic? = null,
    draftMessage: DraftMessage? = null,
): Ok {
    val request = SetChatDraftMessage(chatId, topicId, draftMessage)
    val requestJson = tdJson.encodeToString(SetChatDraftMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the notification settings of a chat. Notification settings of a chat with the current user (Saved Messages) can't be changed
 * @param chatId Chat identifier
 * @param notificationSettings New notification settings for the chat. If the chat is muted for more than 366 days, it is considered to be muted forever
 */
suspend fun TdKtxClient.setChatNotificationSettings(
    chatId: Long,
    notificationSettings: ChatNotificationSettings? = null,
): Ok {
    val request = SetChatNotificationSettings(chatId, notificationSettings)
    val requestJson = tdJson.encodeToString(SetChatNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the ability of users to save, forward, or copy chat content. Requires owner privileges in basic groups, supergroups and channels. Requires Telegram Premium to enable protected content in private chats. Not available in Saved Messages and private chats with bots or support accounts
 * @param chatId Chat identifier
 * @param hasProtectedContent New value of has_protected_content
 */
suspend fun TdKtxClient.toggleChatHasProtectedContent(
    chatId: Long,
    hasProtectedContent: Boolean,
): Ok {
    val request = ToggleChatHasProtectedContent(chatId, hasProtectedContent)
    val requestJson = tdJson.encodeToString(ToggleChatHasProtectedContent.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Processes request to disable has_protected_content in a chat
 * @param chatId Chat identifier
 * @param requestMessageId Identifier of the message with the request. The message must be incoming and has content of the type messageChatHasProtectedContentDisableRequested
 * @param approve Pass true to approve the request; pass false to reject the request
 */
suspend fun TdKtxClient.processChatHasProtectedContentDisableRequest(
    chatId: Long,
    requestMessageId: Long,
    approve: Boolean,
): Ok {
    val request = ProcessChatHasProtectedContentDisableRequest(chatId, requestMessageId, approve)
    val requestJson = tdJson.encodeToString(ProcessChatHasProtectedContentDisableRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the view_as_topics setting of a forum chat or Saved Messages @chat_id Chat identifier @view_as_topics New value of view_as_topics
 */
suspend fun TdKtxClient.toggleChatViewAsTopics(
    chatId: Long,
    viewAsTopics: Boolean,
): Ok {
    val request = ToggleChatViewAsTopics(chatId, viewAsTopics)
    val requestJson = tdJson.encodeToString(ToggleChatViewAsTopics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the translatable state of a chat @chat_id Chat identifier @is_translatable New value of is_translatable
 */
suspend fun TdKtxClient.toggleChatIsTranslatable(
    chatId: Long,
    isTranslatable: Boolean,
): Ok {
    val request = ToggleChatIsTranslatable(chatId, isTranslatable)
    val requestJson = tdJson.encodeToString(ToggleChatIsTranslatable.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the marked as unread state of a chat @chat_id Chat identifier @is_marked_as_unread New value of is_marked_as_unread
 */
suspend fun TdKtxClient.toggleChatIsMarkedAsUnread(
    chatId: Long,
    isMarkedAsUnread: Boolean,
): Ok {
    val request = ToggleChatIsMarkedAsUnread(chatId, isMarkedAsUnread)
    val requestJson = tdJson.encodeToString(ToggleChatIsMarkedAsUnread.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the value of the default disable_notification parameter, used when a message is sent to a chat @chat_id Chat identifier @default_disable_notification New value of default_disable_notification
 */
suspend fun TdKtxClient.toggleChatDefaultDisableNotification(
    chatId: Long,
    defaultDisableNotification: Boolean,
): Ok {
    val request = ToggleChatDefaultDisableNotification(chatId, defaultDisableNotification)
    val requestJson = tdJson.encodeToString(ToggleChatDefaultDisableNotification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes reactions, available in a chat. Available for basic groups, supergroups, and channels. Requires can_change_info member right
 * @param chatId Identifier of the chat
 * @param availableReactions Reactions available in the chat. All explicitly specified emoji reactions must be active. In channel chats up to the chat's boost level custom emoji reactions can be explicitly specified
 */
suspend fun TdKtxClient.setChatAvailableReactions(
    chatId: Long,
    availableReactions: ChatAvailableReactions? = null,
): Ok {
    val request = SetChatAvailableReactions(chatId, availableReactions)
    val requestJson = tdJson.encodeToString(SetChatAvailableReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes application-specific data associated with a chat @chat_id Chat identifier @client_data New value of client_data
 */
suspend fun TdKtxClient.setChatClientData(
    chatId: Long,
    clientData: String? = null,
): Ok {
    val request = SetChatClientData(chatId, clientData)
    val requestJson = tdJson.encodeToString(SetChatClientData.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes information about a chat. Available for basic groups, supergroups, and channels. Requires can_change_info member right @chat_id Identifier of the chat @param_description New chat description; 0-255 characters
 */
suspend fun TdKtxClient.setChatDescription(
    chatId: Long,
    description: String? = null,
): Ok {
    val request = SetChatDescription(chatId, description)
    val requestJson = tdJson.encodeToString(SetChatDescription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the discussion group of a channel chat; requires can_change_info administrator right in the channel if it is specified
 * @param chatId Identifier of the channel chat. Pass 0 to remove a link from the supergroup passed in the second argument to a linked channel chat (requires can_pin_messages member right in the supergroup)
 * @param discussionChatId Identifier of a new channel's discussion group. Use 0 to remove the discussion group. Use the method getSuitableDiscussionChats to find all suitable groups. Basic group chats must be first upgraded to supergroup chats. If new chat members don't have access to old messages in the supergroup, then toggleSupergroupIsAllHistoryAvailable must be used first to change that
 */
suspend fun TdKtxClient.setChatDiscussionGroup(
    chatId: Long,
    discussionChatId: Long,
): Ok {
    val request = SetChatDiscussionGroup(chatId, discussionChatId)
    val requestJson = tdJson.encodeToString(SetChatDiscussionGroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes direct messages group settings for a channel chat; requires owner privileges in the chat
 * @param chatId Identifier of the channel chat
 * @param isEnabled Pass true if the direct messages group is enabled for the channel chat; pass false otherwise
 * @param paidMessageStarCount The new number of Telegram Stars that must be paid for each message that is sent to the direct messages chat unless the sender is an administrator of the channel chat; 0-getOption("paid_message_star_count_max"). The channel will receive getOption("paid_message_earnings_per_mille") Telegram Stars for each 1000 Telegram Stars paid for message sending. Requires supergroupFullInfo.can_enable_paid_messages for positive amounts
 */
suspend fun TdKtxClient.setChatDirectMessagesGroup(
    chatId: Long,
    isEnabled: Boolean,
    paidMessageStarCount: Long,
): Ok {
    val request = SetChatDirectMessagesGroup(chatId, isEnabled, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(SetChatDirectMessagesGroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the location of a chat. Available only for some location-based supergroups, use supergroupFullInfo.can_set_location to check whether the method is allowed to use @chat_id Chat identifier @location New location for the chat; must be valid and not null
 */
suspend fun TdKtxClient.setChatLocation(
    chatId: Long,
    location: ChatLocation? = null,
): Ok {
    val request = SetChatLocation(chatId, location)
    val requestJson = tdJson.encodeToString(SetChatLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the slow mode delay of a chat. Available only for supergroups; requires can_restrict_members administrator right @chat_id Chat identifier @slow_mode_delay New slow mode delay for the chat, in seconds; must be one of 0, 5, 10, 30, 60, 300, 900, 3600
 */
suspend fun TdKtxClient.setChatSlowModeDelay(
    chatId: Long,
    slowModeDelay: Int,
): Ok {
    val request = SetChatSlowModeDelay(chatId, slowModeDelay)
    val requestJson = tdJson.encodeToString(SetChatSlowModeDelay.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Pins a message in a chat. A message can be pinned only if messageProperties.can_be_pinned
 * @param chatId Identifier of the chat
 * @param messageId Identifier of the new pinned message
 * @param disableNotification Pass true to disable notification about the pinned message. Notifications are always disabled in channels and private chats
 * @param onlyForSelf Pass true to pin the message only for self; private chats only
 */
suspend fun TdKtxClient.pinChatMessage(
    chatId: Long,
    messageId: Long,
    disableNotification: Boolean,
    onlyForSelf: Boolean,
): Ok {
    val request = PinChatMessage(chatId, messageId, disableNotification, onlyForSelf)
    val requestJson = tdJson.encodeToString(PinChatMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a pinned message from a chat; requires can_pin_messages member right if the chat is a basic group or supergroup, or can_edit_messages administrator right if the chat is a channel @chat_id Identifier of the chat @message_id Identifier of the removed pinned message
 */
suspend fun TdKtxClient.unpinChatMessage(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = UnpinChatMessage(chatId, messageId)
    val requestJson = tdJson.encodeToString(UnpinChatMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all pinned messages from a chat; requires can_pin_messages member right if the chat is a basic group or supergroup, or can_edit_messages administrator right if the chat is a channel @chat_id Identifier of the chat
 */
suspend fun TdKtxClient.unpinAllChatMessages(
    chatId: Long,
): Ok {
    val request = UnpinAllChatMessages(chatId)
    val requestJson = tdJson.encodeToString(UnpinAllChatMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds the current user as a new member to a chat. Private and secret chats can't be joined using this method @chat_id Chat identifier
 */
suspend fun TdKtxClient.joinChat(
    chatId: Long,
): ChatJoinResult {
    val request = JoinChat(chatId)
    val requestJson = tdJson.encodeToString(JoinChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatJoinResult.serializer(), responseJson)
}

/**
 * Removes the current user from chat members. Private and secret chats can't be left using this method @chat_id Chat identifier
 */
suspend fun TdKtxClient.leaveChat(
    chatId: Long,
): Ok {
    val request = LeaveChat(chatId)
    val requestJson = tdJson.encodeToString(LeaveChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a new member to a chat; requires can_invite_users member right. Members can't be added to private or secret chats. Returns information about members that weren't added
 * @param chatId Chat identifier
 * @param userId Identifier of the user
 * @param forwardLimit The number of earlier messages from the chat to be forwarded to the new member; up to 100. Ignored for supergroups and channels, or if the added user is a bot
 */
suspend fun TdKtxClient.addChatMember(
    chatId: Long,
    userId: Long,
    forwardLimit: Int,
): FailedToAddMembers {
    val request = AddChatMember(chatId, userId, forwardLimit)
    val requestJson = tdJson.encodeToString(AddChatMember.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FailedToAddMembers.serializer(), responseJson)
}

/**
 * Adds multiple new members to a chat; requires can_invite_users member right. Currently, this method is only available for supergroups and channels. This method can't be used to join a chat. Members can't be added to a channel if it has more than 200 members. Returns information about members that weren't added
 * @param chatId Chat identifier
 * @param userIds Identifiers of the users to be added to the chat. The maximum number of added users is 20 for supergroups and 100 for channels
 */
suspend fun TdKtxClient.addChatMembers(
    chatId: Long,
    userIds: List<Long>? = null,
): FailedToAddMembers {
    val request = AddChatMembers(chatId, userIds)
    val requestJson = tdJson.encodeToString(AddChatMembers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FailedToAddMembers.serializer(), responseJson)
}

/**
 * Changes the status of a chat member; requires can_invite_users member right to add a chat member, can_promote_members administrator right to change administrator rights of the member, and can_restrict_members administrator right to change restrictions of a user. This function is currently not suitable for transferring chat ownership; use transferChatOwnership instead. Use addChatMember or banChatMember if some additional parameters need to be passed
 * @param chatId Chat identifier
 * @param memberId Member identifier. Chats can be only banned and unbanned in supergroups and channels
 * @param status The new status of the member in the chat
 */
suspend fun TdKtxClient.setChatMemberStatus(
    chatId: Long,
    memberId: MessageSender? = null,
    status: ChatMemberStatus? = null,
): Ok {
    val request = SetChatMemberStatus(chatId, memberId, status)
    val requestJson = tdJson.encodeToString(SetChatMemberStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the tag or custom title of a chat member; requires can_manage_tags administrator right to change tag of other users; for basic groups and supergroups only
 * @param chatId Chat identifier
 * @param userId Identifier of the user, which tag is changed. Chats can't have member tags
 * @param tag The new tag of the member in the chat; 0-16 characters without emoji
 */
suspend fun TdKtxClient.setChatMemberTag(
    chatId: Long,
    userId: Long,
    tag: String? = null,
): Ok {
    val request = SetChatMemberTag(chatId, userId, tag)
    val requestJson = tdJson.encodeToString(SetChatMemberTag.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Bans a member in a chat; requires can_restrict_members administrator right. Members can't be banned in private or secret chats. In supergroups and channels, the user will not be able to return to the group on their own using invite links, etc., unless unbanned first
 * @param chatId Chat identifier
 * @param memberId Member identifier
 * @param bannedUntilDate Point in time (Unix timestamp) when the user will be unbanned; 0 if never. If the user is banned for more than 366 days or for less than 30 seconds from the current time, the user is considered to be banned forever. Ignored in basic groups and if a chat is banned
 * @param revokeMessages Pass true to delete all messages in the chat for the user who is being removed. Always true for supergroups and channels
 */
suspend fun TdKtxClient.banChatMember(
    chatId: Long,
    memberId: MessageSender? = null,
    bannedUntilDate: Int,
    revokeMessages: Boolean,
): Ok {
    val request = BanChatMember(chatId, memberId, bannedUntilDate, revokeMessages)
    val requestJson = tdJson.encodeToString(BanChatMember.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether the current session can be used to transfer a chat ownership to another user
 */
suspend fun TdKtxClient.canTransferOwnership(
): CanTransferOwnershipResult {
    val request = CanTransferOwnership()
    val requestJson = tdJson.encodeToString(CanTransferOwnership.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CanTransferOwnershipResult.serializer(), responseJson)
}

/**
 * Changes the owner of a chat; for basic groups, supergroups and channel chats only; requires owner privileges in the chat. Use the method canTransferOwnership to check whether the ownership can be transferred from the current session
 * @param chatId Chat identifier
 * @param userId Identifier of the user to which transfer the ownership. The ownership can't be transferred to a bot or to a deleted user
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.transferChatOwnership(
    chatId: Long,
    userId: Long,
    password: String? = null,
): Ok {
    val request = TransferChatOwnership(chatId, userId, password)
    val requestJson = tdJson.encodeToString(TransferChatOwnership.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the user who will become the owner of the chat after 7 days if the current user does not return to the supergroup or channel during that period or immediately for basic groups; requires owner privileges in the chat. Available only for basic groups, supergroups, and channel chats
 * @param chatId Chat identifier
 */
suspend fun TdKtxClient.getChatOwnerAfterLeaving(
    chatId: Long,
): User {
    val request = GetChatOwnerAfterLeaving(chatId)
    val requestJson = tdJson.encodeToString(GetChatOwnerAfterLeaving.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Returns information about a single member of a chat @chat_id Chat identifier @member_id Member identifier
 */
suspend fun TdKtxClient.getChatMember(
    chatId: Long,
    memberId: MessageSender? = null,
): ChatMember {
    val request = GetChatMember(chatId, memberId)
    val requestJson = tdJson.encodeToString(GetChatMember.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatMember.serializer(), responseJson)
}

/**
 * Searches for a specified query in the first name, last name and usernames of the members of a specified chat. Requires administrator rights if the chat is a channel
 * @param chatId Chat identifier
 * @param query Query to search for
 * @param limit The maximum number of users to be returned; up to 200
 * @param filter The type of users to search for; pass null to search among all chat members
 */
suspend fun TdKtxClient.searchChatMembers(
    chatId: Long,
    query: String? = null,
    limit: Int,
    filter: ChatMembersFilter? = null,
): ChatMembers {
    val request = SearchChatMembers(chatId, query, limit, filter)
    val requestJson = tdJson.encodeToString(SearchChatMembers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatMembers.serializer(), responseJson)
}

/**
 * Returns a list of administrators of the chat with their custom titles @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatAdministrators(
    chatId: Long,
): ChatAdministrators {
    val request = GetChatAdministrators(chatId)
    val requestJson = tdJson.encodeToString(GetChatAdministrators.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatAdministrators.serializer(), responseJson)
}

/**
 * Clears message drafts in all chats @exclude_secret_chats Pass true to keep local message drafts in secret chats
 */
suspend fun TdKtxClient.clearAllDraftMessages(
    excludeSecretChats: Boolean,
): Ok {
    val request = ClearAllDraftMessages(excludeSecretChats)
    val requestJson = tdJson.encodeToString(ClearAllDraftMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the current state of stake dice
 */
suspend fun TdKtxClient.getStakeDiceState(
): StakeDiceState {
    val request = GetStakeDiceState()
    val requestJson = tdJson.encodeToString(GetStakeDiceState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StakeDiceState.serializer(), responseJson)
}

/**
 * Returns saved notification sound by its identifier. Returns a 404 error if there is no saved notification sound with the specified identifier @notification_sound_id Identifier of the notification sound
 */
suspend fun TdKtxClient.getSavedNotificationSound(
    notificationSoundId: Long,
): NotificationSound {
    val request = GetSavedNotificationSound(notificationSoundId)
    val requestJson = tdJson.encodeToString(GetSavedNotificationSound.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(NotificationSound.serializer(), responseJson)
}

/**
 * Returns the list of saved notification sounds. If a sound isn't in the list, then default sound needs to be used
 */
suspend fun TdKtxClient.getSavedNotificationSounds(
): NotificationSounds {
    val request = GetSavedNotificationSounds()
    val requestJson = tdJson.encodeToString(GetSavedNotificationSounds.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(NotificationSounds.serializer(), responseJson)
}

/**
 * Adds a new notification sound to the list of saved notification sounds. The new notification sound is added to the top of the list. If it is already in the list, its position isn't changed @sound Notification sound file to add
 */
suspend fun TdKtxClient.addSavedNotificationSound(
    sound: InputFile? = null,
): NotificationSound {
    val request = AddSavedNotificationSound(sound)
    val requestJson = tdJson.encodeToString(AddSavedNotificationSound.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(NotificationSound.serializer(), responseJson)
}

/**
 * Removes a notification sound from the list of saved notification sounds @notification_sound_id Identifier of the notification sound
 */
suspend fun TdKtxClient.removeSavedNotificationSound(
    notificationSoundId: Long,
): Ok {
    val request = RemoveSavedNotificationSound(notificationSoundId)
    val requestJson = tdJson.encodeToString(RemoveSavedNotificationSound.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of chats with non-default notification settings for new messages
 * @param scope If specified, only chats from the scope will be returned; pass null to return chats from all scopes
 * @param compareSound Pass true to include in the response chats with only non-default sound
 */
suspend fun TdKtxClient.getChatNotificationSettingsExceptions(
    scope: NotificationSettingsScope? = null,
    compareSound: Boolean,
): Chats {
    val request = GetChatNotificationSettingsExceptions(scope, compareSound)
    val requestJson = tdJson.encodeToString(GetChatNotificationSettingsExceptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Returns the notification settings for chats of a given type @scope Types of chats for which to return the notification settings information
 */
suspend fun TdKtxClient.getScopeNotificationSettings(
    scope: NotificationSettingsScope? = null,
): ScopeNotificationSettings {
    val request = GetScopeNotificationSettings(scope)
    val requestJson = tdJson.encodeToString(GetScopeNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ScopeNotificationSettings.serializer(), responseJson)
}

/**
 * Changes notification settings for chats of a given type @scope Types of chats for which to change the notification settings @notification_settings The new notification settings for the given scope
 */
suspend fun TdKtxClient.setScopeNotificationSettings(
    scope: NotificationSettingsScope? = null,
    notificationSettings: ScopeNotificationSettings? = null,
): Ok {
    val request = SetScopeNotificationSettings(scope, notificationSettings)
    val requestJson = tdJson.encodeToString(SetScopeNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes notification settings for reactions @notification_settings The new notification settings for reactions
 */
suspend fun TdKtxClient.setReactionNotificationSettings(
    notificationSettings: ReactionNotificationSettings? = null,
): Ok {
    val request = SetReactionNotificationSettings(notificationSettings)
    val requestJson = tdJson.encodeToString(SetReactionNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resets all chat and scope notification settings to their default values. By default, all chats are unmuted and message previews are shown
 */
suspend fun TdKtxClient.resetAllNotificationSettings(
): Ok {
    val request = ResetAllNotificationSettings()
    val requestJson = tdJson.encodeToString(ResetAllNotificationSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the pinned state of a chat. There can be up to getOption("pinned_chat_count_max")/getOption("pinned_archived_chat_count_max") pinned non-secret chats and the same number of secret chats in the main/archive chat list. The limit can be increased with Telegram Premium
 * @param chatList Chat list in which to change the pinned state of the chat
 * @param chatId Chat identifier
 * @param isPinned Pass true to pin the chat; pass false to unpin it
 */
suspend fun TdKtxClient.toggleChatIsPinned(
    chatList: ChatList? = null,
    chatId: Long,
    isPinned: Boolean,
): Ok {
    val request = ToggleChatIsPinned(chatList, chatId, isPinned)
    val requestJson = tdJson.encodeToString(ToggleChatIsPinned.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the order of pinned chats @chat_list Chat list in which to change the order of pinned chats @chat_ids The new list of pinned chats
 */
suspend fun TdKtxClient.setPinnedChats(
    chatList: ChatList? = null,
    chatIds: List<Long>? = null,
): Ok {
    val request = SetPinnedChats(chatList, chatIds)
    val requestJson = tdJson.encodeToString(SetPinnedChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Traverses all chats in a chat list and marks all messages in the chats as read @chat_list Chat list in which to mark all chats as read
 */
suspend fun TdKtxClient.readChatList(
    chatList: ChatList? = null,
): Ok {
    val request = ReadChatList(chatList)
    val requestJson = tdJson.encodeToString(ReadChatList.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the current weather in the given location @location The location
 */
suspend fun TdKtxClient.getCurrentWeather(
    location: Location? = null,
): CurrentWeather {
    val request = GetCurrentWeather(location)
    val requestJson = tdJson.encodeToString(GetCurrentWeather.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CurrentWeather.serializer(), responseJson)
}

/**
 * Returns a story
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Story identifier
 * @param onlyLocal Pass true to get only locally available information without sending network requests
 */
suspend fun TdKtxClient.getStory(
    storyPosterChatId: Long,
    storyId: Int,
    onlyLocal: Boolean,
): Story {
    val request = GetStory(storyPosterChatId, storyId, onlyLocal)
    val requestJson = tdJson.encodeToString(GetStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Story.serializer(), responseJson)
}

/**
 * Returns supergroup and channel chats in which the current user has the right to post stories. The chats must be rechecked with canPostStory before actually trying to post a story there
 */
suspend fun TdKtxClient.getChatsToPostStories(
): Chats {
    val request = GetChatsToPostStories()
    val requestJson = tdJson.encodeToString(GetChatsToPostStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Checks whether the current user can post a story on behalf of a chat; requires can_post_stories administrator right for supergroup and channel chats
 * @param chatId Chat identifier. Pass Saved Messages chat identifier when posting a story on behalf of the current user
 */
suspend fun TdKtxClient.canPostStory(
    chatId: Long,
): CanPostStoryResult {
    val request = CanPostStory(chatId)
    val requestJson = tdJson.encodeToString(CanPostStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CanPostStoryResult.serializer(), responseJson)
}

/**
 * Posts a new story on behalf of a chat; requires can_post_stories administrator right for supergroup and channel chats. Returns a temporary story
 * @param chatId Identifier of the chat that will post the story. Pass Saved Messages chat identifier when posting a story on behalf of the current user
 * @param content Content of the story
 * @param areas Clickable rectangle areas to be shown on the story media; pass null if none
 * @param caption Story caption; pass null to use an empty caption; 0-getOption("story_caption_length_max") characters; can have entities only if getOption("can_use_text_entities_in_story_caption")
 * @param privacySettings The privacy settings for the story; ignored for stories posted on behalf of supergroup and channel chats
 * @param albumIds Identifiers of story albums to which the story will be added upon posting. An album can have up to getOption("story_album_size_max") stories
 * @param activePeriod Period after which the story is moved to archive, in seconds; must be one of 6 * 3600, 12 * 3600, 86400, or 2 * 86400 for Telegram Premium users, and 86400 otherwise
 * @param fromStoryFullId Full identifier of the original story, which content was used to create the story; pass null if the story isn't repost of another story
 * @param isPostedToChatPage Pass true to keep the story accessible after expiration
 * @param protectContent Pass true if the content of the story must be protected from forwarding and screenshotting
 */
suspend fun TdKtxClient.postStory(
    chatId: Long,
    content: InputStoryContent? = null,
    areas: InputStoryAreas? = null,
    caption: FormattedText? = null,
    privacySettings: StoryPrivacySettings? = null,
    albumIds: List<Int>? = null,
    activePeriod: Int,
    fromStoryFullId: StoryFullId? = null,
    isPostedToChatPage: Boolean,
    protectContent: Boolean,
): Story {
    val request = PostStory(chatId, content, areas, caption, privacySettings, albumIds, activePeriod, fromStoryFullId, isPostedToChatPage, protectContent)
    val requestJson = tdJson.encodeToString(PostStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Story.serializer(), responseJson)
}

/**
 * Starts a new live story on behalf of a chat; requires can_post_stories administrator right for channel chats
 * @param chatId Identifier of the chat that will start the live story. Pass Saved Messages chat identifier when starting a live story on behalf of the current user, or a channel chat identifier
 * @param privacySettings The privacy settings for the story; ignored for stories posted on behalf of channel chats
 * @param protectContent Pass true if the content of the story must be protected from screenshotting
 * @param isRtmpStream Pass true to create an RTMP stream instead of an ordinary group call
 * @param enableMessages Pass true to allow viewers of the story to send messages
 * @param paidMessageStarCount The minimum number of Telegram Stars that must be paid by viewers for each sent message to the call; 0-getOption("paid_group_call_message_star_count_max")
 */
suspend fun TdKtxClient.startLiveStory(
    chatId: Long,
    privacySettings: StoryPrivacySettings? = null,
    protectContent: Boolean,
    isRtmpStream: Boolean,
    enableMessages: Boolean,
    paidMessageStarCount: Long,
): StartLiveStoryResult {
    val request = StartLiveStory(chatId, privacySettings, protectContent, isRtmpStream, enableMessages, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(StartLiveStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StartLiveStoryResult.serializer(), responseJson)
}

/**
 * Changes content and caption of a story. Can be called only if story.can_be_edited == true
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Identifier of the story to edit
 * @param content New content of the story; pass null to keep the current content
 * @param areas New clickable rectangle areas to be shown on the story media; pass null to keep the current areas. Areas can't be edited if story content isn't changed
 * @param caption New story caption; pass null to keep the current caption
 */
suspend fun TdKtxClient.editStory(
    storyPosterChatId: Long,
    storyId: Int,
    content: InputStoryContent? = null,
    areas: InputStoryAreas? = null,
    caption: FormattedText? = null,
): Ok {
    val request = EditStory(storyPosterChatId, storyId, content, areas, caption)
    val requestJson = tdJson.encodeToString(EditStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes cover of a video story. Can be called only if story.can_be_edited == true and the story isn't being edited now
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Identifier of the story to edit
 * @param coverFrameTimestamp New timestamp of the frame, which will be used as video thumbnail
 */
suspend fun TdKtxClient.editStoryCover(
    storyPosterChatId: Long,
    storyId: Int,
    coverFrameTimestamp: Double,
): Ok {
    val request = EditStoryCover(storyPosterChatId, storyId, coverFrameTimestamp)
    val requestJson = tdJson.encodeToString(EditStoryCover.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes privacy settings of a story. The method can be called only for stories posted on behalf of the current user and if story.can_set_privacy_settings == true
 * @param storyId Identifier of the story
 * @param privacySettings The new privacy settings for the story
 */
suspend fun TdKtxClient.setStoryPrivacySettings(
    storyId: Int,
    privacySettings: StoryPrivacySettings? = null,
): Ok {
    val request = SetStoryPrivacySettings(storyId, privacySettings)
    val requestJson = tdJson.encodeToString(SetStoryPrivacySettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a story is accessible after expiration. Can be called only if story.can_toggle_is_posted_to_chat_page == true
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Identifier of the story
 * @param isPostedToChatPage Pass true to make the story accessible after expiration; pass false to make it private
 */
suspend fun TdKtxClient.toggleStoryIsPostedToChatPage(
    storyPosterChatId: Long,
    storyId: Int,
    isPostedToChatPage: Boolean,
): Ok {
    val request = ToggleStoryIsPostedToChatPage(storyPosterChatId, storyId, isPostedToChatPage)
    val requestJson = tdJson.encodeToString(ToggleStoryIsPostedToChatPage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a previously posted story. Can be called only if story.can_be_deleted == true
 * @param storyPosterChatId Identifier of the chat that posted the story
 * @param storyId Identifier of the story to delete
 */
suspend fun TdKtxClient.deleteStory(
    storyPosterChatId: Long,
    storyId: Int,
): Ok {
    val request = DeleteStory(storyPosterChatId, storyId)
    val requestJson = tdJson.encodeToString(DeleteStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of chats with non-default notification settings for stories
 */
suspend fun TdKtxClient.getStoryNotificationSettingsExceptions(
): Chats {
    val request = GetStoryNotificationSettingsExceptions()
    val requestJson = tdJson.encodeToString(GetStoryNotificationSettingsExceptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chats.serializer(), responseJson)
}

/**
 * Loads more active stories from a story list. The loaded stories will be sent through updates. Active stories are sorted by the pair (active_stories.order, active_stories.story_poster_chat_id) in descending order. Returns a 404 error if all active stories have been loaded
 * @param storyList The story list in which to load active stories
 */
suspend fun TdKtxClient.loadActiveStories(
    storyList: StoryList? = null,
): Ok {
    val request = LoadActiveStories(storyList)
    val requestJson = tdJson.encodeToString(LoadActiveStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes story list in which stories from the chat are shown @chat_id Identifier of the chat that posted stories @story_list New list for active stories posted by the chat
 */
suspend fun TdKtxClient.setChatActiveStoriesList(
    chatId: Long,
    storyList: StoryList? = null,
): Ok {
    val request = SetChatActiveStoriesList(chatId, storyList)
    val requestJson = tdJson.encodeToString(SetChatActiveStoriesList.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of active stories posted by the given chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatActiveStories(
    chatId: Long,
): ChatActiveStories {
    val request = GetChatActiveStories(chatId)
    val requestJson = tdJson.encodeToString(GetChatActiveStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatActiveStories.serializer(), responseJson)
}

/**
 * Returns the list of stories that posted by the given chat to its chat page. If from_story_id == 0, then pinned stories are returned first. Then, stories are returned in reverse chronological order (i.e., in order of decreasing story_id). For optimal performance, the number of returned stories is chosen by TDLib
 * @param chatId Chat identifier
 * @param fromStoryId Identifier of the story starting from which stories must be returned; use 0 to get results from pinned and the newest story
 * @param limit The maximum number of stories to be returned. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getChatPostedToChatPageStories(
    chatId: Long,
    fromStoryId: Int,
    limit: Int,
): Stories {
    val request = GetChatPostedToChatPageStories(chatId, fromStoryId, limit)
    val requestJson = tdJson.encodeToString(GetChatPostedToChatPageStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stories.serializer(), responseJson)
}

/**
 * Returns the list of all stories posted by the given chat; requires can_edit_stories administrator right in the chat. The stories are returned in reverse chronological order (i.e., in order of decreasing story_id). For optimal performance, the number of returned stories is chosen by TDLib
 * @param chatId Chat identifier
 * @param fromStoryId Identifier of the story starting from which stories must be returned; use 0 to get results from the last story
 * @param limit The maximum number of stories to be returned. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getChatArchivedStories(
    chatId: Long,
    fromStoryId: Int,
    limit: Int,
): Stories {
    val request = GetChatArchivedStories(chatId, fromStoryId, limit)
    val requestJson = tdJson.encodeToString(GetChatArchivedStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stories.serializer(), responseJson)
}

/**
 * Changes the list of pinned stories on a chat page; requires can_edit_stories administrator right in the chat
 * @param chatId Identifier of the chat that posted the stories
 * @param storyIds New list of pinned stories. All stories must be posted to the chat page first. There can be up to getOption("pinned_story_count_max") pinned stories on a chat page
 */
suspend fun TdKtxClient.setChatPinnedStories(
    chatId: Long,
    storyIds: List<Int>? = null,
): Ok {
    val request = SetChatPinnedStories(chatId, storyIds)
    val requestJson = tdJson.encodeToString(SetChatPinnedStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that a story is opened and is being viewed by the user
 * @param storyPosterChatId The identifier of the chat that posted the opened story
 * @param storyId The identifier of the story
 */
suspend fun TdKtxClient.openStory(
    storyPosterChatId: Long,
    storyId: Int,
): Ok {
    val request = OpenStory(storyPosterChatId, storyId)
    val requestJson = tdJson.encodeToString(OpenStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that a story is closed by the user
 * @param storyPosterChatId The identifier of the poster of the story to close
 * @param storyId The identifier of the story
 */
suspend fun TdKtxClient.closeStory(
    storyPosterChatId: Long,
    storyId: Int,
): Ok {
    val request = CloseStory(storyPosterChatId, storyId)
    val requestJson = tdJson.encodeToString(CloseStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns reactions, which can be chosen for a story @row_size Number of reaction per row, 5-25
 */
suspend fun TdKtxClient.getStoryAvailableReactions(
    rowSize: Int,
): AvailableReactions {
    val request = GetStoryAvailableReactions(rowSize)
    val requestJson = tdJson.encodeToString(GetStoryAvailableReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AvailableReactions.serializer(), responseJson)
}

/**
 * Changes chosen reaction on a story that has already been sent; not supported for live stories
 * @param storyPosterChatId The identifier of the poster of the story
 * @param storyId The identifier of the story
 * @param reactionType Type of the reaction to set; pass null to remove the reaction. Custom emoji reactions can be used only by Telegram Premium users. Paid reactions can't be set
 * @param updateRecentReactions Pass true if the reaction needs to be added to recent reactions
 */
suspend fun TdKtxClient.setStoryReaction(
    storyPosterChatId: Long,
    storyId: Int,
    reactionType: ReactionType? = null,
    updateRecentReactions: Boolean,
): Ok {
    val request = SetStoryReaction(storyPosterChatId, storyId, reactionType, updateRecentReactions)
    val requestJson = tdJson.encodeToString(SetStoryReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns interactions with a story. The method can be called only for stories posted on behalf of the current user
 * @param storyId Story identifier
 * @param query Query to search for in names, usernames and titles; may be empty to get all relevant interactions
 * @param onlyContacts Pass true to get only interactions by contacts; pass false to get all relevant interactions
 * @param preferForwards Pass true to get forwards and reposts first, then reactions, then other views; pass false to get interactions sorted just by interaction date
 * @param preferWithReaction Pass true to get interactions with reaction first; pass false to get interactions sorted just by interaction date. Ignored if prefer_forwards == true
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of story interactions to return
 */
suspend fun TdKtxClient.getStoryInteractions(
    storyId: Int,
    query: String? = null,
    onlyContacts: Boolean,
    preferForwards: Boolean,
    preferWithReaction: Boolean,
    offset: String? = null,
    limit: Int,
): StoryInteractions {
    val request = GetStoryInteractions(storyId, query, onlyContacts, preferForwards, preferWithReaction, offset, limit)
    val requestJson = tdJson.encodeToString(GetStoryInteractions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryInteractions.serializer(), responseJson)
}

/**
 * Returns interactions with a story posted in a chat. Can be used only if story is posted on behalf of a chat and the user is an administrator in the chat
 * @param storyPosterChatId The identifier of the poster of the story
 * @param storyId Story identifier
 * @param reactionType Pass the default heart reaction or a suggested reaction type to receive only interactions with the specified reaction type; pass null to receive all interactions; reactionTypePaid isn't supported
 * @param preferForwards Pass true to get forwards and reposts first, then reactions, then other views; pass false to get interactions sorted just by interaction date
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of story interactions to return
 */
suspend fun TdKtxClient.getChatStoryInteractions(
    storyPosterChatId: Long,
    storyId: Int,
    reactionType: ReactionType? = null,
    preferForwards: Boolean,
    offset: String? = null,
    limit: Int,
): StoryInteractions {
    val request = GetChatStoryInteractions(storyPosterChatId, storyId, reactionType, preferForwards, offset, limit)
    val requestJson = tdJson.encodeToString(GetChatStoryInteractions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryInteractions.serializer(), responseJson)
}

/**
 * Reports a story to the Telegram moderators
 * @param storyPosterChatId The identifier of the poster of the story to report
 * @param storyId The identifier of the story to report
 * @param optionId Option identifier chosen by the user; leave empty for the initial request
 * @param text Additional report details; 0-1024 characters; leave empty for the initial request
 */
suspend fun TdKtxClient.reportStory(
    storyPosterChatId: Long,
    storyId: Int,
    optionId: String? = null,
    text: String? = null,
): ReportStoryResult {
    val request = ReportStory(storyPosterChatId, storyId, optionId, text)
    val requestJson = tdJson.encodeToString(ReportStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReportStoryResult.serializer(), responseJson)
}

/**
 * Activates stealth mode for stories, which hides all views of stories from the current user in the last "story_stealth_mode_past_period" seconds and for the next "story_stealth_mode_future_period" seconds; for Telegram Premium users only
 */
suspend fun TdKtxClient.activateStoryStealthMode(
): Ok {
    val request = ActivateStoryStealthMode()
    val requestJson = tdJson.encodeToString(ActivateStoryStealthMode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns forwards of a story as a message to public chats and reposts by public channels. Can be used only if the story is posted on behalf of the current user or story.can_get_statistics == true. For optimal performance, the number of returned messages and stories is chosen by TDLib
 * @param storyPosterChatId The identifier of the poster of the story
 * @param storyId The identifier of the story
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages and stories to be returned; must be positive and can't be greater than 100. For optimal performance, the number of returned objects is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getStoryPublicForwards(
    storyPosterChatId: Long,
    storyId: Int,
    offset: String? = null,
    limit: Int,
): PublicForwards {
    val request = GetStoryPublicForwards(storyPosterChatId, storyId, offset, limit)
    val requestJson = tdJson.encodeToString(GetStoryPublicForwards.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PublicForwards.serializer(), responseJson)
}

/**
 * Returns the list of story albums owned by the given chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatStoryAlbums(
    chatId: Long,
): StoryAlbums {
    val request = GetChatStoryAlbums(chatId)
    val requestJson = tdJson.encodeToString(GetChatStoryAlbums.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbums.serializer(), responseJson)
}

/**
 * Returns the list of stories added to the given story album. For optimal performance, the number of returned stories is chosen by TDLib
 * @param chatId Chat identifier
 * @param storyAlbumId Story album identifier
 * @param offset Offset of the first entry to return; use 0 to get results from the first album story
 * @param limit The maximum number of stories to be returned. For optimal performance, the number of returned stories is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getStoryAlbumStories(
    chatId: Long,
    storyAlbumId: Int,
    offset: Int,
    limit: Int,
): Stories {
    val request = GetStoryAlbumStories(chatId, storyAlbumId, offset, limit)
    val requestJson = tdJson.encodeToString(GetStoryAlbumStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stories.serializer(), responseJson)
}

/**
 * Creates an album of stories; requires can_edit_stories administrator right for supergroup and channel chats
 * @param storyPosterChatId Identifier of the chat that posted the stories
 * @param name Name of the album; 1-12 characters
 * @param storyIds Identifiers of stories to add to the album; 0-getOption("story_album_size_max") identifiers
 */
suspend fun TdKtxClient.createStoryAlbum(
    storyPosterChatId: Long,
    name: String? = null,
    storyIds: List<Int>? = null,
): StoryAlbum {
    val request = CreateStoryAlbum(storyPosterChatId, name, storyIds)
    val requestJson = tdJson.encodeToString(CreateStoryAlbum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbum.serializer(), responseJson)
}

/**
 * Changes order of story albums. If the albums are owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumIds New order of story albums
 */
suspend fun TdKtxClient.reorderStoryAlbums(
    chatId: Long,
    storyAlbumIds: List<Int>? = null,
): Ok {
    val request = ReorderStoryAlbums(chatId, storyAlbumIds)
    val requestJson = tdJson.encodeToString(ReorderStoryAlbums.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a story album. If the album is owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumId Identifier of the story album
 */
suspend fun TdKtxClient.deleteStoryAlbum(
    chatId: Long,
    storyAlbumId: Int,
): Ok {
    val request = DeleteStoryAlbum(chatId, storyAlbumId)
    val requestJson = tdJson.encodeToString(DeleteStoryAlbum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes name of an album of stories. If the album is owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat. Returns the changed album
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumId Identifier of the story album
 * @param name New name of the album; 1-12 characters
 */
suspend fun TdKtxClient.setStoryAlbumName(
    chatId: Long,
    storyAlbumId: Int,
    name: String? = null,
): StoryAlbum {
    val request = SetStoryAlbumName(chatId, storyAlbumId, name)
    val requestJson = tdJson.encodeToString(SetStoryAlbumName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbum.serializer(), responseJson)
}

/**
 * Adds stories to the beginning of a previously created story album. If the album is owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat. Returns the changed album
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumId Identifier of the story album
 * @param storyIds Identifier of the stories to add to the album; 1-getOption("story_album_size_max") identifiers. If after addition the album has more than getOption("story_album_size_max") stories, then the last one are removed from the album
 */
suspend fun TdKtxClient.addStoryAlbumStories(
    chatId: Long,
    storyAlbumId: Int,
    storyIds: List<Int>? = null,
): StoryAlbum {
    val request = AddStoryAlbumStories(chatId, storyAlbumId, storyIds)
    val requestJson = tdJson.encodeToString(AddStoryAlbumStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbum.serializer(), responseJson)
}

/**
 * Removes stories from an album. If the album is owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat. Returns the changed album
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumId Identifier of the story album
 * @param storyIds Identifier of the stories to remove from the album
 */
suspend fun TdKtxClient.removeStoryAlbumStories(
    chatId: Long,
    storyAlbumId: Int,
    storyIds: List<Int>? = null,
): StoryAlbum {
    val request = RemoveStoryAlbumStories(chatId, storyAlbumId, storyIds)
    val requestJson = tdJson.encodeToString(RemoveStoryAlbumStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbum.serializer(), responseJson)
}

/**
 * Changes order of stories in an album. If the album is owned by a supergroup or a channel chat, then requires can_edit_stories administrator right in the chat. Returns the changed album
 * @param chatId Identifier of the chat that owns the stories
 * @param storyAlbumId Identifier of the story album
 * @param storyIds Identifier of the stories to move to the beginning of the album. All other stories are placed in the current order after the specified stories
 */
suspend fun TdKtxClient.reorderStoryAlbumStories(
    chatId: Long,
    storyAlbumId: Int,
    storyIds: List<Int>? = null,
): StoryAlbum {
    val request = ReorderStoryAlbumStories(chatId, storyAlbumId, storyIds)
    val requestJson = tdJson.encodeToString(ReorderStoryAlbumStories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryAlbum.serializer(), responseJson)
}

/**
 * Returns the list of features available on the specific chat boost level. This is an offline method
 * @param isChannel Pass true to get the list of features for channels; pass false to get the list of features for supergroups
 * @param level Chat boost level
 */
suspend fun TdKtxClient.getChatBoostLevelFeatures(
    isChannel: Boolean,
    level: Int,
): ChatBoostLevelFeatures {
    val request = GetChatBoostLevelFeatures(isChannel, level)
    val requestJson = tdJson.encodeToString(GetChatBoostLevelFeatures.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostLevelFeatures.serializer(), responseJson)
}

/**
 * Returns the list of features available for different chat boost levels. This is an offline method
 * @param isChannel Pass true to get the list of features for channels; pass false to get the list of features for supergroups
 */
suspend fun TdKtxClient.getChatBoostFeatures(
    isChannel: Boolean,
): ChatBoostFeatures {
    val request = GetChatBoostFeatures(isChannel)
    val requestJson = tdJson.encodeToString(GetChatBoostFeatures.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostFeatures.serializer(), responseJson)
}

/**
 * Returns the list of available chat boost slots for the current user
 */
suspend fun TdKtxClient.getAvailableChatBoostSlots(
): ChatBoostSlots {
    val request = GetAvailableChatBoostSlots()
    val requestJson = tdJson.encodeToString(GetAvailableChatBoostSlots.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostSlots.serializer(), responseJson)
}

/**
 * Returns the current boost status for a supergroup or a channel chat @chat_id Identifier of the chat
 */
suspend fun TdKtxClient.getChatBoostStatus(
    chatId: Long,
): ChatBoostStatus {
    val request = GetChatBoostStatus(chatId)
    val requestJson = tdJson.encodeToString(GetChatBoostStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostStatus.serializer(), responseJson)
}

/**
 * Boosts a chat and returns the list of available chat boost slots for the current user after the boost
 * @param chatId Identifier of the chat
 * @param slotIds Identifiers of boost slots of the current user from which to apply boosts to the chat
 */
suspend fun TdKtxClient.boostChat(
    chatId: Long,
    slotIds: List<Int>? = null,
): ChatBoostSlots {
    val request = BoostChat(chatId, slotIds)
    val requestJson = tdJson.encodeToString(BoostChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostSlots.serializer(), responseJson)
}

/**
 * Returns an HTTPS link to boost the specified supergroup or channel chat @chat_id Identifier of the chat
 */
suspend fun TdKtxClient.getChatBoostLink(
    chatId: Long,
): ChatBoostLink {
    val request = GetChatBoostLink(chatId)
    val requestJson = tdJson.encodeToString(GetChatBoostLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostLink.serializer(), responseJson)
}

/**
 * Returns information about a link to boost a chat. Can be called for any internal link of the type internalLinkTypeChatBoost @url The link to boost a chat
 */
suspend fun TdKtxClient.getChatBoostLinkInfo(
    url: String? = null,
): ChatBoostLinkInfo {
    val request = GetChatBoostLinkInfo(url)
    val requestJson = tdJson.encodeToString(GetChatBoostLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatBoostLinkInfo.serializer(), responseJson)
}

/**
 * Returns the list of boosts applied to a chat; requires administrator rights in the chat
 * @param chatId Identifier of the chat
 * @param onlyGiftCodes Pass true to receive only boosts received from gift codes and giveaways created by the chat
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of boosts to be returned; up to 100. For optimal performance, the number of returned boosts can be smaller than the specified limit
 */
suspend fun TdKtxClient.getChatBoosts(
    chatId: Long,
    onlyGiftCodes: Boolean,
    offset: String? = null,
    limit: Int,
): FoundChatBoosts {
    val request = GetChatBoosts(chatId, onlyGiftCodes, offset, limit)
    val requestJson = tdJson.encodeToString(GetChatBoosts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundChatBoosts.serializer(), responseJson)
}

/**
 * Returns the list of boosts applied to a chat by a given user; requires administrator rights in the chat; for bots only
 * @param chatId Identifier of the chat
 * @param userId Identifier of the user
 */
suspend fun TdKtxClient.getUserChatBoosts(
    chatId: Long,
    userId: Long,
): FoundChatBoosts {
    val request = GetUserChatBoosts(chatId, userId)
    val requestJson = tdJson.encodeToString(GetUserChatBoosts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundChatBoosts.serializer(), responseJson)
}

/**
 * Returns information about a bot that can be added to attachment or side menu @bot_user_id Bot's user identifier
 */
suspend fun TdKtxClient.getAttachmentMenuBot(
    botUserId: Long,
): AttachmentMenuBot {
    val request = GetAttachmentMenuBot(botUserId)
    val requestJson = tdJson.encodeToString(GetAttachmentMenuBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AttachmentMenuBot.serializer(), responseJson)
}

/**
 * Adds or removes a bot to attachment and side menu. Bot can be added to the menu, only if userTypeBot.can_be_added_to_attachment_menu == true
 * @param botUserId Bot's user identifier
 * @param isAdded Pass true to add the bot to attachment menu; pass false to remove the bot from attachment menu
 * @param allowWriteAccess Pass true if the current user allowed the bot to send them messages. Ignored if is_added is false
 */
suspend fun TdKtxClient.toggleBotIsAddedToAttachmentMenu(
    botUserId: Long,
    isAdded: Boolean,
    allowWriteAccess: Boolean,
): Ok {
    val request = ToggleBotIsAddedToAttachmentMenu(botUserId, isAdded, allowWriteAccess)
    val requestJson = tdJson.encodeToString(ToggleBotIsAddedToAttachmentMenu.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns up to 8 emoji statuses, which must be shown right after the default Premium Badge in the emoji status list for self status
 */
suspend fun TdKtxClient.getThemedEmojiStatuses(
): EmojiStatusCustomEmojis {
    val request = GetThemedEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetThemedEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatusCustomEmojis.serializer(), responseJson)
}

/**
 * Returns recent emoji statuses for self status
 */
suspend fun TdKtxClient.getRecentEmojiStatuses(
): EmojiStatuses {
    val request = GetRecentEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetRecentEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatuses.serializer(), responseJson)
}

/**
 * Returns available upgraded gift emoji statuses for self status
 */
suspend fun TdKtxClient.getUpgradedGiftEmojiStatuses(
): EmojiStatuses {
    val request = GetUpgradedGiftEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetUpgradedGiftEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatuses.serializer(), responseJson)
}

/**
 * Returns default emoji statuses for self status
 */
suspend fun TdKtxClient.getDefaultEmojiStatuses(
): EmojiStatusCustomEmojis {
    val request = GetDefaultEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetDefaultEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatusCustomEmojis.serializer(), responseJson)
}

/**
 * Clears the list of recently used emoji statuses for self status
 */
suspend fun TdKtxClient.clearRecentEmojiStatuses(
): Ok {
    val request = ClearRecentEmojiStatuses()
    val requestJson = tdJson.encodeToString(ClearRecentEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns up to 8 emoji statuses, which must be shown in the emoji status list for chats
 */
suspend fun TdKtxClient.getThemedChatEmojiStatuses(
): EmojiStatusCustomEmojis {
    val request = GetThemedChatEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetThemedChatEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatusCustomEmojis.serializer(), responseJson)
}

/**
 * Returns default emoji statuses for chats
 */
suspend fun TdKtxClient.getDefaultChatEmojiStatuses(
): EmojiStatusCustomEmojis {
    val request = GetDefaultChatEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetDefaultChatEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatusCustomEmojis.serializer(), responseJson)
}

/**
 * Returns the list of emoji statuses, which can't be used as chat emoji status, even if they are from a sticker set with is_allowed_as_chat_emoji_status == true
 */
suspend fun TdKtxClient.getDisallowedChatEmojiStatuses(
): EmojiStatusCustomEmojis {
    val request = GetDisallowedChatEmojiStatuses()
    val requestJson = tdJson.encodeToString(GetDisallowedChatEmojiStatuses.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiStatusCustomEmojis.serializer(), responseJson)
}

/**
 * Downloads a file from the cloud. Download progress and completion of the download will be notified through updateFile updates
 * @param fileId Identifier of the file to download
 * @param priority Priority of the download (1-32). The higher the priority, the earlier the file will be downloaded. If the priorities of two files are equal, then the last one for which downloadFile/addFileToDownloads was called will be downloaded first
 * @param offset The starting position from which the file needs to be downloaded
 * @param limit Number of bytes which need to be downloaded starting from the "offset" position before the download will automatically be canceled; use 0 to download without a limit
 * @param synchronous Pass true to return response only after the file download has succeeded, has failed, has been canceled, or a new downloadFile request with different offset/limit parameters was sent; pass false to return file state immediately, just after the download has been started
 */
suspend fun TdKtxClient.downloadFile(
    fileId: Int,
    priority: Int,
    offset: Long,
    limit: Long,
    synchronous: Boolean,
): File {
    val request = DownloadFile(fileId, priority, offset, limit, synchronous)
    val requestJson = tdJson.encodeToString(DownloadFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Returns file downloaded prefix size from a given offset, in bytes @file_id Identifier of the file @offset Offset from which downloaded prefix size needs to be calculated
 */
suspend fun TdKtxClient.getFileDownloadedPrefixSize(
    fileId: Int,
    offset: Long,
): FileDownloadedPrefixSize {
    val request = GetFileDownloadedPrefixSize(fileId, offset)
    val requestJson = tdJson.encodeToString(GetFileDownloadedPrefixSize.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FileDownloadedPrefixSize.serializer(), responseJson)
}

/**
 * Stops the downloading of a file. If a file has already been downloaded, does nothing @file_id Identifier of a file to stop downloading @only_if_pending Pass true to stop downloading only if it hasn't been started, i.e. request hasn't been sent to server
 */
suspend fun TdKtxClient.cancelDownloadFile(
    fileId: Int,
    onlyIfPending: Boolean,
): Ok {
    val request = CancelDownloadFile(fileId, onlyIfPending)
    val requestJson = tdJson.encodeToString(CancelDownloadFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns suggested name for saving a file in a given directory @file_id Identifier of the file @directory Directory in which the file is expected to be saved
 */
suspend fun TdKtxClient.getSuggestedFileName(
    fileId: Int,
    directory: String? = null,
): Text {
    val request = GetSuggestedFileName(fileId, directory)
    val requestJson = tdJson.encodeToString(GetSuggestedFileName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Preliminarily uploads a file to the cloud before sending it in a message, which can be useful for uploading of being recorded voice and video notes. In all other cases there is no need to preliminary upload a file. Updates updateFile will be used to notify about upload progress. The upload will not be completed until the file is sent in a message
 * @param file File to upload
 * @param fileType File type; pass null if unknown
 * @param priority Priority of the upload (1-32). The higher the priority, the earlier the file will be uploaded. If the priorities of two files are equal, then the first one for which preliminaryUploadFile was called will be uploaded first
 */
suspend fun TdKtxClient.preliminaryUploadFile(
    file: InputFile? = null,
    fileType: FileType? = null,
    priority: Int,
): File {
    val request = PreliminaryUploadFile(file, fileType, priority)
    val requestJson = tdJson.encodeToString(PreliminaryUploadFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Stops the preliminary uploading of a file. Supported only for files uploaded by using preliminaryUploadFile @file_id Identifier of the file to stop uploading
 */
suspend fun TdKtxClient.cancelPreliminaryUploadFile(
    fileId: Int,
): Ok {
    val request = CancelPreliminaryUploadFile(fileId)
    val requestJson = tdJson.encodeToString(CancelPreliminaryUploadFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Writes a part of a generated file. This method is intended to be used only if the application has no direct access to TDLib's file system, because it is usually slower than a direct write to the destination file
 * @param generationId The identifier of the generation process
 * @param offset The offset from which to write the data to the file
 * @param data The data to write
 */
suspend fun TdKtxClient.writeGeneratedFilePart(
    generationId: Long,
    offset: Long,
    data: String? = null,
): Ok {
    val request = WriteGeneratedFilePart(generationId, offset, data)
    val requestJson = tdJson.encodeToString(WriteGeneratedFilePart.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib on a file generation progress
 * @param generationId The identifier of the generation process
 * @param expectedSize Expected size of the generated file, in bytes; 0 if unknown
 * @param localPrefixSize The number of bytes already generated
 */
suspend fun TdKtxClient.setFileGenerationProgress(
    generationId: Long,
    expectedSize: Long,
    localPrefixSize: Long,
): Ok {
    val request = SetFileGenerationProgress(generationId, expectedSize, localPrefixSize)
    val requestJson = tdJson.encodeToString(SetFileGenerationProgress.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Finishes the file generation
 * @param generationId The identifier of the generation process
 * @param error If passed, the file generation has failed and must be terminated; pass null if the file generation succeeded
 */
suspend fun TdKtxClient.finishFileGeneration(
    generationId: Long,
    error: Error? = null,
): Ok {
    val request = FinishFileGeneration(generationId, error)
    val requestJson = tdJson.encodeToString(FinishFileGeneration.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reads a part of a file from the TDLib file cache and returns read bytes. This method is intended to be used only if the application has no direct access to TDLib's file system, because it is usually slower than a direct read from the file
 * @param fileId Identifier of the file. The file must be located in the TDLib file cache
 * @param offset The offset from which to read the file
 * @param count Number of bytes to read. An error will be returned if there are not enough bytes available in the file from the specified position. Pass 0 to read all available data from the specified position
 */
suspend fun TdKtxClient.readFilePart(
    fileId: Int,
    offset: Long,
    count: Long,
): Data {
    val request = ReadFilePart(fileId, offset, count)
    val requestJson = tdJson.encodeToString(ReadFilePart.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Data.serializer(), responseJson)
}

/**
 * Deletes a file from the TDLib file cache @file_id Identifier of the file to delete
 */
suspend fun TdKtxClient.deleteFile(
    fileId: Int,
): Ok {
    val request = DeleteFile(fileId)
    val requestJson = tdJson.encodeToString(DeleteFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a file from a message to the list of file downloads. Download progress and completion of the download will be notified through updateFile updates. If message database is used, the list of file downloads is persistent across application restarts. The downloading is independent of download using downloadFile, i.e. it continues if downloadFile is canceled or is used to download a part of the file
 * @param fileId Identifier of the file to download
 * @param chatId Chat identifier of the message with the file
 * @param messageId Message identifier
 * @param priority Priority of the download (1-32). The higher the priority, the earlier the file will be downloaded. If the priorities of two files are equal, then the last one for which downloadFile/addFileToDownloads was called will be downloaded first
 */
suspend fun TdKtxClient.addFileToDownloads(
    fileId: Int,
    chatId: Long,
    messageId: Long,
    priority: Int,
): File {
    val request = AddFileToDownloads(fileId, chatId, messageId, priority)
    val requestJson = tdJson.encodeToString(AddFileToDownloads.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Changes pause state of a file in the file download list
 * @param fileId Identifier of the downloaded file
 * @param isPaused Pass true if the download is paused
 */
suspend fun TdKtxClient.toggleDownloadIsPaused(
    fileId: Int,
    isPaused: Boolean,
): Ok {
    val request = ToggleDownloadIsPaused(fileId, isPaused)
    val requestJson = tdJson.encodeToString(ToggleDownloadIsPaused.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes pause state of all files in the file download list @are_paused Pass true to pause all downloads; pass false to unpause them
 */
suspend fun TdKtxClient.toggleAllDownloadsArePaused(
    arePaused: Boolean,
): Ok {
    val request = ToggleAllDownloadsArePaused(arePaused)
    val requestJson = tdJson.encodeToString(ToggleAllDownloadsArePaused.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a file from the file download list @file_id Identifier of the downloaded file @delete_from_cache Pass true to delete the file from the TDLib file cache
 */
suspend fun TdKtxClient.removeFileFromDownloads(
    fileId: Int,
    deleteFromCache: Boolean,
): Ok {
    val request = RemoveFileFromDownloads(fileId, deleteFromCache)
    val requestJson = tdJson.encodeToString(RemoveFileFromDownloads.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all files from the file download list
 * @param onlyActive Pass true to remove only active downloads, including paused
 * @param onlyCompleted Pass true to remove only completed downloads
 * @param deleteFromCache Pass true to delete the file from the TDLib file cache
 */
suspend fun TdKtxClient.removeAllFilesFromDownloads(
    onlyActive: Boolean,
    onlyCompleted: Boolean,
    deleteFromCache: Boolean,
): Ok {
    val request = RemoveAllFilesFromDownloads(onlyActive, onlyCompleted, deleteFromCache)
    val requestJson = tdJson.encodeToString(RemoveAllFilesFromDownloads.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches for files in the file download list or recently downloaded files from the list
 * @param query Query to search for; may be empty to return all downloaded files
 * @param onlyActive Pass true to search only for active downloads, including paused
 * @param onlyCompleted Pass true to search only for completed downloads
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of files to be returned
 */
suspend fun TdKtxClient.searchFileDownloads(
    query: String? = null,
    onlyActive: Boolean,
    onlyCompleted: Boolean,
    offset: String? = null,
    limit: Int,
): FoundFileDownloads {
    val request = SearchFileDownloads(query, onlyActive, onlyCompleted, offset, limit)
    val requestJson = tdJson.encodeToString(SearchFileDownloads.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundFileDownloads.serializer(), responseJson)
}

/**
 * Informs TDLib that application or reCAPTCHA verification has been completed. Can be called before authorization
 * @param verificationId Unique identifier for the verification process as received from updateApplicationVerificationRequired or updateApplicationRecaptchaVerificationRequired
 * @param token Play Integrity API token for the Android application, or secret from push notification for the iOS application for application verification, or reCAPTCHA token for reCAPTCHA verifications; pass an empty string to abort verification and receive the error "VERIFICATION_FAILED" for the request
 */
suspend fun TdKtxClient.setApplicationVerificationToken(
    verificationId: Long,
    token: String? = null,
): Ok {
    val request = SetApplicationVerificationToken(verificationId, token)
    val requestJson = tdJson.encodeToString(SetApplicationVerificationToken.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a file with messages exported from another application @message_file_head Beginning of the message file; up to 100 first lines
 */
suspend fun TdKtxClient.getMessageFileType(
    messageFileHead: String? = null,
): MessageFileType {
    val request = GetMessageFileType(messageFileHead)
    val requestJson = tdJson.encodeToString(GetMessageFileType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageFileType.serializer(), responseJson)
}

/**
 * Returns a confirmation text to be shown to the user before starting message import
 * @param chatId Identifier of a chat to which the messages will be imported. It must be an identifier of a private chat with a mutual contact or an identifier of a supergroup chat with can_change_info member right
 */
suspend fun TdKtxClient.getMessageImportConfirmationText(
    chatId: Long,
): Text {
    val request = GetMessageImportConfirmationText(chatId)
    val requestJson = tdJson.encodeToString(GetMessageImportConfirmationText.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Imports messages exported from another application
 * @param chatId Identifier of a chat to which the messages will be imported. It must be an identifier of a private chat with a mutual contact or an identifier of a supergroup chat with can_change_info member right
 * @param messageFile File with messages to import. Only inputFileLocal and inputFileGenerated are supported. The file must not be previously uploaded
 * @param attachedFiles Files used in the imported messages. Only inputFileLocal and inputFileGenerated are supported. The files must not be previously uploaded
 */
suspend fun TdKtxClient.importMessages(
    chatId: Long,
    messageFile: InputFile? = null,
    attachedFiles: List<InputFile>? = null,
): Ok {
    val request = ImportMessages(chatId, messageFile, attachedFiles)
    val requestJson = tdJson.encodeToString(ImportMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Replaces current primary invite link for a chat with a new primary invite link. Available for basic groups, supergroups, and channels. Requires administrator privileges and can_invite_users right @chat_id Chat identifier
 */
suspend fun TdKtxClient.replacePrimaryChatInviteLink(
    chatId: Long,
): ChatInviteLink {
    val request = ReplacePrimaryChatInviteLink(chatId)
    val requestJson = tdJson.encodeToString(ReplacePrimaryChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Creates a new invite link for a chat. Available for basic groups, supergroups, and channels. Requires administrator privileges and can_invite_users right in the chat
 * @param chatId Chat identifier
 * @param name Invite link name; 0-32 characters
 * @param expirationDate Point in time (Unix timestamp) when the link will expire; pass 0 if never
 * @param memberLimit The maximum number of chat members that can join the chat via the link simultaneously; 0-99999; pass 0 if not limited
 * @param createsJoinRequest Pass true if users joining the chat via the link need to be approved by chat administrators. In this case, member_limit must be 0
 */
suspend fun TdKtxClient.createChatInviteLink(
    chatId: Long,
    name: String? = null,
    expirationDate: Int,
    memberLimit: Int,
    createsJoinRequest: Boolean,
): ChatInviteLink {
    val request = CreateChatInviteLink(chatId, name, expirationDate, memberLimit, createsJoinRequest)
    val requestJson = tdJson.encodeToString(CreateChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Creates a new subscription invite link for a channel chat. Requires can_invite_users right in the chat
 * @param chatId Chat identifier
 * @param name Invite link name; 0-32 characters
 * @param subscriptionPricing Information about subscription plan that will be applied to the users joining the chat via the link. Subscription period must be 2592000 in production environment, and 60 or 300 if Telegram test environment is used
 */
suspend fun TdKtxClient.createChatSubscriptionInviteLink(
    chatId: Long,
    name: String? = null,
    subscriptionPricing: StarSubscriptionPricing? = null,
): ChatInviteLink {
    val request = CreateChatSubscriptionInviteLink(chatId, name, subscriptionPricing)
    val requestJson = tdJson.encodeToString(CreateChatSubscriptionInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Edits a non-primary invite link for a chat. Available for basic groups, supergroups, and channels. If the link creates a subscription, then expiration_date, member_limit and creates_join_request must not be used. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links
 * @param chatId Chat identifier
 * @param inviteLink Invite link to be edited
 * @param name Invite link name; 0-32 characters
 * @param expirationDate Point in time (Unix timestamp) when the link will expire; pass 0 if never
 * @param memberLimit The maximum number of chat members that can join the chat via the link simultaneously; 0-99999; pass 0 if not limited
 * @param createsJoinRequest Pass true if users joining the chat via the link need to be approved by chat administrators. In this case, member_limit must be 0
 */
suspend fun TdKtxClient.editChatInviteLink(
    chatId: Long,
    inviteLink: String? = null,
    name: String? = null,
    expirationDate: Int,
    memberLimit: Int,
    createsJoinRequest: Boolean,
): ChatInviteLink {
    val request = EditChatInviteLink(chatId, inviteLink, name, expirationDate, memberLimit, createsJoinRequest)
    val requestJson = tdJson.encodeToString(EditChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Edits a subscription invite link for a channel chat. Requires can_invite_users right in the chat for own links and owner privileges for other links
 * @param chatId Chat identifier
 * @param inviteLink Invite link to be edited
 * @param name Invite link name; 0-32 characters
 */
suspend fun TdKtxClient.editChatSubscriptionInviteLink(
    chatId: Long,
    inviteLink: String? = null,
    name: String? = null,
): ChatInviteLink {
    val request = EditChatSubscriptionInviteLink(chatId, inviteLink, name)
    val requestJson = tdJson.encodeToString(EditChatSubscriptionInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Returns information about an invite link. Requires administrator privileges and can_invite_users right in the chat to get own links and owner privileges to get other links
 * @param chatId Chat identifier
 * @param inviteLink Invite link to get
 */
suspend fun TdKtxClient.getChatInviteLink(
    chatId: Long,
    inviteLink: String? = null,
): ChatInviteLink {
    val request = GetChatInviteLink(chatId, inviteLink)
    val requestJson = tdJson.encodeToString(GetChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLink.serializer(), responseJson)
}

/**
 * Returns the list of chat administrators with number of their invite links. Requires owner privileges in the chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.getChatInviteLinkCounts(
    chatId: Long,
): ChatInviteLinkCounts {
    val request = GetChatInviteLinkCounts(chatId)
    val requestJson = tdJson.encodeToString(GetChatInviteLinkCounts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLinkCounts.serializer(), responseJson)
}

/**
 * Returns invite links for a chat created by specified administrator. Requires administrator privileges and can_invite_users right in the chat to get own links and owner privileges to get other links
 * @param chatId Chat identifier
 * @param creatorUserId User identifier of a chat administrator. Must be an identifier of the current user for non-owner
 * @param isRevoked Pass true if revoked links need to be returned instead of active or expired
 * @param offsetDate Creation date of an invite link starting after which to return invite links; use 0 to get results from the beginning
 * @param offsetInviteLink Invite link starting after which to return invite links; use empty string to get results from the beginning
 * @param limit The maximum number of invite links to return; up to 100
 */
suspend fun TdKtxClient.getChatInviteLinks(
    chatId: Long,
    creatorUserId: Long,
    isRevoked: Boolean,
    offsetDate: Int,
    offsetInviteLink: String? = null,
    limit: Int,
): ChatInviteLinks {
    val request = GetChatInviteLinks(chatId, creatorUserId, isRevoked, offsetDate, offsetInviteLink, limit)
    val requestJson = tdJson.encodeToString(GetChatInviteLinks.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLinks.serializer(), responseJson)
}

/**
 * Returns chat members joined a chat via an invite link. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links
 * @param chatId Chat identifier
 * @param inviteLink Invite link for which to return chat members
 * @param onlyWithExpiredSubscription Pass true if the link is a subscription link and only members with expired subscription must be returned
 * @param offsetMember A chat member from which to return next chat members; pass null to get results from the beginning
 * @param limit The maximum number of chat members to return; up to 100
 */
suspend fun TdKtxClient.getChatInviteLinkMembers(
    chatId: Long,
    inviteLink: String? = null,
    onlyWithExpiredSubscription: Boolean,
    offsetMember: ChatInviteLinkMember? = null,
    limit: Int,
): ChatInviteLinkMembers {
    val request = GetChatInviteLinkMembers(chatId, inviteLink, onlyWithExpiredSubscription, offsetMember, limit)
    val requestJson = tdJson.encodeToString(GetChatInviteLinkMembers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLinkMembers.serializer(), responseJson)
}

/**
 * Revokes invite link for a chat. Available for basic groups, supergroups, and channels. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links. If a primary link is revoked, then additionally to the revoked link returns new primary link
 * @param chatId Chat identifier
 * @param inviteLink Invite link to be revoked
 */
suspend fun TdKtxClient.revokeChatInviteLink(
    chatId: Long,
    inviteLink: String? = null,
): ChatInviteLinks {
    val request = RevokeChatInviteLink(chatId, inviteLink)
    val requestJson = tdJson.encodeToString(RevokeChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLinks.serializer(), responseJson)
}

/**
 * Deletes revoked chat invite links. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links @chat_id Chat identifier @invite_link Invite link to revoke
 */
suspend fun TdKtxClient.deleteRevokedChatInviteLink(
    chatId: Long,
    inviteLink: String? = null,
): Ok {
    val request = DeleteRevokedChatInviteLink(chatId, inviteLink)
    val requestJson = tdJson.encodeToString(DeleteRevokedChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all revoked chat invite links created by a given chat administrator. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links
 * @param chatId Chat identifier
 * @param creatorUserId User identifier of a chat administrator, which links will be deleted. Must be an identifier of the current user for non-owner
 */
suspend fun TdKtxClient.deleteAllRevokedChatInviteLinks(
    chatId: Long,
    creatorUserId: Long,
): Ok {
    val request = DeleteAllRevokedChatInviteLinks(chatId, creatorUserId)
    val requestJson = tdJson.encodeToString(DeleteAllRevokedChatInviteLinks.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks the validity of an invite link for a chat and returns information about the corresponding chat @invite_link Invite link to be checked
 */
suspend fun TdKtxClient.checkChatInviteLink(
    inviteLink: String? = null,
): ChatInviteLinkInfo {
    val request = CheckChatInviteLink(inviteLink)
    val requestJson = tdJson.encodeToString(CheckChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatInviteLinkInfo.serializer(), responseJson)
}

/**
 * Uses an invite link to add the current user to the chat if possible @invite_link Invite link to use
 */
suspend fun TdKtxClient.joinChatByInviteLink(
    inviteLink: String? = null,
): ChatJoinResult {
    val request = JoinChatByInviteLink(inviteLink)
    val requestJson = tdJson.encodeToString(JoinChatByInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatJoinResult.serializer(), responseJson)
}

/**
 * Returns pending join requests in a chat
 * @param chatId Chat identifier
 * @param inviteLink Invite link for which to return join requests. If empty, all join requests will be returned. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links
 * @param query A query to search for in the first names, last names and usernames of the users to return
 * @param offsetRequest A chat join request from which to return next requests; pass null to get results from the beginning
 * @param limit The maximum number of requests to join the chat to return
 */
suspend fun TdKtxClient.getChatJoinRequests(
    chatId: Long,
    inviteLink: String? = null,
    query: String? = null,
    offsetRequest: ChatJoinRequest? = null,
    limit: Int,
): ChatJoinRequests {
    val request = GetChatJoinRequests(chatId, inviteLink, query, offsetRequest, limit)
    val requestJson = tdJson.encodeToString(GetChatJoinRequests.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatJoinRequests.serializer(), responseJson)
}

/**
 * Handles a pending join request in a chat @chat_id Chat identifier @user_id Identifier of the user who sent the request @approve Pass true to approve the request; pass false to decline it
 */
suspend fun TdKtxClient.processChatJoinRequest(
    chatId: Long,
    userId: Long,
    approve: Boolean,
): Ok {
    val request = ProcessChatJoinRequest(chatId, userId, approve)
    val requestJson = tdJson.encodeToString(ProcessChatJoinRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Handles all pending join requests for a given link in a chat
 * @param chatId Chat identifier
 * @param inviteLink Invite link for which to process join requests. If empty, all join requests will be processed. Requires administrator privileges and can_invite_users right in the chat for own links and owner privileges for other links
 * @param approve Pass true to approve all requests; pass false to decline them
 */
suspend fun TdKtxClient.processChatJoinRequests(
    chatId: Long,
    inviteLink: String? = null,
    approve: Boolean,
): Ok {
    val request = ProcessChatJoinRequests(chatId, inviteLink, approve)
    val requestJson = tdJson.encodeToString(ProcessChatJoinRequests.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Approves a suggested post in a channel direct messages chat
 * @param chatId Chat identifier of the channel direct messages chat
 * @param messageId Identifier of the message with the suggested post. Use messageProperties.can_be_approved to check whether the suggested post can be approved
 * @param sendDate Point in time (Unix timestamp) when the post is expected to be published; pass 0 if the date has already been chosen. If specified, then the date must be in the future, but at most getOption("suggested_post_send_delay_max") seconds in the future
 */
suspend fun TdKtxClient.approveSuggestedPost(
    chatId: Long,
    messageId: Long,
    sendDate: Int,
): Ok {
    val request = ApproveSuggestedPost(chatId, messageId, sendDate)
    val requestJson = tdJson.encodeToString(ApproveSuggestedPost.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Declines a suggested post in a channel direct messages chat
 * @param chatId Chat identifier of the channel direct messages chat
 * @param messageId Identifier of the message with the suggested post. Use messageProperties.can_be_declined to check whether the suggested post can be declined
 * @param comment Comment for the creator of the suggested post; 0-128 characters
 */
suspend fun TdKtxClient.declineSuggestedPost(
    chatId: Long,
    messageId: Long,
    comment: String? = null,
): Ok {
    val request = DeclineSuggestedPost(chatId, messageId, comment)
    val requestJson = tdJson.encodeToString(DeclineSuggestedPost.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a suggested post based on a previously sent message in a channel direct messages chat. Can be also used to suggest price or time change for an existing suggested post. Returns the sent message
 * @param chatId Identifier of the channel direct messages chat
 * @param messageId Identifier of the message in the chat which will be sent as suggested post. Use messageProperties.can_add_offer to check whether an offer can be added or messageProperties.can_edit_suggested_post_info to check whether price or time of sending of the post can be changed
 * @param options Options to be used to send the message. New information about the suggested post must always be specified
 */
suspend fun TdKtxClient.addOffer(
    chatId: Long,
    messageId: Long,
    options: MessageSendOptions? = null,
): Message {
    val request = AddOffer(chatId, messageId, options)
    val requestJson = tdJson.encodeToString(AddOffer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Message.serializer(), responseJson)
}

/**
 * Creates a new call
 * @param userId Identifier of the user to be called
 * @param protocol The call protocols supported by the application
 * @param isVideo Pass true to create a video call
 */
suspend fun TdKtxClient.createCall(
    userId: Long,
    protocol: CallProtocol? = null,
    isVideo: Boolean,
): CallId {
    val request = CreateCall(userId, protocol, isVideo)
    val requestJson = tdJson.encodeToString(CreateCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CallId.serializer(), responseJson)
}

/**
 * Accepts an incoming call @call_id Call identifier @protocol The call protocols supported by the application
 */
suspend fun TdKtxClient.acceptCall(
    callId: Int,
    protocol: CallProtocol? = null,
): Ok {
    val request = AcceptCall(callId, protocol)
    val requestJson = tdJson.encodeToString(AcceptCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends call signaling data @call_id Call identifier @data The data
 */
suspend fun TdKtxClient.sendCallSignalingData(
    callId: Int,
    data: String? = null,
): Ok {
    val request = SendCallSignalingData(callId, data)
    val requestJson = tdJson.encodeToString(SendCallSignalingData.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Discards a call
 * @param callId Call identifier
 * @param isDisconnected Pass true if the user was disconnected
 * @param inviteLink If the call was upgraded to a group call, pass invite link to the group call
 * @param duration The call duration, in seconds
 * @param isVideo Pass true if the call was a video call
 * @param connectionId Identifier of the connection used during the call
 */
suspend fun TdKtxClient.discardCall(
    callId: Int,
    isDisconnected: Boolean,
    inviteLink: String? = null,
    duration: Int,
    isVideo: Boolean,
    connectionId: Long,
): Ok {
    val request = DiscardCall(callId, isDisconnected, inviteLink, duration, isVideo, connectionId)
    val requestJson = tdJson.encodeToString(DiscardCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a call rating
 * @param callId Call identifier
 * @param rating Call rating; 1-5
 * @param comment An optional user comment if the rating is less than 5
 * @param problems List of the exact types of problems with the call, specified by the user
 */
suspend fun TdKtxClient.sendCallRating(
    callId: InputCall? = null,
    rating: Int,
    comment: String? = null,
    problems: List<CallProblem>? = null,
): Ok {
    val request = SendCallRating(callId, rating, comment, problems)
    val requestJson = tdJson.encodeToString(SendCallRating.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends debug information for a call to Telegram servers @call_id Call identifier @debug_information Debug information in application-specific format
 */
suspend fun TdKtxClient.sendCallDebugInformation(
    callId: InputCall? = null,
    debugInformation: String? = null,
): Ok {
    val request = SendCallDebugInformation(callId, debugInformation)
    val requestJson = tdJson.encodeToString(SendCallDebugInformation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends log file for a call to Telegram servers @call_id Call identifier @log_file Call log file. Only inputFileLocal and inputFileGenerated are supported
 */
suspend fun TdKtxClient.sendCallLog(
    callId: InputCall? = null,
    logFile: InputFile? = null,
): Ok {
    val request = SendCallLog(callId, logFile)
    val requestJson = tdJson.encodeToString(SendCallLog.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of participant identifiers, on whose behalf a video chat in the chat can be joined @chat_id Chat identifier
 */
suspend fun TdKtxClient.getVideoChatAvailableParticipants(
    chatId: Long,
): MessageSenders {
    val request = GetVideoChatAvailableParticipants(chatId)
    val requestJson = tdJson.encodeToString(GetVideoChatAvailableParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageSenders.serializer(), responseJson)
}

/**
 * Changes default participant identifier, on whose behalf a video chat in the chat will be joined
 * @param chatId Chat identifier
 * @param defaultParticipantId Default group call participant identifier to join the video chats in the chat
 */
suspend fun TdKtxClient.setVideoChatDefaultParticipant(
    chatId: Long,
    defaultParticipantId: MessageSender? = null,
): Ok {
    val request = SetVideoChatDefaultParticipant(chatId, defaultParticipantId)
    val requestJson = tdJson.encodeToString(SetVideoChatDefaultParticipant.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Creates a video chat (a group call bound to a chat); for basic groups, supergroups and channels only; requires can_manage_video_chats administrator right
 * @param chatId Identifier of a chat in which the video chat will be created
 * @param title Group call title; if empty, chat title will be used
 * @param startDate Point in time (Unix timestamp) when the group call is expected to be started by an administrator; 0 to start the video chat immediately. The date must be at least 10 seconds and at most 8 days in the future
 * @param isRtmpStream Pass true to create an RTMP stream instead of an ordinary video chat
 */
suspend fun TdKtxClient.createVideoChat(
    chatId: Long,
    title: String? = null,
    startDate: Int,
    isRtmpStream: Boolean,
): GroupCallId {
    val request = CreateVideoChat(chatId, title, startDate, isRtmpStream)
    val requestJson = tdJson.encodeToString(CreateVideoChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallId.serializer(), responseJson)
}

/**
 * Creates a new group call that isn't bound to a chat @join_parameters Parameters to join the call; pass null to only create call link without joining the call
 */
suspend fun TdKtxClient.createGroupCall(
    joinParameters: GroupCallJoinParameters? = null,
): GroupCallInfo {
    val request = CreateGroupCall(joinParameters)
    val requestJson = tdJson.encodeToString(CreateGroupCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallInfo.serializer(), responseJson)
}

/**
 * Returns RTMP URL for streaming to the video chat of a chat; requires can_manage_video_chats administrator right @chat_id Chat identifier
 */
suspend fun TdKtxClient.getVideoChatRtmpUrl(
    chatId: Long,
): RtmpUrl {
    val request = GetVideoChatRtmpUrl(chatId)
    val requestJson = tdJson.encodeToString(GetVideoChatRtmpUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RtmpUrl.serializer(), responseJson)
}

/**
 * Replaces the current RTMP URL for streaming to the video chat of a chat; requires owner privileges in the chat @chat_id Chat identifier
 */
suspend fun TdKtxClient.replaceVideoChatRtmpUrl(
    chatId: Long,
): RtmpUrl {
    val request = ReplaceVideoChatRtmpUrl(chatId)
    val requestJson = tdJson.encodeToString(ReplaceVideoChatRtmpUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RtmpUrl.serializer(), responseJson)
}

/**
 * Returns RTMP URL for streaming to a live story; requires can_post_stories administrator right for channel chats @chat_id Chat identifier
 */
suspend fun TdKtxClient.getLiveStoryRtmpUrl(
    chatId: Long,
): RtmpUrl {
    val request = GetLiveStoryRtmpUrl(chatId)
    val requestJson = tdJson.encodeToString(GetLiveStoryRtmpUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RtmpUrl.serializer(), responseJson)
}

/**
 * Replaces the current RTMP URL for streaming to a live story; requires owner privileges for channel chats @chat_id Chat identifier
 */
suspend fun TdKtxClient.replaceLiveStoryRtmpUrl(
    chatId: Long,
): RtmpUrl {
    val request = ReplaceLiveStoryRtmpUrl(chatId)
    val requestJson = tdJson.encodeToString(ReplaceLiveStoryRtmpUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(RtmpUrl.serializer(), responseJson)
}

/**
 * Returns information about a group call @group_call_id Group call identifier
 */
suspend fun TdKtxClient.getGroupCall(
    groupCallId: Int,
): GroupCall {
    val request = GetGroupCall(groupCallId)
    val requestJson = tdJson.encodeToString(GetGroupCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCall.serializer(), responseJson)
}

/**
 * Starts a scheduled video chat @group_call_id Group call identifier of the video chat
 */
suspend fun TdKtxClient.startScheduledVideoChat(
    groupCallId: Int,
): Ok {
    val request = StartScheduledVideoChat(groupCallId)
    val requestJson = tdJson.encodeToString(StartScheduledVideoChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether the current user will receive a notification when the video chat starts; for scheduled video chats only
 * @param groupCallId Group call identifier
 * @param enabledStartNotification New value of the enabled_start_notification setting
 */
suspend fun TdKtxClient.toggleVideoChatEnabledStartNotification(
    groupCallId: Int,
    enabledStartNotification: Boolean,
): Ok {
    val request = ToggleVideoChatEnabledStartNotification(groupCallId, enabledStartNotification)
    val requestJson = tdJson.encodeToString(ToggleVideoChatEnabledStartNotification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Joins a regular group call that is not bound to a chat @input_group_call The group call to join @join_parameters Parameters to join the call
 */
suspend fun TdKtxClient.joinGroupCall(
    inputGroupCall: InputGroupCall? = null,
    joinParameters: GroupCallJoinParameters? = null,
): GroupCallInfo {
    val request = JoinGroupCall(inputGroupCall, joinParameters)
    val requestJson = tdJson.encodeToString(JoinGroupCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallInfo.serializer(), responseJson)
}

/**
 * Joins an active video chat. Returns join response payload for tgcalls
 * @param groupCallId Group call identifier
 * @param participantId Identifier of a group call participant, which will be used to join the call; pass null to join as self
 * @param joinParameters Parameters to join the call
 * @param inviteHash Invite hash as received from internalLinkTypeVideoChat
 */
suspend fun TdKtxClient.joinVideoChat(
    groupCallId: Int,
    participantId: MessageSender? = null,
    joinParameters: GroupCallJoinParameters? = null,
    inviteHash: String? = null,
): Text {
    val request = JoinVideoChat(groupCallId, participantId, joinParameters, inviteHash)
    val requestJson = tdJson.encodeToString(JoinVideoChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Joins a group call of an active live story. Returns join response payload for tgcalls
 * @param groupCallId Group call identifier
 * @param joinParameters Parameters to join the call
 */
suspend fun TdKtxClient.joinLiveStory(
    groupCallId: Int,
    joinParameters: GroupCallJoinParameters? = null,
): Text {
    val request = JoinLiveStory(groupCallId, joinParameters)
    val requestJson = tdJson.encodeToString(JoinLiveStory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Starts screen sharing in a joined group call; not supported in live stories. Returns join response payload for tgcalls
 * @param groupCallId Group call identifier
 * @param audioSourceId Screen sharing audio channel synchronization source identifier; received from tgcalls
 * @param payload Group call join payload; received from tgcalls
 */
suspend fun TdKtxClient.startGroupCallScreenSharing(
    groupCallId: Int,
    audioSourceId: Int,
    payload: String? = null,
): Text {
    val request = StartGroupCallScreenSharing(groupCallId, audioSourceId, payload)
    val requestJson = tdJson.encodeToString(StartGroupCallScreenSharing.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Pauses or unpauses screen sharing in a joined group call; not supported in live stories @group_call_id Group call identifier @is_paused Pass true to pause screen sharing; pass false to unpause it
 */
suspend fun TdKtxClient.toggleGroupCallScreenSharingIsPaused(
    groupCallId: Int,
    isPaused: Boolean,
): Ok {
    val request = ToggleGroupCallScreenSharingIsPaused(groupCallId, isPaused)
    val requestJson = tdJson.encodeToString(ToggleGroupCallScreenSharingIsPaused.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Ends screen sharing in a joined group call; not supported in live stories @group_call_id Group call identifier
 */
suspend fun TdKtxClient.endGroupCallScreenSharing(
    groupCallId: Int,
): Ok {
    val request = EndGroupCallScreenSharing(groupCallId)
    val requestJson = tdJson.encodeToString(EndGroupCallScreenSharing.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets title of a video chat; requires groupCall.can_be_managed right @group_call_id Group call identifier @title New group call title; 1-64 characters
 */
suspend fun TdKtxClient.setVideoChatTitle(
    groupCallId: Int,
    title: String? = null,
): Ok {
    val request = SetVideoChatTitle(groupCallId, title)
    val requestJson = tdJson.encodeToString(SetVideoChatTitle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether new participants of a video chat can be unmuted only by administrators of the video chat. Requires groupCall.can_toggle_mute_new_participants right
 * @param groupCallId Group call identifier
 * @param muteNewParticipants New value of the mute_new_participants setting
 */
suspend fun TdKtxClient.toggleVideoChatMuteNewParticipants(
    groupCallId: Int,
    muteNewParticipants: Boolean,
): Ok {
    val request = ToggleVideoChatMuteNewParticipants(groupCallId, muteNewParticipants)
    val requestJson = tdJson.encodeToString(ToggleVideoChatMuteNewParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether participants of a group call can send messages there. Requires groupCall.can_toggle_are_messages_allowed right
 * @param groupCallId Group call identifier
 * @param areMessagesAllowed New value of the are_messages_allowed setting
 */
suspend fun TdKtxClient.toggleGroupCallAreMessagesAllowed(
    groupCallId: Int,
    areMessagesAllowed: Boolean,
): Ok {
    val request = ToggleGroupCallAreMessagesAllowed(groupCallId, areMessagesAllowed)
    val requestJson = tdJson.encodeToString(ToggleGroupCallAreMessagesAllowed.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about the user or the chat that streams to a live story; for live stories that aren't an RTMP stream only @group_call_id Group call identifier
 */
suspend fun TdKtxClient.getLiveStoryStreamer(
    groupCallId: Int,
): GroupCallParticipant {
    val request = GetLiveStoryStreamer(groupCallId)
    val requestJson = tdJson.encodeToString(GetLiveStoryStreamer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallParticipant.serializer(), responseJson)
}

/**
 * Returns the list of message sender identifiers, on whose behalf messages can be sent to a live story @group_call_id Group call identifier
 */
suspend fun TdKtxClient.getLiveStoryAvailableMessageSenders(
    groupCallId: Int,
): ChatMessageSenders {
    val request = GetLiveStoryAvailableMessageSenders(groupCallId)
    val requestJson = tdJson.encodeToString(GetLiveStoryAvailableMessageSenders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatMessageSenders.serializer(), responseJson)
}

/**
 * Selects a message sender to send messages in a live story call
 * @param groupCallId Group call identifier
 * @param messageSenderId New message sender for the group call
 */
suspend fun TdKtxClient.setLiveStoryMessageSender(
    groupCallId: Int,
    messageSenderId: MessageSender? = null,
): Ok {
    val request = SetLiveStoryMessageSender(groupCallId, messageSenderId)
    val requestJson = tdJson.encodeToString(SetLiveStoryMessageSender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a message to other participants of a group call. Requires groupCall.can_send_messages right
 * @param groupCallId Group call identifier
 * @param text Text of the message to send; 1-getOption("group_call_message_text_length_max") characters for non-live-stories; see updateGroupCallMessageLevels for live story restrictions, which depends on paid_message_star_count. Can't contain line feeds for live stories. Can contain only Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, and DateTime entities for live stories
 * @param paidMessageStarCount The number of Telegram Stars the user agreed to pay to send the message; for live stories only; 0-getOption("paid_group_call_message_star_count_max"). Must be 0 for messages sent to live stories posted by the current user
 */
suspend fun TdKtxClient.sendGroupCallMessage(
    groupCallId: Int,
    text: FormattedText? = null,
    paidMessageStarCount: Long,
): Ok {
    val request = SendGroupCallMessage(groupCallId, text, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(SendGroupCallMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds pending paid reaction in a live story group call. Can't be used in live stories posted by the current user. Call commitPendingLiveStoryReactions or removePendingLiveStoryReactions to actually send all pending reactions when the undo timer is over or abort the sending
 * @param groupCallId Group call identifier
 * @param starCount Number of Telegram Stars to be used for the reaction. The total number of pending paid reactions must not exceed getOption("paid_group_call_message_star_count_max")
 */
suspend fun TdKtxClient.addPendingLiveStoryReaction(
    groupCallId: Int,
    starCount: Long,
): Ok {
    val request = AddPendingLiveStoryReaction(groupCallId, starCount)
    val requestJson = tdJson.encodeToString(AddPendingLiveStoryReaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Applies all pending paid reactions in a live story group call @group_call_id Group call identifier
 */
suspend fun TdKtxClient.commitPendingLiveStoryReactions(
    groupCallId: Int,
): Ok {
    val request = CommitPendingLiveStoryReactions(groupCallId)
    val requestJson = tdJson.encodeToString(CommitPendingLiveStoryReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes all pending paid reactions in a live story group call @group_call_id Group call identifier
 */
suspend fun TdKtxClient.removePendingLiveStoryReactions(
    groupCallId: Int,
): Ok {
    val request = RemovePendingLiveStoryReactions(groupCallId)
    val requestJson = tdJson.encodeToString(RemovePendingLiveStoryReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes messages in a group call; for live story calls only. Requires groupCallMessage.can_be_deleted right
 * @param groupCallId Group call identifier
 * @param messageIds Identifiers of the messages to be deleted
 * @param reportSpam Pass true to report the messages as spam
 */
suspend fun TdKtxClient.deleteGroupCallMessages(
    groupCallId: Int,
    messageIds: List<Int>? = null,
    reportSpam: Boolean,
): Ok {
    val request = DeleteGroupCallMessages(groupCallId, messageIds, reportSpam)
    val requestJson = tdJson.encodeToString(DeleteGroupCallMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all messages sent by the specified message sender in a group call; for live story calls only. Requires groupCall.can_delete_messages right
 * @param groupCallId Group call identifier
 * @param senderId Identifier of the sender of messages to delete
 * @param reportSpam Pass true to report the messages as spam
 */
suspend fun TdKtxClient.deleteGroupCallMessagesBySender(
    groupCallId: Int,
    senderId: MessageSender? = null,
    reportSpam: Boolean,
): Ok {
    val request = DeleteGroupCallMessagesBySender(groupCallId, senderId, reportSpam)
    val requestJson = tdJson.encodeToString(DeleteGroupCallMessagesBySender.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of top live story donors @group_call_id Group call identifier of the live story
 */
suspend fun TdKtxClient.getLiveStoryTopDonors(
    groupCallId: Int,
): LiveStoryDonors {
    val request = GetLiveStoryTopDonors(groupCallId)
    val requestJson = tdJson.encodeToString(GetLiveStoryTopDonors.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LiveStoryDonors.serializer(), responseJson)
}

/**
 * Invites a user to an active group call; for group calls not bound to a chat only. Sends a service message of the type messageGroupCall. The group call can have at most getOption("group_call_participant_count_max") participants
 * @param groupCallId Group call identifier
 * @param userId User identifier
 * @param isVideo Pass true if the group call is a video call
 */
suspend fun TdKtxClient.inviteGroupCallParticipant(
    groupCallId: Int,
    userId: Long,
    isVideo: Boolean,
): InviteGroupCallParticipantResult {
    val request = InviteGroupCallParticipant(groupCallId, userId, isVideo)
    val requestJson = tdJson.encodeToString(InviteGroupCallParticipant.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(InviteGroupCallParticipantResult.serializer(), responseJson)
}

/**
 * Declines an invitation to an active group call via messageGroupCall. Can be called both by the sender and the receiver of the invitation
 * @param chatId Identifier of the chat with the message
 * @param messageId Identifier of the message of the type messageGroupCall
 */
suspend fun TdKtxClient.declineGroupCallInvitation(
    chatId: Long,
    messageId: Long,
): Ok {
    val request = DeclineGroupCallInvitation(chatId, messageId)
    val requestJson = tdJson.encodeToString(DeclineGroupCallInvitation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Bans users from a group call not bound to a chat; requires groupCall.is_owned. Only the owner of the group call can invite the banned users back
 * @param groupCallId Group call identifier
 * @param userIds Identifiers of group call participants to ban; identifiers of unknown users from the update updateGroupCallParticipants can be also passed to the method
 */
suspend fun TdKtxClient.banGroupCallParticipants(
    groupCallId: Int,
    userIds: List<Long>? = null,
): Ok {
    val request = BanGroupCallParticipants(groupCallId, userIds)
    val requestJson = tdJson.encodeToString(BanGroupCallParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Invites users to an active video chat. Sends a service message of the type messageInviteVideoChatParticipants to the chat bound to the group call
 * @param groupCallId Group call identifier
 * @param userIds User identifiers. At most 10 users can be invited simultaneously
 */
suspend fun TdKtxClient.inviteVideoChatParticipants(
    groupCallId: Int,
    userIds: List<Long>? = null,
): Ok {
    val request = InviteVideoChatParticipants(groupCallId, userIds)
    val requestJson = tdJson.encodeToString(InviteVideoChatParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns invite link to a video chat in a public chat
 * @param groupCallId Group call identifier
 * @param canSelfUnmute Pass true if the invite link needs to contain an invite hash, passing which to joinVideoChat would allow the invited user to unmute themselves. Requires groupCall.can_be_managed right
 */
suspend fun TdKtxClient.getVideoChatInviteLink(
    groupCallId: Int,
    canSelfUnmute: Boolean,
): HttpUrl {
    val request = GetVideoChatInviteLink(groupCallId, canSelfUnmute)
    val requestJson = tdJson.encodeToString(GetVideoChatInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Revokes invite link for a group call. Requires groupCall.can_be_managed right for video chats or groupCall.is_owned otherwise @group_call_id Group call identifier
 */
suspend fun TdKtxClient.revokeGroupCallInviteLink(
    groupCallId: Int,
): Ok {
    val request = RevokeGroupCallInviteLink(groupCallId)
    val requestJson = tdJson.encodeToString(RevokeGroupCallInviteLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Starts recording of an active group call; for video chats only. Requires groupCall.can_be_managed right
 * @param groupCallId Group call identifier
 * @param title Group call recording title; 0-64 characters
 * @param recordVideo Pass true to record a video file instead of an audio file
 * @param usePortraitOrientation Pass true to use portrait orientation for video instead of landscape one
 */
suspend fun TdKtxClient.startGroupCallRecording(
    groupCallId: Int,
    title: String? = null,
    recordVideo: Boolean,
    usePortraitOrientation: Boolean,
): Ok {
    val request = StartGroupCallRecording(groupCallId, title, recordVideo, usePortraitOrientation)
    val requestJson = tdJson.encodeToString(StartGroupCallRecording.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Ends recording of an active group call; for video chats only. Requires groupCall.can_be_managed right @group_call_id Group call identifier
 */
suspend fun TdKtxClient.endGroupCallRecording(
    groupCallId: Int,
): Ok {
    val request = EndGroupCallRecording(groupCallId)
    val requestJson = tdJson.encodeToString(EndGroupCallRecording.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether current user's video is paused @group_call_id Group call identifier @is_my_video_paused Pass true if the current user's video is paused
 */
suspend fun TdKtxClient.toggleGroupCallIsMyVideoPaused(
    groupCallId: Int,
    isMyVideoPaused: Boolean,
): Ok {
    val request = ToggleGroupCallIsMyVideoPaused(groupCallId, isMyVideoPaused)
    val requestJson = tdJson.encodeToString(ToggleGroupCallIsMyVideoPaused.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether current user's video is enabled @group_call_id Group call identifier @is_my_video_enabled Pass true if the current user's video is enabled
 */
suspend fun TdKtxClient.toggleGroupCallIsMyVideoEnabled(
    groupCallId: Int,
    isMyVideoEnabled: Boolean,
): Ok {
    val request = ToggleGroupCallIsMyVideoEnabled(groupCallId, isMyVideoEnabled)
    val requestJson = tdJson.encodeToString(ToggleGroupCallIsMyVideoEnabled.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the minimum number of Telegram Stars that must be paid by general participant for each sent message to a live story call. Requires groupCall.can_be_managed right
 * @param groupCallId Group call identifier; must be an identifier of a live story call
 * @param paidMessageStarCount The new minimum number of Telegram Stars; 0-getOption("paid_group_call_message_star_count_max")
 */
suspend fun TdKtxClient.setGroupCallPaidMessageStarCount(
    groupCallId: Int,
    paidMessageStarCount: Long,
): Ok {
    val request = SetGroupCallPaidMessageStarCount(groupCallId, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(SetGroupCallPaidMessageStarCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that speaking state of a participant of an active group call has changed. Returns identifier of the participant if it is found
 * @param groupCallId Group call identifier
 * @param audioSource Group call participant's synchronization audio source identifier, or 0 for the current user
 * @param isSpeaking Pass true if the user is speaking
 */
suspend fun TdKtxClient.setGroupCallParticipantIsSpeaking(
    groupCallId: Int,
    audioSource: Int,
    isSpeaking: Boolean,
): MessageSender {
    val request = SetGroupCallParticipantIsSpeaking(groupCallId, audioSource, isSpeaking)
    val requestJson = tdJson.encodeToString(SetGroupCallParticipantIsSpeaking.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageSender.serializer(), responseJson)
}

/**
 * Toggles whether a participant of an active group call is muted, unmuted, or allowed to unmute themselves; not supported for live stories
 * @param groupCallId Group call identifier
 * @param participantId Participant identifier
 * @param isMuted Pass true to mute the user; pass false to unmute them
 */
suspend fun TdKtxClient.toggleGroupCallParticipantIsMuted(
    groupCallId: Int,
    participantId: MessageSender? = null,
    isMuted: Boolean,
): Ok {
    val request = ToggleGroupCallParticipantIsMuted(groupCallId, participantId, isMuted)
    val requestJson = tdJson.encodeToString(ToggleGroupCallParticipantIsMuted.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes volume level of a participant of an active group call; not supported for live stories. If the current user can manage the group call or is the owner of the group call, then the participant's volume level will be changed for all users with the default volume level
 * @param groupCallId Group call identifier
 * @param participantId Participant identifier
 * @param volumeLevel New participant's volume level; 1-20000 in hundreds of percents
 */
suspend fun TdKtxClient.setGroupCallParticipantVolumeLevel(
    groupCallId: Int,
    participantId: MessageSender? = null,
    volumeLevel: Int,
): Ok {
    val request = SetGroupCallParticipantVolumeLevel(groupCallId, participantId, volumeLevel)
    val requestJson = tdJson.encodeToString(SetGroupCallParticipantVolumeLevel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a group call participant hand is rased; for video chats only
 * @param groupCallId Group call identifier
 * @param participantId Participant identifier
 * @param isHandRaised Pass true if the user's hand needs to be raised. Only self hand can be raised. Requires groupCall.can_be_managed right to lower other's hand
 */
suspend fun TdKtxClient.toggleGroupCallParticipantIsHandRaised(
    groupCallId: Int,
    participantId: MessageSender? = null,
    isHandRaised: Boolean,
): Ok {
    val request = ToggleGroupCallParticipantIsHandRaised(groupCallId, participantId, isHandRaised)
    val requestJson = tdJson.encodeToString(ToggleGroupCallParticipantIsHandRaised.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about participants of a non-joined group call that is not bound to a chat
 * @param inputGroupCall The group call which participants will be returned
 * @param limit The maximum number of participants to return; must be positive
 */
suspend fun TdKtxClient.getGroupCallParticipants(
    inputGroupCall: InputGroupCall? = null,
    limit: Int,
): GroupCallParticipants {
    val request = GetGroupCallParticipants(inputGroupCall, limit)
    val requestJson = tdJson.encodeToString(GetGroupCallParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallParticipants.serializer(), responseJson)
}

/**
 * Loads more participants of a group call; not supported in live stories. The loaded participants will be received through updates. Use the field groupCall.loaded_all_participants to check whether all participants have already been loaded
 * @param groupCallId Group call identifier. The group call must be previously received through getGroupCall and must be joined or being joined
 * @param limit The maximum number of participants to load; up to 100
 */
suspend fun TdKtxClient.loadGroupCallParticipants(
    groupCallId: Int,
    limit: Int,
): Ok {
    val request = LoadGroupCallParticipants(groupCallId, limit)
    val requestJson = tdJson.encodeToString(LoadGroupCallParticipants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Leaves a group call @group_call_id Group call identifier
 */
suspend fun TdKtxClient.leaveGroupCall(
    groupCallId: Int,
): Ok {
    val request = LeaveGroupCall(groupCallId)
    val requestJson = tdJson.encodeToString(LeaveGroupCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Ends a group call. Requires groupCall.can_be_managed right for video chats and live stories or groupCall.is_owned otherwise @group_call_id Group call identifier
 */
suspend fun TdKtxClient.endGroupCall(
    groupCallId: Int,
): Ok {
    val request = EndGroupCall(groupCallId)
    val requestJson = tdJson.encodeToString(EndGroupCall.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about available streams in a video chat or a live story @group_call_id Group call identifier
 */
suspend fun TdKtxClient.getGroupCallStreams(
    groupCallId: Int,
): GroupCallStreams {
    val request = GetGroupCallStreams(groupCallId)
    val requestJson = tdJson.encodeToString(GetGroupCallStreams.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GroupCallStreams.serializer(), responseJson)
}

/**
 * Returns a file with a segment of a video chat or live story in a modified OGG format for audio or MPEG-4 format for video
 * @param groupCallId Group call identifier
 * @param timeOffset Point in time when the stream segment begins; Unix timestamp in milliseconds
 * @param scale Segment duration scale; 0-1. Segment's duration is 1000/(2**scale) milliseconds
 * @param channelId Identifier of an audio/video channel to get as received from tgcalls
 * @param videoQuality Video quality as received from tgcalls; pass null to get the worst available quality
 */
suspend fun TdKtxClient.getGroupCallStreamSegment(
    groupCallId: Int,
    timeOffset: Long,
    scale: Int,
    channelId: Int,
    videoQuality: GroupCallVideoQuality? = null,
): Data {
    val request = GetGroupCallStreamSegment(groupCallId, timeOffset, scale, channelId, videoQuality)
    val requestJson = tdJson.encodeToString(GetGroupCallStreamSegment.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Data.serializer(), responseJson)
}

/**
 * Encrypts group call data before sending them over network using tgcalls
 * @param groupCallId Group call identifier. The call must not be a video chat
 * @param dataChannel Data channel for which data is encrypted
 * @param data Data to encrypt
 * @param unencryptedPrefixSize Size of data prefix that must be kept unencrypted
 */
suspend fun TdKtxClient.encryptGroupCallData(
    groupCallId: Int,
    dataChannel: GroupCallDataChannel? = null,
    data: String? = null,
    unencryptedPrefixSize: Int,
): Data {
    val request = EncryptGroupCallData(groupCallId, dataChannel, data, unencryptedPrefixSize)
    val requestJson = tdJson.encodeToString(EncryptGroupCallData.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Data.serializer(), responseJson)
}

/**
 * Decrypts group call data received by tgcalls
 * @param groupCallId Group call identifier. The call must not be a video chat
 * @param participantId Identifier of the group call participant, which sent the data
 * @param dataChannel Data channel for which data was encrypted; pass null if unknown
 * @param data Data to decrypt
 */
suspend fun TdKtxClient.decryptGroupCallData(
    groupCallId: Int,
    participantId: MessageSender? = null,
    dataChannel: GroupCallDataChannel? = null,
    data: String? = null,
): Data {
    val request = DecryptGroupCallData(groupCallId, participantId, dataChannel, data)
    val requestJson = tdJson.encodeToString(DecryptGroupCallData.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Data.serializer(), responseJson)
}

/**
 * Changes the block list of a message sender. Currently, only users and supergroup chats can be blocked
 * @param senderId Identifier of a message sender to block/unblock
 * @param blockList New block list for the message sender; pass null to unblock the message sender
 */
suspend fun TdKtxClient.setMessageSenderBlockList(
    senderId: MessageSender? = null,
    blockList: BlockList? = null,
): Ok {
    val request = SetMessageSenderBlockList(senderId, blockList)
    val requestJson = tdJson.encodeToString(SetMessageSenderBlockList.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Blocks an original sender of a message in the Replies chat
 * @param messageId The identifier of an incoming message in the Replies chat
 * @param deleteMessage Pass true to delete the message
 * @param deleteAllMessages Pass true to delete all messages from the same sender
 * @param reportSpam Pass true to report the sender to the Telegram moderators
 */
suspend fun TdKtxClient.blockMessageSenderFromReplies(
    messageId: Long,
    deleteMessage: Boolean,
    deleteAllMessages: Boolean,
    reportSpam: Boolean,
): Ok {
    val request = BlockMessageSenderFromReplies(messageId, deleteMessage, deleteAllMessages, reportSpam)
    val requestJson = tdJson.encodeToString(BlockMessageSenderFromReplies.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns users and chats that were blocked by the current user
 * @param blockList Block list from which to return users
 * @param offset Number of users and chats to skip in the result; must be non-negative
 * @param limit The maximum number of users and chats to return; up to 100
 */
suspend fun TdKtxClient.getBlockedMessageSenders(
    blockList: BlockList? = null,
    offset: Int,
    limit: Int,
): MessageSenders {
    val request = GetBlockedMessageSenders(blockList, offset, limit)
    val requestJson = tdJson.encodeToString(GetBlockedMessageSenders.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageSenders.serializer(), responseJson)
}

/**
 * Adds a user to the contact list or edits an existing contact by their user identifier
 * @param userId Identifier of the user
 * @param contact The contact to add or edit; phone number may be empty and needs to be specified only if known
 * @param sharePhoneNumber Pass true to share the current user's phone number with the new contact. A corresponding rule to userPrivacySettingShowPhoneNumber will be added if needed. Use the field userFullInfo.need_phone_number_privacy_exception to check whether the current user needs to be asked to share their phone number
 */
suspend fun TdKtxClient.addContact(
    userId: Long,
    contact: ImportedContact? = null,
    sharePhoneNumber: Boolean,
): Ok {
    val request = AddContact(userId, contact, sharePhoneNumber)
    val requestJson = tdJson.encodeToString(AddContact.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds new contacts or edits existing contacts by their phone numbers; contacts' user identifiers are ignored
 * @param contacts The list of contacts to import or edit
 */
suspend fun TdKtxClient.importContacts(
    contacts: List<ImportedContact>? = null,
): ImportedContacts {
    val request = ImportContacts(contacts)
    val requestJson = tdJson.encodeToString(ImportContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ImportedContacts.serializer(), responseJson)
}

/**
 * Returns all contacts of the user
 */
suspend fun TdKtxClient.getContacts(
): Users {
    val request = GetContacts()
    val requestJson = tdJson.encodeToString(GetContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Searches for the specified query in the first names, last names and usernames of the known user contacts
 * @param query Query to search for; may be empty to return all contacts
 * @param limit The maximum number of users to be returned
 */
suspend fun TdKtxClient.searchContacts(
    query: String? = null,
    limit: Int,
): Users {
    val request = SearchContacts(query, limit)
    val requestJson = tdJson.encodeToString(SearchContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Removes users from the contact list @user_ids Identifiers of users to be deleted
 */
suspend fun TdKtxClient.removeContacts(
    userIds: List<Long>? = null,
): Ok {
    val request = RemoveContacts(userIds)
    val requestJson = tdJson.encodeToString(RemoveContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the total number of imported contacts
 */
suspend fun TdKtxClient.getImportedContactCount(
): Count {
    val request = GetImportedContactCount()
    val requestJson = tdJson.encodeToString(GetImportedContactCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Count.serializer(), responseJson)
}

/**
 * Changes imported contacts using the list of contacts saved on the device. Imports newly added contacts and, if at least the file database is enabled, deletes recently deleted contacts. Query result depends on the result of the previous query, so only one query is possible at the same time
 * @param contacts The new list of contacts to import
 */
suspend fun TdKtxClient.changeImportedContacts(
    contacts: List<ImportedContact>? = null,
): ImportedContacts {
    val request = ChangeImportedContacts(contacts)
    val requestJson = tdJson.encodeToString(ChangeImportedContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ImportedContacts.serializer(), responseJson)
}

/**
 * Clears all imported contacts, contact list remains unchanged
 */
suspend fun TdKtxClient.clearImportedContacts(
): Ok {
    val request = ClearImportedContacts()
    val requestJson = tdJson.encodeToString(ClearImportedContacts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the list of close friends of the current user @user_ids User identifiers of close friends; the users must be contacts of the current user
 */
suspend fun TdKtxClient.setCloseFriends(
    userIds: List<Long>? = null,
): Ok {
    val request = SetCloseFriends(userIds)
    val requestJson = tdJson.encodeToString(SetCloseFriends.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns all close friends of the current user
 */
suspend fun TdKtxClient.getCloseFriends(
): Users {
    val request = GetCloseFriends()
    val requestJson = tdJson.encodeToString(GetCloseFriends.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Changes a personal profile photo of a contact user @user_id User identifier @photo Profile photo to set; pass null to delete the photo; inputChatPhotoPrevious isn't supported in this function
 */
suspend fun TdKtxClient.setUserPersonalProfilePhoto(
    userId: Long,
    photo: InputChatPhoto? = null,
): Ok {
    val request = SetUserPersonalProfilePhoto(userId, photo)
    val requestJson = tdJson.encodeToString(SetUserPersonalProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes a note of a contact user
 * @param userId User identifier
 * @param note Note to set for the user; 0-getOption("user_note_text_length_max") characters. Only Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, and DateTime entities are allowed
 */
suspend fun TdKtxClient.setUserNote(
    userId: Long,
    note: FormattedText? = null,
): Ok {
    val request = SetUserNote(userId, note)
    val requestJson = tdJson.encodeToString(SetUserNote.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Suggests a profile photo to another regular user with common messages and allowing non-paid messages
 * @param userId User identifier
 * @param photo Profile photo to suggest; inputChatPhotoPrevious isn't supported in this function
 */
suspend fun TdKtxClient.suggestUserProfilePhoto(
    userId: Long,
    photo: InputChatPhoto? = null,
): Ok {
    val request = SuggestUserProfilePhoto(userId, photo)
    val requestJson = tdJson.encodeToString(SuggestUserProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Suggests a birthdate to another regular user with common messages and allowing non-paid messages
 * @param userId User identifier
 * @param birthdate Birthdate to suggest
 */
suspend fun TdKtxClient.suggestUserBirthdate(
    userId: Long,
    birthdate: Birthdate? = null,
): Ok {
    val request = SuggestUserBirthdate(userId, birthdate)
    val requestJson = tdJson.encodeToString(SuggestUserBirthdate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether the bot can manage emoji status of the current user @bot_user_id User identifier of the bot @can_manage_emoji_status Pass true if the bot is allowed to change emoji status of the user; pass false otherwise
 */
suspend fun TdKtxClient.toggleBotCanManageEmojiStatus(
    botUserId: Long,
    canManageEmojiStatus: Boolean,
): Ok {
    val request = ToggleBotCanManageEmojiStatus(botUserId, canManageEmojiStatus)
    val requestJson = tdJson.encodeToString(ToggleBotCanManageEmojiStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the emoji status of a user; for bots only @user_id Identifier of the user @emoji_status New emoji status; pass null to switch to the default badge
 */
suspend fun TdKtxClient.setUserEmojiStatus(
    userId: Long,
    emojiStatus: EmojiStatus? = null,
): Ok {
    val request = SetUserEmojiStatus(userId, emojiStatus)
    val requestJson = tdJson.encodeToString(SetUserEmojiStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns messages in the personal chat of a given user; for bots only
 * @param userId User identifier
 * @param limit The maximum number of messages to be returned; 1-20
 */
suspend fun TdKtxClient.getPersonalChatHistory(
    userId: Long,
    limit: Int,
): Messages {
    val request = GetPersonalChatHistory(userId, limit)
    val requestJson = tdJson.encodeToString(GetPersonalChatHistory.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Messages.serializer(), responseJson)
}

/**
 * Searches a user by their phone number. Returns a 404 error if the user can't be found
 * @param phoneNumber Phone number to search for
 * @param onlyLocal Pass true to get only locally available information without sending network requests
 */
suspend fun TdKtxClient.searchUserByPhoneNumber(
    phoneNumber: String? = null,
    onlyLocal: Boolean,
): User {
    val request = SearchUserByPhoneNumber(phoneNumber, onlyLocal)
    val requestJson = tdJson.encodeToString(SearchUserByPhoneNumber.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Shares the phone number of the current user with a mutual contact. Supposed to be called when the user clicks on chatActionBarSharePhoneNumber
 * @param userId Identifier of the user with whom to share the phone number. The user must be a mutual contact
 */
suspend fun TdKtxClient.sharePhoneNumber(
    userId: Long,
): Ok {
    val request = SharePhoneNumber(userId)
    val requestJson = tdJson.encodeToString(SharePhoneNumber.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the profile photos of a user. Personal and public photo aren't returned
 * @param userId User identifier
 * @param offset The number of photos to skip; must be non-negative
 * @param limit The maximum number of photos to be returned; up to 100
 */
suspend fun TdKtxClient.getUserProfilePhotos(
    userId: Long,
    offset: Int,
    limit: Int,
): ChatPhotos {
    val request = GetUserProfilePhotos(userId, offset, limit)
    val requestJson = tdJson.encodeToString(GetUserProfilePhotos.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatPhotos.serializer(), responseJson)
}

/**
 * Returns the list of profile audio files of a user
 * @param userId User identifier
 * @param offset The number of audio files to skip; must be non-negative
 * @param limit The maximum number of audio files to be returned; up to 100
 */
suspend fun TdKtxClient.getUserProfileAudios(
    userId: Long,
    offset: Int,
    limit: Int,
): Audios {
    val request = GetUserProfileAudios(userId, offset, limit)
    val requestJson = tdJson.encodeToString(GetUserProfileAudios.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Audios.serializer(), responseJson)
}

/**
 * Checks whether a file is in the profile audio files of the current user. Returns a 404 error if it isn't @file_id Identifier of the audio file to check
 */
suspend fun TdKtxClient.isProfileAudio(
    fileId: Int,
): Ok {
    val request = IsProfileAudio(fileId)
    val requestJson = tdJson.encodeToString(IsProfileAudio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds an audio file to the beginning of the profile audio files of the current user
 * @param audio The audio file to be added
 * @param duration Duration of the audio, in seconds; may be replaced by the server; ignored for already uploaded files
 * @param title Title of the audio; 0-64 characters; may be replaced by the server; ignored for already uploaded files
 * @param performer Performer of the audio; 0-64 characters, may be replaced by the server; ignored for already uploaded files
 */
suspend fun TdKtxClient.addProfileAudio(
    audio: InputFile? = null,
    duration: Int,
    title: String? = null,
    performer: String? = null,
): Ok {
    val request = AddProfileAudio(audio, duration, title, performer)
    val requestJson = tdJson.encodeToString(AddProfileAudio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes position of an audio file in the profile audio files of the current user
 * @param fileId Identifier of the file from profile audio files, which position will be changed
 * @param afterFileId Identifier of the file from profile audio files after which the file will be positioned; pass 0 to move the file to the beginning of the list
 */
suspend fun TdKtxClient.setProfileAudioPosition(
    fileId: Int,
    afterFileId: Int,
): Ok {
    val request = SetProfileAudioPosition(fileId, afterFileId)
    val requestJson = tdJson.encodeToString(SetProfileAudioPosition.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes an audio file from the profile audio files of the current user @file_id Identifier of the audio file to be removed
 */
suspend fun TdKtxClient.removeProfileAudio(
    fileId: Int,
): Ok {
    val request = RemoveProfileAudio(fileId)
    val requestJson = tdJson.encodeToString(RemoveProfileAudio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns outline of a sticker. This is an offline method. Returns a 404 error if the outline isn't known
 * @param stickerFileId File identifier of the sticker
 * @param forAnimatedEmoji Pass true to get the outline scaled for animated emoji
 * @param forClickedAnimatedEmojiMessage Pass true to get the outline scaled for clicked animated emoji message
 */
suspend fun TdKtxClient.getStickerOutline(
    stickerFileId: Int,
    forAnimatedEmoji: Boolean,
    forClickedAnimatedEmojiMessage: Boolean,
): Outline {
    val request = GetStickerOutline(stickerFileId, forAnimatedEmoji, forClickedAnimatedEmojiMessage)
    val requestJson = tdJson.encodeToString(GetStickerOutline.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Outline.serializer(), responseJson)
}

/**
 * Returns outline of a sticker as an SVG path. This is an offline method. Returns an empty string if the outline isn't known
 * @param stickerFileId File identifier of the sticker
 * @param forAnimatedEmoji Pass true to get the outline scaled for animated emoji
 * @param forClickedAnimatedEmojiMessage Pass true to get the outline scaled for clicked animated emoji message
 */
suspend fun TdKtxClient.getStickerOutlineSvgPath(
    stickerFileId: Int,
    forAnimatedEmoji: Boolean,
    forClickedAnimatedEmojiMessage: Boolean,
): Text {
    val request = GetStickerOutlineSvgPath(stickerFileId, forAnimatedEmoji, forClickedAnimatedEmojiMessage)
    val requestJson = tdJson.encodeToString(GetStickerOutlineSvgPath.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns stickers from the installed sticker sets that correspond to any of the given emoji or can be found by sticker-specific keywords. If the query is non-empty, then favorite, recently used or trending stickers may also be returned
 * @param stickerType Type of the stickers to return
 * @param query Search query; a space-separated list of emojis or a keyword prefix. If empty, returns all known installed stickers
 * @param limit The maximum number of stickers to be returned
 * @param chatId Chat identifier for which to return stickers. Available custom emoji stickers may be different for different chats
 */
suspend fun TdKtxClient.getStickers(
    stickerType: StickerType? = null,
    query: String? = null,
    limit: Int,
    chatId: Long,
): Stickers {
    val request = GetStickers(stickerType, query, limit, chatId)
    val requestJson = tdJson.encodeToString(GetStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns unique emoji that correspond to stickers to be found by the getStickers(sticker_type, query, 1000000, chat_id)
 * @param stickerType Type of the stickers to search for
 * @param query Search query
 * @param chatId Chat identifier for which to find stickers
 * @param returnOnlyMainEmoji Pass true if only main emoji for each found sticker must be included in the result
 */
suspend fun TdKtxClient.getAllStickerEmojis(
    stickerType: StickerType? = null,
    query: String? = null,
    chatId: Long,
    returnOnlyMainEmoji: Boolean,
): Emojis {
    val request = GetAllStickerEmojis(stickerType, query, chatId, returnOnlyMainEmoji)
    val requestJson = tdJson.encodeToString(GetAllStickerEmojis.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Emojis.serializer(), responseJson)
}

/**
 * Searches for stickers from public sticker sets that correspond to any of the given emoji
 * @param stickerType Type of the stickers to return
 * @param emojis Space-separated list of emojis to search for
 * @param query Query to search for; may be empty to search for emoji only
 * @param inputLanguageCodes List of possible IETF language tags of the user's input language; may be empty if unknown
 * @param offset The offset from which to return the stickers; must be non-negative
 * @param limit The maximum number of stickers to be returned; 0-100
 */
suspend fun TdKtxClient.searchStickers(
    stickerType: StickerType? = null,
    emojis: String? = null,
    query: String? = null,
    inputLanguageCodes: List<String>? = null,
    offset: Int,
    limit: Int,
): Stickers {
    val request = SearchStickers(stickerType, emojis, query, inputLanguageCodes, offset, limit)
    val requestJson = tdJson.encodeToString(SearchStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns greeting stickers from regular sticker sets that can be used for the start page of other users
 */
suspend fun TdKtxClient.getGreetingStickers(
): Stickers {
    val request = GetGreetingStickers()
    val requestJson = tdJson.encodeToString(GetGreetingStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns premium stickers from regular sticker sets @limit The maximum number of stickers to be returned; 0-100
 */
suspend fun TdKtxClient.getPremiumStickers(
    limit: Int,
): Stickers {
    val request = GetPremiumStickers(limit)
    val requestJson = tdJson.encodeToString(GetPremiumStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns a list of installed sticker sets @sticker_type Type of the sticker sets to return
 */
suspend fun TdKtxClient.getInstalledStickerSets(
    stickerType: StickerType? = null,
): StickerSets {
    val request = GetInstalledStickerSets(stickerType)
    val requestJson = tdJson.encodeToString(GetInstalledStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Returns a list of archived sticker sets
 * @param stickerType Type of the sticker sets to return
 * @param offsetStickerSetId Identifier of the sticker set from which to return the result; use 0 to get results from the beginning
 * @param limit The maximum number of sticker sets to return; up to 100
 */
suspend fun TdKtxClient.getArchivedStickerSets(
    stickerType: StickerType? = null,
    offsetStickerSetId: Long,
    limit: Int,
): StickerSets {
    val request = GetArchivedStickerSets(stickerType, offsetStickerSetId, limit)
    val requestJson = tdJson.encodeToString(GetArchivedStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Returns a list of trending sticker sets. For optimal performance, the number of returned sticker sets is chosen by TDLib
 * @param stickerType Type of the sticker sets to return
 * @param offset The offset from which to return the sticker sets; must be non-negative
 * @param limit The maximum number of sticker sets to be returned; up to 100. For optimal performance, the number of returned sticker sets is chosen by TDLib and can be smaller than the specified limit, even if the end of the list has not been reached
 */
suspend fun TdKtxClient.getTrendingStickerSets(
    stickerType: StickerType? = null,
    offset: Int,
    limit: Int,
): TrendingStickerSets {
    val request = GetTrendingStickerSets(stickerType, offset, limit)
    val requestJson = tdJson.encodeToString(GetTrendingStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TrendingStickerSets.serializer(), responseJson)
}

/**
 * Returns a list of sticker sets attached to a file, including regular, mask, and emoji sticker sets. Currently, only animations, photos, and videos can have attached sticker sets @file_id File identifier
 */
suspend fun TdKtxClient.getAttachedStickerSets(
    fileId: Int,
): StickerSets {
    val request = GetAttachedStickerSets(fileId)
    val requestJson = tdJson.encodeToString(GetAttachedStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Returns information about a sticker set by its identifier @set_id Identifier of the sticker set
 */
suspend fun TdKtxClient.getStickerSet(
    setId: Long,
): StickerSet {
    val request = GetStickerSet(setId)
    val requestJson = tdJson.encodeToString(GetStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSet.serializer(), responseJson)
}

/**
 * Returns name of a sticker set by its identifier @set_id Identifier of the sticker set
 */
suspend fun TdKtxClient.getStickerSetName(
    setId: Long,
): Text {
    val request = GetStickerSetName(setId)
    val requestJson = tdJson.encodeToString(GetStickerSetName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Searches for a sticker set by its name @name Name of the sticker set @ignore_cache Pass true to ignore local cache of sticker sets and always send a network request
 */
suspend fun TdKtxClient.searchStickerSet(
    name: String? = null,
    ignoreCache: Boolean,
): StickerSet {
    val request = SearchStickerSet(name, ignoreCache)
    val requestJson = tdJson.encodeToString(SearchStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSet.serializer(), responseJson)
}

/**
 * Searches for installed sticker sets by looking for specified query in their title and name @sticker_type Type of the sticker sets to search for @query Query to search for @limit The maximum number of sticker sets to return
 */
suspend fun TdKtxClient.searchInstalledStickerSets(
    stickerType: StickerType? = null,
    query: String? = null,
    limit: Int,
): StickerSets {
    val request = SearchInstalledStickerSets(stickerType, query, limit)
    val requestJson = tdJson.encodeToString(SearchInstalledStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Searches for sticker sets by looking for specified query in their title and name. Excludes installed sticker sets from the results
 * @param stickerType Type of the sticker sets to return
 * @param query Query to search for
 */
suspend fun TdKtxClient.searchStickerSets(
    stickerType: StickerType? = null,
    query: String? = null,
): StickerSets {
    val request = SearchStickerSets(stickerType, query)
    val requestJson = tdJson.encodeToString(SearchStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Installs/uninstalls or activates/archives a sticker set @set_id Identifier of the sticker set @is_installed The new value of is_installed @is_archived The new value of is_archived. A sticker set can't be installed and archived simultaneously
 */
suspend fun TdKtxClient.changeStickerSet(
    setId: Long,
    isInstalled: Boolean,
    isArchived: Boolean,
): Ok {
    val request = ChangeStickerSet(setId, isInstalled, isArchived)
    val requestJson = tdJson.encodeToString(ChangeStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs the server that some trending sticker sets have been viewed by the user @sticker_set_ids Identifiers of viewed trending sticker sets
 */
suspend fun TdKtxClient.viewTrendingStickerSets(
    stickerSetIds: List<Long>? = null,
): Ok {
    val request = ViewTrendingStickerSets(stickerSetIds)
    val requestJson = tdJson.encodeToString(ViewTrendingStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the order of installed sticker sets @sticker_type Type of the sticker sets to reorder @sticker_set_ids Identifiers of installed sticker sets in the new correct order
 */
suspend fun TdKtxClient.reorderInstalledStickerSets(
    stickerType: StickerType? = null,
    stickerSetIds: List<Long>? = null,
): Ok {
    val request = ReorderInstalledStickerSets(stickerType, stickerSetIds)
    val requestJson = tdJson.encodeToString(ReorderInstalledStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of recently used stickers @is_attached Pass true to return stickers and masks that were recently attached to photos or video files; pass false to return recently sent stickers
 */
suspend fun TdKtxClient.getRecentStickers(
    isAttached: Boolean,
): Stickers {
    val request = GetRecentStickers(isAttached)
    val requestJson = tdJson.encodeToString(GetRecentStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Manually adds a new sticker to the list of recently used stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set or in WEBP or WEBM format can be added to this list. Emoji stickers can't be added to recent stickers
 * @param isAttached Pass true to add the sticker to the list of stickers recently attached to photo or video files; pass false to add the sticker to the list of recently sent stickers
 * @param sticker Sticker file to add
 */
suspend fun TdKtxClient.addRecentSticker(
    isAttached: Boolean,
    sticker: InputFile? = null,
): Stickers {
    val request = AddRecentSticker(isAttached, sticker)
    val requestJson = tdJson.encodeToString(AddRecentSticker.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Removes a sticker from the list of recently used stickers @is_attached Pass true to remove the sticker from the list of stickers recently attached to photo or video files; pass false to remove the sticker from the list of recently sent stickers @sticker Sticker file to delete
 */
suspend fun TdKtxClient.removeRecentSticker(
    isAttached: Boolean,
    sticker: InputFile? = null,
): Ok {
    val request = RemoveRecentSticker(isAttached, sticker)
    val requestJson = tdJson.encodeToString(RemoveRecentSticker.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Clears the list of recently used stickers @is_attached Pass true to clear the list of stickers recently attached to photo or video files; pass false to clear the list of recently sent stickers
 */
suspend fun TdKtxClient.clearRecentStickers(
    isAttached: Boolean,
): Ok {
    val request = ClearRecentStickers(isAttached)
    val requestJson = tdJson.encodeToString(ClearRecentStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns favorite stickers
 */
suspend fun TdKtxClient.getFavoriteStickers(
): Stickers {
    val request = GetFavoriteStickers()
    val requestJson = tdJson.encodeToString(GetFavoriteStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Adds a new sticker to the list of favorite stickers. The new sticker is added to the top of the list. If the sticker was already in the list, it is removed from the list first. Only stickers belonging to a sticker set or in WEBP or WEBM format can be added to this list. Emoji stickers can't be added to favorite stickers
 * @param sticker Sticker file to add
 */
suspend fun TdKtxClient.addFavoriteSticker(
    sticker: InputFile? = null,
): Ok {
    val request = AddFavoriteSticker(sticker)
    val requestJson = tdJson.encodeToString(AddFavoriteSticker.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a sticker from the list of favorite stickers @sticker Sticker file to delete from the list
 */
suspend fun TdKtxClient.removeFavoriteSticker(
    sticker: InputFile? = null,
): Ok {
    val request = RemoveFavoriteSticker(sticker)
    val requestJson = tdJson.encodeToString(RemoveFavoriteSticker.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns emoji corresponding to a sticker. The list is only for informational purposes, because a sticker is always sent with a fixed emoji from the corresponding Sticker object @sticker Sticker file identifier
 */
suspend fun TdKtxClient.getStickerEmojis(
    sticker: InputFile? = null,
): Emojis {
    val request = GetStickerEmojis(sticker)
    val requestJson = tdJson.encodeToString(GetStickerEmojis.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Emojis.serializer(), responseJson)
}

/**
 * Searches for emojis by keywords. Supported only if the file database is enabled. Order of results is unspecified
 * @param text Text to search for
 * @param inputLanguageCodes List of possible IETF language tags of the user's input language; may be empty if unknown
 */
suspend fun TdKtxClient.searchEmojis(
    text: String? = null,
    inputLanguageCodes: List<String>? = null,
): EmojiKeywords {
    val request = SearchEmojis(text, inputLanguageCodes)
    val requestJson = tdJson.encodeToString(SearchEmojis.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiKeywords.serializer(), responseJson)
}

/**
 * Returns emojis matching the keyword. Supported only if the file database is enabled. Order of results is unspecified
 * @param text Text to search for
 * @param inputLanguageCodes List of possible IETF language tags of the user's input language; may be empty if unknown
 */
suspend fun TdKtxClient.getKeywordEmojis(
    text: String? = null,
    inputLanguageCodes: List<String>? = null,
): Emojis {
    val request = GetKeywordEmojis(text, inputLanguageCodes)
    val requestJson = tdJson.encodeToString(GetKeywordEmojis.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Emojis.serializer(), responseJson)
}

/**
 * Returns available emoji categories @type Type of emoji categories to return; pass null to get default emoji categories
 */
suspend fun TdKtxClient.getEmojiCategories(
    type: EmojiCategoryType? = null,
): EmojiCategories {
    val request = GetEmojiCategories(type)
    val requestJson = tdJson.encodeToString(GetEmojiCategories.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmojiCategories.serializer(), responseJson)
}

/**
 * Returns an animated emoji corresponding to a given emoji. Returns a 404 error if the emoji has no animated emoji @emoji The emoji
 */
suspend fun TdKtxClient.getAnimatedEmoji(
    emoji: String? = null,
): AnimatedEmoji {
    val request = GetAnimatedEmoji(emoji)
    val requestJson = tdJson.encodeToString(GetAnimatedEmoji.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AnimatedEmoji.serializer(), responseJson)
}

/**
 * Returns an HTTP URL which can be used to automatically log in to the translation platform and suggest new emoji replacements. The URL will be valid for 30 seconds after generation
 * @param languageCode Language code for which the emoji replacements will be suggested
 */
suspend fun TdKtxClient.getEmojiSuggestionsUrl(
    languageCode: String? = null,
): HttpUrl {
    val request = GetEmojiSuggestionsUrl(languageCode)
    val requestJson = tdJson.encodeToString(GetEmojiSuggestionsUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns the list of custom emoji stickers by their identifiers. Stickers are returned in arbitrary order. Only found stickers are returned
 * @param customEmojiIds Identifiers of custom emoji stickers. At most 200 custom emoji stickers can be received simultaneously
 */
suspend fun TdKtxClient.getCustomEmojiStickers(
    customEmojiIds: List<Long>? = null,
): Stickers {
    val request = GetCustomEmojiStickers(customEmojiIds)
    val requestJson = tdJson.encodeToString(GetCustomEmojiStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns default list of custom emoji stickers for placing on a chat photo
 */
suspend fun TdKtxClient.getDefaultChatPhotoCustomEmojiStickers(
): Stickers {
    val request = GetDefaultChatPhotoCustomEmojiStickers()
    val requestJson = tdJson.encodeToString(GetDefaultChatPhotoCustomEmojiStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns default list of custom emoji stickers for placing on a profile photo
 */
suspend fun TdKtxClient.getDefaultProfilePhotoCustomEmojiStickers(
): Stickers {
    val request = GetDefaultProfilePhotoCustomEmojiStickers()
    val requestJson = tdJson.encodeToString(GetDefaultProfilePhotoCustomEmojiStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns default list of custom emoji stickers for reply background
 */
suspend fun TdKtxClient.getDefaultBackgroundCustomEmojiStickers(
): Stickers {
    val request = GetDefaultBackgroundCustomEmojiStickers()
    val requestJson = tdJson.encodeToString(GetDefaultBackgroundCustomEmojiStickers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns saved animations
 */
suspend fun TdKtxClient.getSavedAnimations(
): Animations {
    val request = GetSavedAnimations()
    val requestJson = tdJson.encodeToString(GetSavedAnimations.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Animations.serializer(), responseJson)
}

/**
 * Manually adds a new animation to the list of saved animations. The new animation is added to the beginning of the list. If the animation was already in the list, it is removed first. Only non-secret video animations with MIME type "video/mp4" can be added to the list
 * @param animation The animation file to be added. Only animations known to the server (i.e., successfully sent via a message) can be added to the list
 */
suspend fun TdKtxClient.addSavedAnimation(
    animation: InputFile? = null,
): Ok {
    val request = AddSavedAnimation(animation)
    val requestJson = tdJson.encodeToString(AddSavedAnimation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes an animation from the list of saved animations @animation Animation file to be removed
 */
suspend fun TdKtxClient.removeSavedAnimation(
    animation: InputFile? = null,
): Ok {
    val request = RemoveSavedAnimation(animation)
    val requestJson = tdJson.encodeToString(RemoveSavedAnimation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns up to 20 recently used inline bots in the order of their last usage
 */
suspend fun TdKtxClient.getRecentInlineBots(
): Users {
    val request = GetRecentInlineBots()
    val requestJson = tdJson.encodeToString(GetRecentInlineBots.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Returns the list of bots owned by the current user
 */
suspend fun TdKtxClient.getOwnedBots(
): Users {
    val request = GetOwnedBots()
    val requestJson = tdJson.encodeToString(GetOwnedBots.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Users.serializer(), responseJson)
}

/**
 * Searches for recently used hashtags by their prefix @prefix Hashtag prefix to search for @limit The maximum number of hashtags to be returned
 */
suspend fun TdKtxClient.searchHashtags(
    prefix: String? = null,
    limit: Int,
): Hashtags {
    val request = SearchHashtags(prefix, limit)
    val requestJson = tdJson.encodeToString(SearchHashtags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Hashtags.serializer(), responseJson)
}

/**
 * Removes a hashtag from the list of recently used hashtags @hashtag Hashtag to delete
 */
suspend fun TdKtxClient.removeRecentHashtag(
    hashtag: String? = null,
): Ok {
    val request = RemoveRecentHashtag(hashtag)
    val requestJson = tdJson.encodeToString(RemoveRecentHashtag.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a link preview by the text of a message. Do not call this function too often. Returns a 404 error if the text has no link preview
 * @param text Message text with formatting
 * @param linkPreviewOptions Options to be used for generation of the link preview; pass null to use default link preview options
 */
suspend fun TdKtxClient.getLinkPreview(
    text: FormattedText? = null,
    linkPreviewOptions: LinkPreviewOptions? = null,
): LinkPreview {
    val request = GetLinkPreview(text, linkPreviewOptions)
    val requestJson = tdJson.encodeToString(GetLinkPreview.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LinkPreview.serializer(), responseJson)
}

/**
 * Returns an instant view version of a web page if available. This is an offline method if only_local is true. Returns a 404 error if the web page has no instant view page
 * @param url The web page URL
 * @param onlyLocal Pass true to get only locally available information without sending network requests
 */
suspend fun TdKtxClient.getWebPageInstantView(
    url: String? = null,
    onlyLocal: Boolean,
): WebPageInstantView {
    val request = GetWebPageInstantView(url, onlyLocal)
    val requestJson = tdJson.encodeToString(GetWebPageInstantView.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(WebPageInstantView.serializer(), responseJson)
}

/**
 * Changes a profile photo for the current user
 * @param photo Profile photo to set
 * @param isPublic Pass true to set the public photo, which will be visible even if the main photo is hidden by privacy settings
 */
suspend fun TdKtxClient.setProfilePhoto(
    photo: InputChatPhoto? = null,
    isPublic: Boolean,
): Ok {
    val request = SetProfilePhoto(photo, isPublic)
    val requestJson = tdJson.encodeToString(SetProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a profile photo @profile_photo_id Identifier of the profile photo to delete
 */
suspend fun TdKtxClient.deleteProfilePhoto(
    profilePhotoId: Long,
): Ok {
    val request = DeleteProfilePhoto(profilePhotoId)
    val requestJson = tdJson.encodeToString(DeleteProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes accent color and background custom emoji for the current user; for Telegram Premium users only
 * @param accentColorId Identifier of the accent color to use
 * @param backgroundCustomEmojiId Identifier of a custom emoji to be shown on the reply header and link preview background; 0 if none
 */
suspend fun TdKtxClient.setAccentColor(
    accentColorId: Int,
    backgroundCustomEmojiId: Long,
): Ok {
    val request = SetAccentColor(accentColorId, backgroundCustomEmojiId)
    val requestJson = tdJson.encodeToString(SetAccentColor.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes color scheme for the current user based on an owned or a hosted upgraded gift; for Telegram Premium users only
 * @param upgradedGiftColorsId Identifier of the upgradedGiftColors scheme to use
 */
suspend fun TdKtxClient.setUpgradedGiftColors(
    upgradedGiftColorsId: Long,
): Ok {
    val request = SetUpgradedGiftColors(upgradedGiftColorsId)
    val requestJson = tdJson.encodeToString(SetUpgradedGiftColors.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes accent color and background custom emoji for profile of the current user; for Telegram Premium users only
 * @param profileAccentColorId Identifier of the accent color to use for profile; pass -1 if none
 * @param profileBackgroundCustomEmojiId Identifier of a custom emoji to be shown on the user's profile photo background; 0 if none
 */
suspend fun TdKtxClient.setProfileAccentColor(
    profileAccentColorId: Int,
    profileBackgroundCustomEmojiId: Long,
): Ok {
    val request = SetProfileAccentColor(profileAccentColorId, profileBackgroundCustomEmojiId)
    val requestJson = tdJson.encodeToString(SetProfileAccentColor.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the first and last name of the current user @first_name The new value of the first name for the current user; 1-64 characters @last_name The new value of the optional last name for the current user; 0-64 characters
 */
suspend fun TdKtxClient.setName(
    firstName: String? = null,
    lastName: String? = null,
): Ok {
    val request = SetName(firstName, lastName)
    val requestJson = tdJson.encodeToString(SetName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the bio of the current user @bio The new value of the user bio; 0-getOption("bio_length_max") characters without line feeds
 */
suspend fun TdKtxClient.setBio(
    bio: String? = null,
): Ok {
    val request = SetBio(bio)
    val requestJson = tdJson.encodeToString(SetBio.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the editable username of the current user
 * @param username The new value of the username. Use an empty string to remove the username. The username can't be completely removed if there is another active or disabled username
 */
suspend fun TdKtxClient.setUsername(
    username: String? = null,
): Ok {
    val request = SetUsername(username)
    val requestJson = tdJson.encodeToString(SetUsername.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes active state for a username of the current user. The editable username can't be disabled. May return an error with a message "USERNAMES_ACTIVE_TOO_MUCH" if the maximum number of active usernames has been reached
 * @param username The username to change
 * @param isActive Pass true to activate the username; pass false to disable it
 */
suspend fun TdKtxClient.toggleUsernameIsActive(
    username: String? = null,
    isActive: Boolean,
): Ok {
    val request = ToggleUsernameIsActive(username, isActive)
    val requestJson = tdJson.encodeToString(ToggleUsernameIsActive.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes order of active usernames of the current user @usernames The new order of active usernames. All currently active usernames must be specified
 */
suspend fun TdKtxClient.reorderActiveUsernames(
    usernames: List<String>? = null,
): Ok {
    val request = ReorderActiveUsernames(usernames)
    val requestJson = tdJson.encodeToString(ReorderActiveUsernames.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the birthdate of the current user @birthdate The new value of the current user's birthdate; pass null to remove the birthdate
 */
suspend fun TdKtxClient.setBirthdate(
    birthdate: Birthdate? = null,
): Ok {
    val request = SetBirthdate(birthdate)
    val requestJson = tdJson.encodeToString(SetBirthdate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the main profile tab of the current user @main_profile_tab The new value of the main profile tab
 */
suspend fun TdKtxClient.setMainProfileTab(
    mainProfileTab: ProfileTab? = null,
): Ok {
    val request = SetMainProfileTab(mainProfileTab)
    val requestJson = tdJson.encodeToString(SetMainProfileTab.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the personal chat of the current user @chat_id Identifier of the new personal chat; pass 0 to remove the chat. Use getSuitablePersonalChats to get suitable chats
 */
suspend fun TdKtxClient.setPersonalChat(
    chatId: Long,
): Ok {
    val request = SetPersonalChat(chatId)
    val requestJson = tdJson.encodeToString(SetPersonalChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the emoji status of the current user; for Telegram Premium users only @emoji_status New emoji status; pass null to switch to the default badge
 */
suspend fun TdKtxClient.setEmojiStatus(
    emojiStatus: EmojiStatus? = null,
): Ok {
    val request = SetEmojiStatus(emojiStatus)
    val requestJson = tdJson.encodeToString(SetEmojiStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether the current user has sponsored messages enabled. The setting has no effect for users without Telegram Premium for which sponsored messages are always enabled
 * @param hasSponsoredMessagesEnabled Pass true to enable sponsored messages for the current user; false to disable them
 */
suspend fun TdKtxClient.toggleHasSponsoredMessagesEnabled(
    hasSponsoredMessagesEnabled: Boolean,
): Ok {
    val request = ToggleHasSponsoredMessagesEnabled(hasSponsoredMessagesEnabled)
    val requestJson = tdJson.encodeToString(ToggleHasSponsoredMessagesEnabled.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the business location of the current user. Requires Telegram Business subscription @location The new location of the business; pass null to remove the location
 */
suspend fun TdKtxClient.setBusinessLocation(
    location: BusinessLocation? = null,
): Ok {
    val request = SetBusinessLocation(location)
    val requestJson = tdJson.encodeToString(SetBusinessLocation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the business opening hours of the current user. Requires Telegram Business subscription
 * @param openingHours The new opening hours of the business; pass null to remove the opening hours; up to 28 time intervals can be specified
 */
suspend fun TdKtxClient.setBusinessOpeningHours(
    openingHours: BusinessOpeningHours? = null,
): Ok {
    val request = SetBusinessOpeningHours(openingHours)
    val requestJson = tdJson.encodeToString(SetBusinessOpeningHours.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the business greeting message settings of the current user. Requires Telegram Business subscription @greeting_message_settings The new settings for the greeting message of the business; pass null to disable the greeting message
 */
suspend fun TdKtxClient.setBusinessGreetingMessageSettings(
    greetingMessageSettings: BusinessGreetingMessageSettings? = null,
): Ok {
    val request = SetBusinessGreetingMessageSettings(greetingMessageSettings)
    val requestJson = tdJson.encodeToString(SetBusinessGreetingMessageSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the business away message settings of the current user. Requires Telegram Business subscription @away_message_settings The new settings for the away message of the business; pass null to disable the away message
 */
suspend fun TdKtxClient.setBusinessAwayMessageSettings(
    awayMessageSettings: BusinessAwayMessageSettings? = null,
): Ok {
    val request = SetBusinessAwayMessageSettings(awayMessageSettings)
    val requestJson = tdJson.encodeToString(SetBusinessAwayMessageSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the business start page of the current user. Requires Telegram Business subscription @start_page The new start page of the business; pass null to remove custom start page
 */
suspend fun TdKtxClient.setBusinessStartPage(
    startPage: InputBusinessStartPage? = null,
): Ok {
    val request = SetBusinessStartPage(startPage)
    val requestJson = tdJson.encodeToString(SetBusinessStartPage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a code to the specified phone number. Aborts previous phone number verification if there was one. On success, returns information about the sent code
 * @param phoneNumber The phone number, in international format
 * @param settings Settings for the authentication of the user's phone number; pass null to use default settings
 * @param type Type of the request for which the code is sent
 */
suspend fun TdKtxClient.sendPhoneNumberCode(
    phoneNumber: String? = null,
    settings: PhoneNumberAuthenticationSettings? = null,
    type: PhoneNumberCodeType? = null,
): AuthenticationCodeInfo {
    val request = SendPhoneNumberCode(phoneNumber, settings, type)
    val requestJson = tdJson.encodeToString(SendPhoneNumberCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Sends Firebase Authentication SMS to the specified phone number. Works only when received a code of the type authenticationCodeTypeFirebaseAndroid or authenticationCodeTypeFirebaseIos
 * @param token Play Integrity API or SafetyNet Attestation API token for the Android application, or secret from push notification for the iOS application
 */
suspend fun TdKtxClient.sendPhoneNumberFirebaseSms(
    token: String? = null,
): Ok {
    val request = SendPhoneNumberFirebaseSms(token)
    val requestJson = tdJson.encodeToString(SendPhoneNumberFirebaseSms.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports that authentication code wasn't delivered via SMS to the specified phone number; for official mobile applications only @mobile_network_code Current mobile network code
 */
suspend fun TdKtxClient.reportPhoneNumberCodeMissing(
    mobileNetworkCode: String? = null,
): Ok {
    val request = ReportPhoneNumberCodeMissing(mobileNetworkCode)
    val requestJson = tdJson.encodeToString(ReportPhoneNumberCodeMissing.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resends the authentication code sent to a phone number. Works only if the previously received authenticationCodeInfo next_code_type was not null and the server-specified timeout has passed
 * @param reason Reason of code resending; pass null if unknown
 */
suspend fun TdKtxClient.resendPhoneNumberCode(
    reason: ResendCodeReason? = null,
): AuthenticationCodeInfo {
    val request = ResendPhoneNumberCode(reason)
    val requestJson = tdJson.encodeToString(ResendPhoneNumberCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Checks the authentication code and completes the request for which the code was sent if appropriate @code Authentication code to check
 */
suspend fun TdKtxClient.checkPhoneNumberCode(
    code: String? = null,
): Ok {
    val request = CheckPhoneNumberCode(code)
    val requestJson = tdJson.encodeToString(CheckPhoneNumberCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about the business bot that is connected to the current user account. Returns a 404 error if there is no connected bot
 */
suspend fun TdKtxClient.getBusinessConnectedBot(
): BusinessConnectedBotInfo {
    val request = GetBusinessConnectedBot()
    val requestJson = tdJson.encodeToString(GetBusinessConnectedBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessConnectedBotInfo.serializer(), responseJson)
}

/**
 * Adds or changes business bot that is connected to the current user account @bot Connection settings for the bot
 */
suspend fun TdKtxClient.setBusinessConnectedBot(
    bot: BusinessConnectedBot? = null,
): Ok {
    val request = SetBusinessConnectedBot(bot)
    val requestJson = tdJson.encodeToString(SetBusinessConnectedBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Confirms an unconfirmed business connection of the current user from another device @bot_user_id User identifier of the bot
 */
suspend fun TdKtxClient.confirmBusinessConnectedBot(
    botUserId: Long,
): Ok {
    val request = ConfirmBusinessConnectedBot(botUserId)
    val requestJson = tdJson.encodeToString(ConfirmBusinessConnectedBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes the business bot that is connected to the current user account @bot_user_id Unique user identifier for the bot
 */
suspend fun TdKtxClient.deleteBusinessConnectedBot(
    botUserId: Long,
): Ok {
    val request = DeleteBusinessConnectedBot(botUserId)
    val requestJson = tdJson.encodeToString(DeleteBusinessConnectedBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Pauses or resumes the connected business bot in a specific chat @chat_id Chat identifier @is_paused Pass true to pause the connected bot in the chat; pass false to resume the bot
 */
suspend fun TdKtxClient.toggleBusinessConnectedBotChatIsPaused(
    chatId: Long,
    isPaused: Boolean,
): Ok {
    val request = ToggleBusinessConnectedBotChatIsPaused(chatId, isPaused)
    val requestJson = tdJson.encodeToString(ToggleBusinessConnectedBotChatIsPaused.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes the connected business bot from a specific chat by adding the chat to businessRecipients.excluded_chat_ids @chat_id Chat identifier
 */
suspend fun TdKtxClient.removeBusinessConnectedBotFromChat(
    chatId: Long,
): Ok {
    val request = RemoveBusinessConnectedBotFromChat(chatId)
    val requestJson = tdJson.encodeToString(RemoveBusinessConnectedBotFromChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns business chat links created for the current account
 */
suspend fun TdKtxClient.getBusinessChatLinks(
): BusinessChatLinks {
    val request = GetBusinessChatLinks()
    val requestJson = tdJson.encodeToString(GetBusinessChatLinks.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessChatLinks.serializer(), responseJson)
}

/**
 * Creates a business chat link for the current account. Requires Telegram Business subscription. There can be up to getOption("business_chat_link_count_max") links created. Returns the created link
 * @param linkInfo Information about the link to create
 */
suspend fun TdKtxClient.createBusinessChatLink(
    linkInfo: InputBusinessChatLink? = null,
): BusinessChatLink {
    val request = CreateBusinessChatLink(linkInfo)
    val requestJson = tdJson.encodeToString(CreateBusinessChatLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessChatLink.serializer(), responseJson)
}

/**
 * Edits a business chat link of the current account. Requires Telegram Business subscription. Returns the edited link
 * @param link The link to edit
 * @param linkInfo New description of the link
 */
suspend fun TdKtxClient.editBusinessChatLink(
    link: String? = null,
    linkInfo: InputBusinessChatLink? = null,
): BusinessChatLink {
    val request = EditBusinessChatLink(link, linkInfo)
    val requestJson = tdJson.encodeToString(EditBusinessChatLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessChatLink.serializer(), responseJson)
}

/**
 * Deletes a business chat link of the current account @link The link to delete
 */
suspend fun TdKtxClient.deleteBusinessChatLink(
    link: String? = null,
): Ok {
    val request = DeleteBusinessChatLink(link)
    val requestJson = tdJson.encodeToString(DeleteBusinessChatLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a business chat link @link_name Name of the link
 */
suspend fun TdKtxClient.getBusinessChatLinkInfo(
    linkName: String? = null,
): BusinessChatLinkInfo {
    val request = GetBusinessChatLinkInfo(linkName)
    val requestJson = tdJson.encodeToString(GetBusinessChatLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessChatLinkInfo.serializer(), responseJson)
}

/**
 * Returns an HTTPS link, which can be used to get information about the current user
 */
suspend fun TdKtxClient.getUserLink(
): UserLink {
    val request = GetUserLink()
    val requestJson = tdJson.encodeToString(GetUserLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UserLink.serializer(), responseJson)
}

/**
 * Searches a user by a token from the user's link @token Token to search for
 */
suspend fun TdKtxClient.searchUserByToken(
    token: String? = null,
): User {
    val request = SearchUserByToken(token)
    val requestJson = tdJson.encodeToString(SearchUserByToken.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Sets the list of commands supported by the bot for the given user scope and language; for bots only
 * @param scope The scope to which the commands are relevant; pass null to change commands in the default bot command scope
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the commands will be applied to all users from the given scope, for which language there are no dedicated commands
 * @param commands List of the bot's commands
 */
suspend fun TdKtxClient.setCommands(
    scope: BotCommandScope? = null,
    languageCode: String? = null,
    commands: List<BotCommand>? = null,
): Ok {
    val request = SetCommands(scope, languageCode, commands)
    val requestJson = tdJson.encodeToString(SetCommands.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes commands supported by the bot for the given user scope and language; for bots only
 * @param scope The scope to which the commands are relevant; pass null to delete commands in the default bot command scope
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 */
suspend fun TdKtxClient.deleteCommands(
    scope: BotCommandScope? = null,
    languageCode: String? = null,
): Ok {
    val request = DeleteCommands(scope, languageCode)
    val requestJson = tdJson.encodeToString(DeleteCommands.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of commands supported by the bot for the given user scope and language; for bots only
 * @param scope The scope to which the commands are relevant; pass null to get commands in the default bot command scope
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 */
suspend fun TdKtxClient.getCommands(
    scope: BotCommandScope? = null,
    languageCode: String? = null,
): BotCommands {
    val request = GetCommands(scope, languageCode)
    val requestJson = tdJson.encodeToString(GetCommands.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotCommands.serializer(), responseJson)
}

/**
 * Sets menu button for the given user or for all users; for bots only
 * @param userId Identifier of the user or 0 to set menu button for all users
 * @param menuButton New menu button
 */
suspend fun TdKtxClient.setMenuButton(
    userId: Long,
    menuButton: BotMenuButton? = null,
): Ok {
    val request = SetMenuButton(userId, menuButton)
    val requestJson = tdJson.encodeToString(SetMenuButton.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns menu button set by the bot for the given user; for bots only @user_id Identifier of the user or 0 to get the default menu button
 */
suspend fun TdKtxClient.getMenuButton(
    userId: Long,
): BotMenuButton {
    val request = GetMenuButton(userId)
    val requestJson = tdJson.encodeToString(GetMenuButton.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotMenuButton.serializer(), responseJson)
}

/**
 * Sets default administrator rights for adding the bot to basic group and supergroup chats; for bots only @default_group_administrator_rights Default administrator rights for adding the bot to basic group and supergroup chats; pass null to remove default rights
 */
suspend fun TdKtxClient.setDefaultGroupAdministratorRights(
    defaultGroupAdministratorRights: ChatAdministratorRights? = null,
): Ok {
    val request = SetDefaultGroupAdministratorRights(defaultGroupAdministratorRights)
    val requestJson = tdJson.encodeToString(SetDefaultGroupAdministratorRights.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets default administrator rights for adding the bot to channel chats; for bots only @default_channel_administrator_rights Default administrator rights for adding the bot to channels; pass null to remove default rights
 */
suspend fun TdKtxClient.setDefaultChannelAdministratorRights(
    defaultChannelAdministratorRights: ChatAdministratorRights? = null,
): Ok {
    val request = SetDefaultChannelAdministratorRights(defaultChannelAdministratorRights)
    val requestJson = tdJson.encodeToString(SetDefaultChannelAdministratorRights.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether the specified bot can send messages to the user. Returns a 404 error if can't and the access can be granted by call to allowBotToSendMessages @bot_user_id Identifier of the target bot
 */
suspend fun TdKtxClient.canBotSendMessages(
    botUserId: Long,
): Ok {
    val request = CanBotSendMessages(botUserId)
    val requestJson = tdJson.encodeToString(CanBotSendMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Allows the specified bot to send messages to the user @bot_user_id Identifier of the target bot
 */
suspend fun TdKtxClient.allowBotToSendMessages(
    botUserId: Long,
): Ok {
    val request = AllowBotToSendMessages(botUserId)
    val requestJson = tdJson.encodeToString(AllowBotToSendMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a custom request from a Web App
 * @param botUserId Identifier of the bot
 * @param method The method name
 * @param parameters JSON-serialized method parameters
 */
suspend fun TdKtxClient.sendWebAppCustomRequest(
    botUserId: Long,
    method: String? = null,
    parameters: String? = null,
): CustomRequestResult {
    val request = SendWebAppCustomRequest(botUserId, method, parameters)
    val requestJson = tdJson.encodeToString(SendWebAppCustomRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CustomRequestResult.serializer(), responseJson)
}

/**
 * Returns the list of media previews of a bot @bot_user_id Identifier of the target bot. The bot must have the main Web App
 */
suspend fun TdKtxClient.getBotMediaPreviews(
    botUserId: Long,
): BotMediaPreviews {
    val request = GetBotMediaPreviews(botUserId)
    val requestJson = tdJson.encodeToString(GetBotMediaPreviews.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotMediaPreviews.serializer(), responseJson)
}

/**
 * Returns the list of media previews for the given language and the list of languages for which the bot has dedicated previews
 * @param botUserId Identifier of the target bot. The bot must be owned and must have the main Web App
 * @param languageCode A two-letter ISO 639-1 language code for which to get previews. If empty, then default previews are returned
 */
suspend fun TdKtxClient.getBotMediaPreviewInfo(
    botUserId: Long,
    languageCode: String? = null,
): BotMediaPreviewInfo {
    val request = GetBotMediaPreviewInfo(botUserId, languageCode)
    val requestJson = tdJson.encodeToString(GetBotMediaPreviewInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotMediaPreviewInfo.serializer(), responseJson)
}

/**
 * Adds a new media preview to the beginning of the list of media previews of a bot. Returns the added preview after addition is completed server-side. The total number of previews must not exceed getOption("bot_media_preview_count_max") for the given language
 * @param botUserId Identifier of the target bot. The bot must be owned and must have the main Web App
 * @param languageCode A two-letter ISO 639-1 language code for which preview is added. If empty, then the preview will be shown to all users for whose languages there are no dedicated previews. If non-empty, then there must be an official language pack of the same name, which is returned by getLocalizationTargetInfo
 * @param content Content of the added preview
 */
suspend fun TdKtxClient.addBotMediaPreview(
    botUserId: Long,
    languageCode: String? = null,
    content: InputStoryContent? = null,
): BotMediaPreview {
    val request = AddBotMediaPreview(botUserId, languageCode, content)
    val requestJson = tdJson.encodeToString(AddBotMediaPreview.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotMediaPreview.serializer(), responseJson)
}

/**
 * Replaces media preview in the list of media previews of a bot. Returns the new preview after edit is completed server-side
 * @param botUserId Identifier of the target bot. The bot must be owned and must have the main Web App
 * @param languageCode Language code of the media preview to edit
 * @param fileId File identifier of the media to replace
 * @param content Content of the new preview
 */
suspend fun TdKtxClient.editBotMediaPreview(
    botUserId: Long,
    languageCode: String? = null,
    fileId: Int,
    content: InputStoryContent? = null,
): BotMediaPreview {
    val request = EditBotMediaPreview(botUserId, languageCode, fileId, content)
    val requestJson = tdJson.encodeToString(EditBotMediaPreview.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotMediaPreview.serializer(), responseJson)
}

/**
 * Changes order of media previews in the list of media previews of a bot
 * @param botUserId Identifier of the target bot. The bot must be owned and must have the main Web App
 * @param languageCode Language code of the media previews to reorder
 * @param fileIds File identifiers of the media in the new order
 */
suspend fun TdKtxClient.reorderBotMediaPreviews(
    botUserId: Long,
    languageCode: String? = null,
    fileIds: List<Int>? = null,
): Ok {
    val request = ReorderBotMediaPreviews(botUserId, languageCode, fileIds)
    val requestJson = tdJson.encodeToString(ReorderBotMediaPreviews.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes media previews from the list of media previews of a bot
 * @param botUserId Identifier of the target bot. The bot must be owned and must have the main Web App
 * @param languageCode Language code of the media previews to delete
 * @param fileIds File identifiers of the media to delete
 */
suspend fun TdKtxClient.deleteBotMediaPreviews(
    botUserId: Long,
    languageCode: String? = null,
    fileIds: List<Int>? = null,
): Ok {
    val request = DeleteBotMediaPreviews(botUserId, languageCode, fileIds)
    val requestJson = tdJson.encodeToString(DeleteBotMediaPreviews.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether a username can be set for a new bot. Use checkChatUsername to check username for other chat types
 * @param username Username to be checked
 */
suspend fun TdKtxClient.checkBotUsername(
    username: String? = null,
): CheckChatUsernameResult {
    val request = CheckBotUsername(username)
    val requestJson = tdJson.encodeToString(CheckBotUsername.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CheckChatUsernameResult.serializer(), responseJson)
}

/**
 * Creates a bot which will be managed by another bot. Returns the created bot. May return an error with a message "BOT_CREATE_LIMIT_EXCEEDED" if the user already owns the maximum allowed number of bots as per premiumLimitTypeOwnedBotCount. An internal link "https://t.me/BotFather?start=deletebot" can be processed to handle the error
 * @param managerBotUserId Identifier of the bot that will manage the created bot
 * @param name Name of the bot; 1-64 characters
 * @param username Username of the bot. The username must end with "bot". Use checkBotUsername to find whether the name is suitable
 * @param viaLink Pass true if the bot is created from an internalLinkTypeRequestManagedBot link
 */
suspend fun TdKtxClient.createBot(
    managerBotUserId: Long,
    name: String? = null,
    username: String? = null,
    viaLink: Boolean,
): User {
    val request = CreateBot(managerBotUserId, name, username, viaLink)
    val requestJson = tdJson.encodeToString(CreateBot.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Returns token of a managed bot; for bots only
 * @param botUserId Identifier of the managed bot
 * @param revoke Pass true to revoke the current token and create a new one
 */
suspend fun TdKtxClient.getManagedBotToken(
    botUserId: Long,
    revoke: Boolean,
): Text {
    val request = GetManagedBotToken(botUserId, revoke)
    val requestJson = tdJson.encodeToString(GetManagedBotToken.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns access settings of a managed bot; for bots only @bot_user_id Identifier of the managed bot
 */
suspend fun TdKtxClient.getManagedBotAccessSettings(
    botUserId: Long,
): BotAccessSettings {
    val request = GetManagedBotAccessSettings(botUserId)
    val requestJson = tdJson.encodeToString(GetManagedBotAccessSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BotAccessSettings.serializer(), responseJson)
}

/**
 * Sets access settings of a managed bot; for bots only @bot_user_id Identifier of the managed bot @settings New access settings
 */
suspend fun TdKtxClient.setManagedBotAccessSettings(
    botUserId: Long,
    settings: BotAccessSettings? = null,
): Ok {
    val request = SetManagedBotAccessSettings(botUserId, settings)
    val requestJson = tdJson.encodeToString(SetManagedBotAccessSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the name of a bot. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the name will be shown to all users for whose languages there is no dedicated name
 * @param name New bot's name on the specified language; 0-64 characters; must be non-empty if language code is empty
 */
suspend fun TdKtxClient.setBotName(
    botUserId: Long,
    languageCode: String? = null,
    name: String? = null,
): Ok {
    val request = SetBotName(botUserId, languageCode, name)
    val requestJson = tdJson.encodeToString(SetBotName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the name of a bot in the given language. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 */
suspend fun TdKtxClient.getBotName(
    botUserId: Long,
    languageCode: String? = null,
): Text {
    val request = GetBotName(botUserId, languageCode)
    val requestJson = tdJson.encodeToString(GetBotName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Changes a profile photo for a bot @bot_user_id Identifier of the target bot @photo Profile photo to set; pass null to delete the chat photo
 */
suspend fun TdKtxClient.setBotProfilePhoto(
    botUserId: Long,
    photo: InputChatPhoto? = null,
): Ok {
    val request = SetBotProfilePhoto(botUserId, photo)
    val requestJson = tdJson.encodeToString(SetBotProfilePhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes active state for a username of a bot. The editable username can be disabled only if there are other active usernames. May return an error with a message "USERNAMES_ACTIVE_TOO_MUCH" if the maximum number of active usernames has been reached. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param username The username to change
 * @param isActive Pass true to activate the username; pass false to disable it
 */
suspend fun TdKtxClient.toggleBotUsernameIsActive(
    botUserId: Long,
    username: String? = null,
    isActive: Boolean,
): Ok {
    val request = ToggleBotUsernameIsActive(botUserId, username, isActive)
    val requestJson = tdJson.encodeToString(ToggleBotUsernameIsActive.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes order of active usernames of a bot. Can be called only if userTypeBot.can_be_edited == true @bot_user_id Identifier of the target bot @usernames The new order of active usernames. All currently active usernames must be specified
 */
suspend fun TdKtxClient.reorderBotActiveUsernames(
    botUserId: Long,
    usernames: List<String>? = null,
): Ok {
    val request = ReorderBotActiveUsernames(botUserId, usernames)
    val requestJson = tdJson.encodeToString(ReorderBotActiveUsernames.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets the text shown in the chat with a bot if the chat is empty. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the description will be shown to all users for whose languages there is no dedicated description
 */
suspend fun TdKtxClient.setBotInfoDescription(
    botUserId: Long,
    languageCode: String? = null,
    description: String? = null,
): Ok {
    val request = SetBotInfoDescription(botUserId, languageCode, description)
    val requestJson = tdJson.encodeToString(SetBotInfoDescription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the text shown in the chat with a bot if the chat is empty in the given language. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 */
suspend fun TdKtxClient.getBotInfoDescription(
    botUserId: Long,
    languageCode: String? = null,
): Text {
    val request = GetBotInfoDescription(botUserId, languageCode)
    val requestJson = tdJson.encodeToString(GetBotInfoDescription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Sets the text shown on a bot's profile page and sent together with the link when users share the bot. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code. If empty, the short description will be shown to all users for whose languages there is no dedicated description
 * @param shortDescription New bot's short description on the specified language
 */
suspend fun TdKtxClient.setBotInfoShortDescription(
    botUserId: Long,
    languageCode: String? = null,
    shortDescription: String? = null,
): Ok {
    val request = SetBotInfoShortDescription(botUserId, languageCode, shortDescription)
    val requestJson = tdJson.encodeToString(SetBotInfoShortDescription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the text shown on a bot's profile page and sent together with the link when users share the bot in the given language. Can be called only if userTypeBot.can_be_edited == true
 * @param botUserId Identifier of the target bot
 * @param languageCode A two-letter ISO 639-1 language code or an empty string
 */
suspend fun TdKtxClient.getBotInfoShortDescription(
    botUserId: Long,
    languageCode: String? = null,
): Text {
    val request = GetBotInfoShortDescription(botUserId, languageCode)
    val requestJson = tdJson.encodeToString(GetBotInfoShortDescription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Changes the verification status of a user or a chat by an owned bot
 * @param botUserId Identifier of the owned bot, which will verify the user or the chat
 * @param verifiedId Identifier of the user or the supergroup or channel chat, which will be verified by the bot
 * @param customDescription Custom description of verification reason; 0-getOption("bot_verification_custom_description_length_max"). If empty, then "was verified by organization "organization_name"" will be used as description. Can be specified only if the bot is allowed to provide custom description
 */
suspend fun TdKtxClient.setMessageSenderBotVerification(
    botUserId: Long,
    verifiedId: MessageSender? = null,
    customDescription: String? = null,
): Ok {
    val request = SetMessageSenderBotVerification(botUserId, verifiedId, customDescription)
    val requestJson = tdJson.encodeToString(SetMessageSenderBotVerification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes the verification status of a user or a chat by an owned bot
 * @param botUserId Identifier of the owned bot, which verified the user or the chat
 * @param verifiedId Identifier of the user or the supergroup or channel chat, which verification is removed
 */
suspend fun TdKtxClient.removeMessageSenderBotVerification(
    botUserId: Long,
    verifiedId: MessageSender? = null,
): Ok {
    val request = RemoveMessageSenderBotVerification(botUserId, verifiedId)
    val requestJson = tdJson.encodeToString(RemoveMessageSenderBotVerification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns all active sessions of the current user. Additionally, getBusinessConnectedBot must be used to show the bot on top of active sessions
 */
suspend fun TdKtxClient.getActiveSessions(
): Sessions {
    val request = GetActiveSessions()
    val requestJson = tdJson.encodeToString(GetActiveSessions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Sessions.serializer(), responseJson)
}

/**
 * Terminates a session of the current user @session_id Session identifier
 */
suspend fun TdKtxClient.terminateSession(
    sessionId: Long,
): Ok {
    val request = TerminateSession(sessionId)
    val requestJson = tdJson.encodeToString(TerminateSession.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Terminates all other sessions of the current user. Additionally, the user must be suggested to delete the connected business bot using deleteBusinessConnectedBot if there is any
 */
suspend fun TdKtxClient.terminateAllOtherSessions(
): Ok {
    val request = TerminateAllOtherSessions()
    val requestJson = tdJson.encodeToString(TerminateAllOtherSessions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Confirms an unconfirmed session of the current user from another device @session_id Session identifier
 */
suspend fun TdKtxClient.confirmSession(
    sessionId: Long,
): Ok {
    val request = ConfirmSession(sessionId)
    val requestJson = tdJson.encodeToString(ConfirmSession.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a session can accept incoming calls @session_id Session identifier @can_accept_calls Pass true to allow accepting incoming calls by the session; pass false otherwise
 */
suspend fun TdKtxClient.toggleSessionCanAcceptCalls(
    sessionId: Long,
    canAcceptCalls: Boolean,
): Ok {
    val request = ToggleSessionCanAcceptCalls(sessionId, canAcceptCalls)
    val requestJson = tdJson.encodeToString(ToggleSessionCanAcceptCalls.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a session can accept incoming secret chats @session_id Session identifier @can_accept_secret_chats Pass true to allow accepting secret chats by the session; pass false otherwise
 */
suspend fun TdKtxClient.toggleSessionCanAcceptSecretChats(
    sessionId: Long,
    canAcceptSecretChats: Boolean,
): Ok {
    val request = ToggleSessionCanAcceptSecretChats(sessionId, canAcceptSecretChats)
    val requestJson = tdJson.encodeToString(ToggleSessionCanAcceptSecretChats.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the period of inactivity after which sessions will automatically be terminated @inactive_session_ttl_days New number of days of inactivity before sessions will be automatically terminated; 1-366 days
 */
suspend fun TdKtxClient.setInactiveSessionTtl(
    inactiveSessionTtlDays: Int,
): Ok {
    val request = SetInactiveSessionTtl(inactiveSessionTtlDays)
    val requestJson = tdJson.encodeToString(SetInactiveSessionTtl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns all website where the current user used Telegram to log in
 */
suspend fun TdKtxClient.getConnectedWebsites(
): ConnectedWebsites {
    val request = GetConnectedWebsites()
    val requestJson = tdJson.encodeToString(GetConnectedWebsites.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ConnectedWebsites.serializer(), responseJson)
}

/**
 * Disconnects website from the current user's Telegram account @website_id Website identifier
 */
suspend fun TdKtxClient.disconnectWebsite(
    websiteId: Long,
): Ok {
    val request = DisconnectWebsite(websiteId)
    val requestJson = tdJson.encodeToString(DisconnectWebsite.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Disconnects all websites from the current user's Telegram account
 */
suspend fun TdKtxClient.disconnectAllWebsites(
): Ok {
    val request = DisconnectAllWebsites()
    val requestJson = tdJson.encodeToString(DisconnectAllWebsites.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the editable username of a supergroup or channel, requires owner privileges in the supergroup or channel
 * @param supergroupId Identifier of the supergroup or channel
 * @param username New value of the username. Use an empty string to remove the username. The username can't be completely removed if there is another active or disabled username
 */
suspend fun TdKtxClient.setSupergroupUsername(
    supergroupId: Long,
    username: String? = null,
): Ok {
    val request = SetSupergroupUsername(supergroupId, username)
    val requestJson = tdJson.encodeToString(SetSupergroupUsername.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes active state for a username of a supergroup or channel, requires owner privileges in the supergroup or channel. The editable username can't be disabled. May return an error with a message "USERNAMES_ACTIVE_TOO_MUCH" if the maximum number of active usernames has been reached
 * @param supergroupId Identifier of the supergroup or channel
 * @param username The username to change
 * @param isActive Pass true to activate the username; pass false to disable it
 */
suspend fun TdKtxClient.toggleSupergroupUsernameIsActive(
    supergroupId: Long,
    username: String? = null,
    isActive: Boolean,
): Ok {
    val request = ToggleSupergroupUsernameIsActive(supergroupId, username, isActive)
    val requestJson = tdJson.encodeToString(ToggleSupergroupUsernameIsActive.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Disables all active non-editable usernames of a supergroup or channel, requires owner privileges in the supergroup or channel @supergroup_id Identifier of the supergroup or channel
 */
suspend fun TdKtxClient.disableAllSupergroupUsernames(
    supergroupId: Long,
): Ok {
    val request = DisableAllSupergroupUsernames(supergroupId)
    val requestJson = tdJson.encodeToString(DisableAllSupergroupUsernames.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes order of active usernames of a supergroup or channel, requires owner privileges in the supergroup or channel
 * @param supergroupId Identifier of the supergroup or channel
 * @param usernames The new order of active usernames. All currently active usernames must be specified
 */
suspend fun TdKtxClient.reorderSupergroupActiveUsernames(
    supergroupId: Long,
    usernames: List<String>? = null,
): Ok {
    val request = ReorderSupergroupActiveUsernames(supergroupId, usernames)
    val requestJson = tdJson.encodeToString(ReorderSupergroupActiveUsernames.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the sticker set of a supergroup; requires can_change_info administrator right @supergroup_id Identifier of the supergroup @sticker_set_id New value of the supergroup sticker set identifier. Use 0 to remove the supergroup sticker set
 */
suspend fun TdKtxClient.setSupergroupStickerSet(
    supergroupId: Long,
    stickerSetId: Long,
): Ok {
    val request = SetSupergroupStickerSet(supergroupId, stickerSetId)
    val requestJson = tdJson.encodeToString(SetSupergroupStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the custom emoji sticker set of a supergroup; requires can_change_info administrator right. The chat must have at least chatBoostFeatures.min_custom_emoji_sticker_set_boost_level boost level to pass the corresponding color
 * @param supergroupId Identifier of the supergroup
 * @param customEmojiStickerSetId New value of the custom emoji sticker set identifier for the supergroup. Use 0 to remove the custom emoji sticker set in the supergroup
 */
suspend fun TdKtxClient.setSupergroupCustomEmojiStickerSet(
    supergroupId: Long,
    customEmojiStickerSetId: Long,
): Ok {
    val request = SetSupergroupCustomEmojiStickerSet(supergroupId, customEmojiStickerSetId)
    val requestJson = tdJson.encodeToString(SetSupergroupCustomEmojiStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the number of times the supergroup must be boosted by a user to ignore slow mode and chat permission restrictions; requires can_restrict_members administrator right
 * @param supergroupId Identifier of the supergroup
 * @param unrestrictBoostCount New value of the unrestrict_boost_count supergroup setting; 0-8. Use 0 to remove the setting
 */
suspend fun TdKtxClient.setSupergroupUnrestrictBoostCount(
    supergroupId: Long,
    unrestrictBoostCount: Int,
): Ok {
    val request = SetSupergroupUnrestrictBoostCount(supergroupId, unrestrictBoostCount)
    val requestJson = tdJson.encodeToString(SetSupergroupUnrestrictBoostCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the main profile tab of the channel; requires can_change_info administrator right
 * @param supergroupId Identifier of the channel
 * @param mainProfileTab The new value of the main profile tab
 */
suspend fun TdKtxClient.setSupergroupMainProfileTab(
    supergroupId: Long,
    mainProfileTab: ProfileTab? = null,
): Ok {
    val request = SetSupergroupMainProfileTab(supergroupId, mainProfileTab)
    val requestJson = tdJson.encodeToString(SetSupergroupMainProfileTab.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether sender signature or link to the account is added to sent messages in a channel; requires can_change_info member right
 * @param supergroupId Identifier of the channel
 * @param signMessages New value of sign_messages
 * @param showMessageSender New value of show_message_sender
 */
suspend fun TdKtxClient.toggleSupergroupSignMessages(
    supergroupId: Long,
    signMessages: Boolean,
    showMessageSender: Boolean,
): Ok {
    val request = ToggleSupergroupSignMessages(supergroupId, signMessages, showMessageSender)
    val requestJson = tdJson.encodeToString(ToggleSupergroupSignMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether joining is mandatory to send messages to a discussion supergroup; requires can_restrict_members administrator right
 * @param supergroupId Identifier of the supergroup that isn't a broadcast group
 * @param joinToSendMessages New value of join_to_send_messages
 */
suspend fun TdKtxClient.toggleSupergroupJoinToSendMessages(
    supergroupId: Long,
    joinToSendMessages: Boolean,
): Ok {
    val request = ToggleSupergroupJoinToSendMessages(supergroupId, joinToSendMessages)
    val requestJson = tdJson.encodeToString(ToggleSupergroupJoinToSendMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether all users directly joining the supergroup need to be approved by supergroup administrators; requires can_restrict_members administrator right
 * @param supergroupId Identifier of the supergroup that isn't a broadcast group and isn't a channel direct message group
 * @param joinByRequest New value of join_by_request
 * @param guardBotUserId Identifier of the bot which will be the guard bot in the group; pass 0 if none; ignored if join_by_request == false. The bot must have administrator privileges and can_invite_users right in the supergroup chat, and must have userTypeBot.is_guard == true
 * @param applyToInviteLinks Pass true to apply the change to the existing invite links, including primary links
 */
suspend fun TdKtxClient.toggleSupergroupJoinByRequest(
    supergroupId: Long,
    joinByRequest: Boolean,
    guardBotUserId: Long,
    applyToInviteLinks: Boolean,
): Ok {
    val request = ToggleSupergroupJoinByRequest(supergroupId, joinByRequest, guardBotUserId, applyToInviteLinks)
    val requestJson = tdJson.encodeToString(ToggleSupergroupJoinByRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether the message history of a supergroup is available to new members; requires can_change_info member right @supergroup_id The identifier of the supergroup @is_all_history_available The new value of is_all_history_available
 */
suspend fun TdKtxClient.toggleSupergroupIsAllHistoryAvailable(
    supergroupId: Long,
    isAllHistoryAvailable: Boolean,
): Ok {
    val request = ToggleSupergroupIsAllHistoryAvailable(supergroupId, isAllHistoryAvailable)
    val requestJson = tdJson.encodeToString(ToggleSupergroupIsAllHistoryAvailable.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether sponsored messages are shown in the channel chat; requires owner privileges in the channel. The chat must have at least chatBoostFeatures.min_sponsored_message_disable_boost_level boost level to disable sponsored messages
 * @param supergroupId The identifier of the channel
 * @param canHaveSponsoredMessages The new value of can_have_sponsored_messages
 */
suspend fun TdKtxClient.toggleSupergroupCanHaveSponsoredMessages(
    supergroupId: Long,
    canHaveSponsoredMessages: Boolean,
): Ok {
    val request = ToggleSupergroupCanHaveSponsoredMessages(supergroupId, canHaveSponsoredMessages)
    val requestJson = tdJson.encodeToString(ToggleSupergroupCanHaveSponsoredMessages.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether messages are automatically translated in the channel chat; requires can_change_info administrator right in the channel. The chat must have at least chatBoostFeatures.min_automatic_translation_boost_level boost level to enable automatic translation
 * @param supergroupId The identifier of the channel
 * @param hasAutomaticTranslation The new value of has_automatic_translation
 */
suspend fun TdKtxClient.toggleSupergroupHasAutomaticTranslation(
    supergroupId: Long,
    hasAutomaticTranslation: Boolean,
): Ok {
    val request = ToggleSupergroupHasAutomaticTranslation(supergroupId, hasAutomaticTranslation)
    val requestJson = tdJson.encodeToString(ToggleSupergroupHasAutomaticTranslation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether non-administrators can receive only administrators and bots using getSupergroupMembers or searchChatMembers. Can be called only if supergroupFullInfo.can_hide_members == true
 * @param supergroupId Identifier of the supergroup
 * @param hasHiddenMembers New value of has_hidden_members
 */
suspend fun TdKtxClient.toggleSupergroupHasHiddenMembers(
    supergroupId: Long,
    hasHiddenMembers: Boolean,
): Ok {
    val request = ToggleSupergroupHasHiddenMembers(supergroupId, hasHiddenMembers)
    val requestJson = tdJson.encodeToString(ToggleSupergroupHasHiddenMembers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether aggressive anti-spam checks are enabled in the supergroup. Can be called only if supergroupFullInfo.can_toggle_aggressive_anti_spam == true
 * @param supergroupId The identifier of the supergroup, which isn't a broadcast group
 * @param hasAggressiveAntiSpamEnabled The new value of has_aggressive_anti_spam_enabled
 */
suspend fun TdKtxClient.toggleSupergroupHasAggressiveAntiSpamEnabled(
    supergroupId: Long,
    hasAggressiveAntiSpamEnabled: Boolean,
): Ok {
    val request = ToggleSupergroupHasAggressiveAntiSpamEnabled(supergroupId, hasAggressiveAntiSpamEnabled)
    val requestJson = tdJson.encodeToString(ToggleSupergroupHasAggressiveAntiSpamEnabled.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether the supergroup is a forum; requires owner privileges in the supergroup. Discussion supergroups can't be converted to forums
 * @param supergroupId Identifier of the supergroup
 * @param isForum New value of is_forum
 * @param hasForumTabs New value of has_forum_tabs; ignored if is_forum is false
 */
suspend fun TdKtxClient.toggleSupergroupIsForum(
    supergroupId: Long,
    isForum: Boolean,
    hasForumTabs: Boolean,
): Ok {
    val request = ToggleSupergroupIsForum(supergroupId, isForum, hasForumTabs)
    val requestJson = tdJson.encodeToString(ToggleSupergroupIsForum.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Upgrades supergroup to a broadcast group; requires owner privileges in the supergroup @supergroup_id Identifier of the supergroup
 */
suspend fun TdKtxClient.toggleSupergroupIsBroadcastGroup(
    supergroupId: Long,
): Ok {
    val request = ToggleSupergroupIsBroadcastGroup(supergroupId)
    val requestJson = tdJson.encodeToString(ToggleSupergroupIsBroadcastGroup.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports messages in a supergroup as spam; requires administrator rights in the supergroup
 * @param supergroupId Supergroup identifier
 * @param messageIds Identifiers of messages to report. Use messageProperties.can_report_supergroup_spam to check whether the message can be reported
 */
suspend fun TdKtxClient.reportSupergroupSpam(
    supergroupId: Long,
    messageIds: List<Long>? = null,
): Ok {
    val request = ReportSupergroupSpam(supergroupId, messageIds)
    val requestJson = tdJson.encodeToString(ReportSupergroupSpam.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports a false deletion of a message by aggressive anti-spam checks; requires administrator rights in the supergroup. Can be called only for messages from chatEventMessageDeleted with can_report_anti_spam_false_positive == true
 * @param supergroupId Supergroup identifier
 * @param messageId Identifier of the erroneously deleted message from chatEventMessageDeleted
 */
suspend fun TdKtxClient.reportSupergroupAntiSpamFalsePositive(
    supergroupId: Long,
    messageId: Long,
): Ok {
    val request = ReportSupergroupAntiSpamFalsePositive(supergroupId, messageId)
    val requestJson = tdJson.encodeToString(ReportSupergroupAntiSpamFalsePositive.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about members or banned users in a supergroup or channel. Can be used only if supergroupFullInfo.can_get_members == true; additionally, administrator privileges may be required for some filters
 * @param supergroupId Identifier of the supergroup or channel
 * @param filter The type of users to return; pass null to use supergroupMembersFilterRecent
 * @param offset Number of users to skip
 * @param limit The maximum number of users to be returned; up to 200
 */
suspend fun TdKtxClient.getSupergroupMembers(
    supergroupId: Long,
    filter: SupergroupMembersFilter? = null,
    offset: Int,
    limit: Int,
): ChatMembers {
    val request = GetSupergroupMembers(supergroupId, filter, offset, limit)
    val requestJson = tdJson.encodeToString(GetSupergroupMembers.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatMembers.serializer(), responseJson)
}

/**
 * Closes a secret chat, effectively transferring its state to secretChatStateClosed @secret_chat_id Secret chat identifier
 */
suspend fun TdKtxClient.closeSecretChat(
    secretChatId: Int,
): Ok {
    val request = CloseSecretChat(secretChatId)
    val requestJson = tdJson.encodeToString(CloseSecretChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a list of service actions taken by chat members and administrators in the last 48 hours. Available only for supergroups and channels. Requires administrator rights. Returns results in reverse chronological order (i.e., in order of decreasing event_id)
 * @param chatId Chat identifier
 * @param query Search query by which to filter events
 * @param fromEventId Identifier of an event from which to return results. Use 0 to get results from the latest events
 * @param limit The maximum number of events to return; up to 100
 * @param filters The types of events to return; pass null to get chat events of all types
 * @param userIds User identifiers by which to filter events. By default, events relating to all users will be returned
 */
suspend fun TdKtxClient.getChatEventLog(
    chatId: Long,
    query: String? = null,
    fromEventId: Long,
    limit: Int,
    filters: ChatEventLogFilters? = null,
    userIds: List<Long>? = null,
): ChatEvents {
    val request = GetChatEventLog(chatId, query, fromEventId, limit, filters, userIds)
    val requestJson = tdJson.encodeToString(GetChatEventLog.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatEvents.serializer(), responseJson)
}

/**
 * Returns the list of supported time zones
 */
suspend fun TdKtxClient.getTimeZones(
): TimeZones {
    val request = GetTimeZones()
    val requestJson = tdJson.encodeToString(GetTimeZones.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TimeZones.serializer(), responseJson)
}

/**
 * Returns an invoice payment form. This method must be called when the user presses inline button of the type inlineKeyboardButtonTypeBuy, or wants to buy access to media in a messagePaidMedia message
 * @param inputInvoice The invoice
 * @param theme Preferred payment form theme; pass null to use the default theme
 */
suspend fun TdKtxClient.getPaymentForm(
    inputInvoice: InputInvoice? = null,
    theme: ThemeParameters? = null,
): PaymentForm {
    val request = GetPaymentForm(inputInvoice, theme)
    val requestJson = tdJson.encodeToString(GetPaymentForm.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PaymentForm.serializer(), responseJson)
}

/**
 * Validates the order information provided by a user and returns the available shipping options for a flexible invoice
 * @param inputInvoice The invoice
 * @param orderInfo The order information, provided by the user; pass null if empty
 * @param allowSave Pass true to save the order information
 */
suspend fun TdKtxClient.validateOrderInfo(
    inputInvoice: InputInvoice? = null,
    orderInfo: OrderInfo? = null,
    allowSave: Boolean,
): ValidatedOrderInfo {
    val request = ValidateOrderInfo(inputInvoice, orderInfo, allowSave)
    val requestJson = tdJson.encodeToString(ValidateOrderInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ValidatedOrderInfo.serializer(), responseJson)
}

/**
 * Sends a filled-out payment form to the bot for final verification
 * @param inputInvoice The invoice
 * @param paymentFormId Payment form identifier returned by getPaymentForm
 * @param orderInfoId Identifier returned by validateOrderInfo, or an empty string
 * @param shippingOptionId Identifier of a chosen shipping option, if applicable
 * @param credentials The credentials chosen by user for payment; pass null for a payment in Telegram Stars
 * @param tipAmount Chosen by the user amount of tip in the smallest units of the currency
 */
suspend fun TdKtxClient.sendPaymentForm(
    inputInvoice: InputInvoice? = null,
    paymentFormId: Long,
    orderInfoId: String? = null,
    shippingOptionId: String? = null,
    credentials: InputCredentials? = null,
    tipAmount: Long,
): PaymentResult {
    val request = SendPaymentForm(inputInvoice, paymentFormId, orderInfoId, shippingOptionId, credentials, tipAmount)
    val requestJson = tdJson.encodeToString(SendPaymentForm.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PaymentResult.serializer(), responseJson)
}

/**
 * Returns information about a successful payment @chat_id Chat identifier of the messagePaymentSuccessful message @message_id Message identifier
 */
suspend fun TdKtxClient.getPaymentReceipt(
    chatId: Long,
    messageId: Long,
): PaymentReceipt {
    val request = GetPaymentReceipt(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetPaymentReceipt.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PaymentReceipt.serializer(), responseJson)
}

/**
 * Returns saved order information. Returns a 404 error if there is no saved order information
 */
suspend fun TdKtxClient.getSavedOrderInfo(
): OrderInfo {
    val request = GetSavedOrderInfo()
    val requestJson = tdJson.encodeToString(GetSavedOrderInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(OrderInfo.serializer(), responseJson)
}

/**
 * Deletes saved order information
 */
suspend fun TdKtxClient.deleteSavedOrderInfo(
): Ok {
    val request = DeleteSavedOrderInfo()
    val requestJson = tdJson.encodeToString(DeleteSavedOrderInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes saved credentials for all payment provider bots
 */
suspend fun TdKtxClient.deleteSavedCredentials(
): Ok {
    val request = DeleteSavedCredentials()
    val requestJson = tdJson.encodeToString(DeleteSavedCredentials.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes settings for gift receiving for the current user @settings The new settings
 */
suspend fun TdKtxClient.setGiftSettings(
    settings: GiftSettings? = null,
): Ok {
    val request = SetGiftSettings(settings)
    val requestJson = tdJson.encodeToString(SetGiftSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns gifts that can be sent to other users and channel chats
 */
suspend fun TdKtxClient.getAvailableGifts(
): AvailableGifts {
    val request = GetAvailableGifts()
    val requestJson = tdJson.encodeToString(GetAvailableGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AvailableGifts.serializer(), responseJson)
}

/**
 * Checks whether a gift with next_send_date in the future can be sent already
 * @param giftId Identifier of the gift to send
 */
suspend fun TdKtxClient.canSendGift(
    giftId: Long,
): CanSendGiftResult {
    val request = CanSendGift(giftId)
    val requestJson = tdJson.encodeToString(CanSendGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CanSendGiftResult.serializer(), responseJson)
}

/**
 * Sends a gift to another user or channel chat. May return an error with a message "STARGIFT_USAGE_LIMITED" if the gift was sold out
 * @param giftId Identifier of the gift to send
 * @param ownerId Identifier of the user or the channel chat that will receive the gift; limited gifts can't be sent to channel chats
 * @param text Text to show along with the gift; 0-getOption("gift_text_length_max") characters. Only Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, and DateTime entities are allowed. Must be empty if the receiver enabled paid messages
 * @param isPrivate Pass true to show gift text and sender only to the gift receiver; otherwise, everyone will be able to see them
 * @param payForUpgrade Pass true to additionally pay for the gift upgrade and allow the receiver to upgrade it for free
 */
suspend fun TdKtxClient.sendGift(
    giftId: Long,
    ownerId: MessageSender? = null,
    text: FormattedText? = null,
    isPrivate: Boolean,
    payForUpgrade: Boolean,
): Ok {
    val request = SendGift(giftId, ownerId, text, isPrivate, payForUpgrade)
    val requestJson = tdJson.encodeToString(SendGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns auction state for a gift @auction_id Unique identifier of the auction
 */
suspend fun TdKtxClient.getGiftAuctionState(
    auctionId: String? = null,
): GiftAuctionState {
    val request = GetGiftAuctionState(auctionId)
    val requestJson = tdJson.encodeToString(GetGiftAuctionState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftAuctionState.serializer(), responseJson)
}

/**
 * Returns the gifts that were acquired by the current user on a gift auction @gift_id Identifier of the auctioned gift
 */
suspend fun TdKtxClient.getGiftAuctionAcquiredGifts(
    giftId: Long,
): GiftAuctionAcquiredGifts {
    val request = GetGiftAuctionAcquiredGifts(giftId)
    val requestJson = tdJson.encodeToString(GetGiftAuctionAcquiredGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftAuctionAcquiredGifts.serializer(), responseJson)
}

/**
 * Informs TDLib that a gift auction was opened by the user @gift_id Identifier of the gift, which auction was opened
 */
suspend fun TdKtxClient.openGiftAuction(
    giftId: Long,
): Ok {
    val request = OpenGiftAuction(giftId)
    val requestJson = tdJson.encodeToString(OpenGiftAuction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that a gift auction was closed by the user @gift_id Identifier of the gift, which auction was closed
 */
suspend fun TdKtxClient.closeGiftAuction(
    giftId: Long,
): Ok {
    val request = CloseGiftAuction(giftId)
    val requestJson = tdJson.encodeToString(CloseGiftAuction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Places a bid on an auction gift
 * @param giftId Identifier of the gift to place the bid on
 * @param starCount The number of Telegram Stars to place in the bid
 * @param userId Identifier of the user who will receive the gift
 * @param text Text to show along with the gift; 0-getOption("gift_text_length_max") characters. Only Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, and DateTime entities are allowed. Must be empty if the receiver enabled paid messages
 * @param isPrivate Pass true to show gift text and sender only to the gift receiver; otherwise, everyone will be able to see them
 */
suspend fun TdKtxClient.placeGiftAuctionBid(
    giftId: Long,
    starCount: Long,
    userId: Long,
    text: FormattedText? = null,
    isPrivate: Boolean,
): Ok {
    val request = PlaceGiftAuctionBid(giftId, starCount, userId, text, isPrivate)
    val requestJson = tdJson.encodeToString(PlaceGiftAuctionBid.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Increases a bid for an auction gift without changing gift text and receiver
 * @param giftId Identifier of the gift to put the bid on
 * @param starCount The number of Telegram Stars to put in the bid
 */
suspend fun TdKtxClient.increaseGiftAuctionBid(
    giftId: Long,
    starCount: Long,
): Ok {
    val request = IncreaseGiftAuctionBid(giftId, starCount)
    val requestJson = tdJson.encodeToString(IncreaseGiftAuctionBid.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sells a gift for Telegram Stars; requires owner privileges for gifts owned by a chat
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request; for bots only
 * @param receivedGiftId Identifier of the gift
 */
suspend fun TdKtxClient.sellGift(
    businessConnectionId: String? = null,
    receivedGiftId: String? = null,
): Ok {
    val request = SellGift(businessConnectionId, receivedGiftId)
    val requestJson = tdJson.encodeToString(SellGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether a gift is shown on the current user's or the channel's profile page; requires can_post_messages administrator right in the channel chat
 * @param receivedGiftId Identifier of the gift
 * @param isSaved Pass true to display the gift on the user's or the channel's profile page; pass false to remove it from the profile page
 */
suspend fun TdKtxClient.toggleGiftIsSaved(
    receivedGiftId: String? = null,
    isSaved: Boolean,
): Ok {
    val request = ToggleGiftIsSaved(receivedGiftId, isSaved)
    val requestJson = tdJson.encodeToString(ToggleGiftIsSaved.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the list of pinned gifts on the current user's or the channel's profile page; requires can_post_messages administrator right in the channel chat
 * @param ownerId Identifier of the user or the channel chat that received the gifts
 * @param receivedGiftIds New list of pinned gifts. All gifts must be upgraded and saved on the profile page first. There can be up to getOption("pinned_gift_count_max") pinned gifts
 */
suspend fun TdKtxClient.setPinnedGifts(
    ownerId: MessageSender? = null,
    receivedGiftIds: List<String>? = null,
): Ok {
    val request = SetPinnedGifts(ownerId, receivedGiftIds)
    val requestJson = tdJson.encodeToString(SetPinnedGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Toggles whether notifications for new gifts received by a channel chat are sent to the current user; requires can_post_messages administrator right in the chat
 * @param chatId Identifier of the channel chat
 * @param areEnabled Pass true to enable notifications about new gifts owned by the channel chat; pass false to disable the notifications
 */
suspend fun TdKtxClient.toggleChatGiftNotifications(
    chatId: Long,
    areEnabled: Boolean,
): Ok {
    val request = ToggleChatGiftNotifications(chatId, areEnabled)
    val requestJson = tdJson.encodeToString(ToggleChatGiftNotifications.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns examples of possible upgraded gifts for a regular gift @regular_gift_id Identifier of the regular gift
 */
suspend fun TdKtxClient.getGiftUpgradePreview(
    regularGiftId: Long,
): GiftUpgradePreview {
    val request = GetGiftUpgradePreview(regularGiftId)
    val requestJson = tdJson.encodeToString(GetGiftUpgradePreview.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftUpgradePreview.serializer(), responseJson)
}

/**
 * Returns all possible variants of upgraded gifts for a regular gift
 * @param regularGiftId Identifier of the regular gift
 * @param returnUpgradeModels Pass true to get models that can be obtained by upgrading a regular gift
 * @param returnCraftModels Pass true to get models that can be obtained by crafting a gift from upgraded gifts
 */
suspend fun TdKtxClient.getUpgradedGiftVariants(
    regularGiftId: Long,
    returnUpgradeModels: Boolean,
    returnCraftModels: Boolean,
): GiftUpgradeVariants {
    val request = GetUpgradedGiftVariants(regularGiftId, returnUpgradeModels, returnCraftModels)
    val requestJson = tdJson.encodeToString(GetUpgradedGiftVariants.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftUpgradeVariants.serializer(), responseJson)
}

/**
 * Upgrades a regular gift
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request; for bots only
 * @param receivedGiftId Identifier of the gift
 * @param keepOriginalDetails Pass true to keep the original gift text, sender and receiver in the upgraded gift
 * @param starCount The Telegram Star amount required to pay for the upgrade. If the gift has prepaid_upgrade_star_count > 0, then pass 0, otherwise, pass gift.upgrade_star_count
 */
suspend fun TdKtxClient.upgradeGift(
    businessConnectionId: String? = null,
    receivedGiftId: String? = null,
    keepOriginalDetails: Boolean,
    starCount: Long,
): UpgradeGiftResult {
    val request = UpgradeGift(businessConnectionId, receivedGiftId, keepOriginalDetails, starCount)
    val requestJson = tdJson.encodeToString(UpgradeGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UpgradeGiftResult.serializer(), responseJson)
}

/**
 * Pays for upgrade of a regular gift that is owned by another user or channel chat
 * @param ownerId Identifier of the user or the channel chat that owns the gift
 * @param prepaidUpgradeHash Prepaid upgrade hash as received along with the gift
 * @param starCount The Telegram Star amount the user agreed to pay for the upgrade; must be equal to gift.upgrade_star_count
 */
suspend fun TdKtxClient.buyGiftUpgrade(
    ownerId: MessageSender? = null,
    prepaidUpgradeHash: String? = null,
    starCount: Long,
): Ok {
    val request = BuyGiftUpgrade(ownerId, prepaidUpgradeHash, starCount)
    val requestJson = tdJson.encodeToString(BuyGiftUpgrade.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Crafts a new gift from other gifts that will be permanently lost
 * @param receivedGiftIds Identifier of the gifts to use for crafting. In the case of a successful craft, the resulting gift will have the number of the first gift. Consequently, the first gift must not have been withdrawn to the TON blockchain as an NFT and must have an empty gift_address
 */
suspend fun TdKtxClient.craftGift(
    receivedGiftIds: List<String>? = null,
): CraftGiftResult {
    val request = CraftGift(receivedGiftIds)
    val requestJson = tdJson.encodeToString(CraftGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CraftGiftResult.serializer(), responseJson)
}

/**
 * Sends an upgraded gift to another user or channel chat
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request; for bots only
 * @param receivedGiftId Identifier of the gift
 * @param newOwnerId Identifier of the user or the channel chat that will receive the gift
 * @param starCount The Telegram Star amount required to pay for the transfer
 */
suspend fun TdKtxClient.transferGift(
    businessConnectionId: String? = null,
    receivedGiftId: String? = null,
    newOwnerId: MessageSender? = null,
    starCount: Long,
): Ok {
    val request = TransferGift(businessConnectionId, receivedGiftId, newOwnerId, starCount)
    val requestJson = tdJson.encodeToString(TransferGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Drops original details for an upgraded gift
 * @param receivedGiftId Identifier of the gift
 * @param starCount The Telegram Star amount required to pay for the operation
 */
suspend fun TdKtxClient.dropGiftOriginalDetails(
    receivedGiftId: String? = null,
    starCount: Long,
): Ok {
    val request = DropGiftOriginalDetails(receivedGiftId, starCount)
    val requestJson = tdJson.encodeToString(DropGiftOriginalDetails.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends an upgraded gift that is available for resale to another user or channel chat; gifts already owned by the current user must be transferred using transferGift and can't be passed to the method
 * @param giftName Name of the upgraded gift to send
 * @param ownerId Identifier of the user or the channel chat that will receive the gift
 * @param price The price that the user agreed to pay for the gift
 */
suspend fun TdKtxClient.sendResoldGift(
    giftName: String? = null,
    ownerId: MessageSender? = null,
    price: GiftResalePrice? = null,
): GiftResaleResult {
    val request = SendResoldGift(giftName, ownerId, price)
    val requestJson = tdJson.encodeToString(SendResoldGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftResaleResult.serializer(), responseJson)
}

/**
 * Sends an offer to purchase an upgraded gift
 * @param ownerId Identifier of the user or the channel chat that currently owns the gift and will receive the offer
 * @param giftName Name of the upgraded gift
 * @param price The price that the user agreed to pay for the gift
 * @param duration Duration of the offer, in seconds; must be one of 21600, 43200, 86400, 129600, 172800, or 259200. Can also be 120 if Telegram test environment is used
 * @param paidMessageStarCount The number of Telegram Stars the user agreed to pay additionally for sending of the offer message to the current gift owner; pass userFullInfo.outgoing_paid_message_star_count for users and 0 otherwise
 */
suspend fun TdKtxClient.sendGiftPurchaseOffer(
    ownerId: MessageSender? = null,
    giftName: String? = null,
    price: GiftResalePrice? = null,
    duration: Int,
    paidMessageStarCount: Long,
): Ok {
    val request = SendGiftPurchaseOffer(ownerId, giftName, price, duration, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(SendGiftPurchaseOffer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Handles a pending gift purchase offer
 * @param messageId Identifier of the message with the gift purchase offer
 * @param accept Pass true to accept the request; pass false to reject it
 */
suspend fun TdKtxClient.processGiftPurchaseOffer(
    messageId: Long,
    accept: Boolean,
): Ok {
    val request = ProcessGiftPurchaseOffer(messageId, accept)
    val requestJson = tdJson.encodeToString(ProcessGiftPurchaseOffer.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns gifts received by the given user or chat
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request; for bots only
 * @param ownerId Identifier of the gift receiver
 * @param collectionId Pass collection identifier to get gifts only from the specified collection; pass 0 to get gifts regardless of collections
 * @param excludeUnsaved Pass true to exclude gifts that aren't saved to the chat's profile page. Always true for gifts received by other users and channel chats without can_post_messages administrator right
 * @param excludeSaved Pass true to exclude gifts that are saved to the chat's profile page. Always false for gifts received by other users and channel chats without can_post_messages administrator right
 * @param excludeUnlimited Pass true to exclude gifts that can be purchased unlimited number of times
 * @param excludeUpgradable Pass true to exclude gifts that can be purchased limited number of times and can be upgraded
 * @param excludeNonUpgradable Pass true to exclude gifts that can be purchased limited number of times and can't be upgraded
 * @param excludeUpgraded Pass true to exclude upgraded gifts
 * @param excludeWithoutColors Pass true to exclude gifts that can't be used in setUpgradedGiftColors
 * @param excludeHosted Pass true to exclude gifts that are just hosted and are not owned by the owner
 * @param sortByPrice Pass true to sort results by gift price instead of send date
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of gifts to be returned; must be positive and can't be greater than 100. For optimal performance, the number of returned objects is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getReceivedGifts(
    businessConnectionId: String? = null,
    ownerId: MessageSender? = null,
    collectionId: Int,
    excludeUnsaved: Boolean,
    excludeSaved: Boolean,
    excludeUnlimited: Boolean,
    excludeUpgradable: Boolean,
    excludeNonUpgradable: Boolean,
    excludeUpgraded: Boolean,
    excludeWithoutColors: Boolean,
    excludeHosted: Boolean,
    sortByPrice: Boolean,
    offset: String? = null,
    limit: Int,
): ReceivedGifts {
    val request = GetReceivedGifts(businessConnectionId, ownerId, collectionId, excludeUnsaved, excludeSaved, excludeUnlimited, excludeUpgradable, excludeNonUpgradable, excludeUpgraded, excludeWithoutColors, excludeHosted, sortByPrice, offset, limit)
    val requestJson = tdJson.encodeToString(GetReceivedGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReceivedGifts.serializer(), responseJson)
}

/**
 * Returns information about a received gift @received_gift_id Identifier of the gift
 */
suspend fun TdKtxClient.getReceivedGift(
    receivedGiftId: String? = null,
): ReceivedGift {
    val request = GetReceivedGift(receivedGiftId)
    val requestJson = tdJson.encodeToString(GetReceivedGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReceivedGift.serializer(), responseJson)
}

/**
 * Returns upgraded gifts of the current user who can be used to craft another gifts
 * @param regularGiftId Identifier of the regular gift that will be used for crafting
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of gifts to be returned; must be positive and can't be greater than 100. For optimal performance, the number of returned objects is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getGiftsForCrafting(
    regularGiftId: Long,
    offset: String? = null,
    limit: Int,
): GiftsForCrafting {
    val request = GetGiftsForCrafting(regularGiftId, offset, limit)
    val requestJson = tdJson.encodeToString(GetGiftsForCrafting.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftsForCrafting.serializer(), responseJson)
}

/**
 * Returns information about an upgraded gift by its name @name Unique name of the upgraded gift
 */
suspend fun TdKtxClient.getUpgradedGift(
    name: String? = null,
): UpgradedGift {
    val request = GetUpgradedGift(name)
    val requestJson = tdJson.encodeToString(GetUpgradedGift.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UpgradedGift.serializer(), responseJson)
}

/**
 * Returns information about value of an upgraded gift by its name @name Unique name of the upgraded gift
 */
suspend fun TdKtxClient.getUpgradedGiftValueInfo(
    name: String? = null,
): UpgradedGiftValueInfo {
    val request = GetUpgradedGiftValueInfo(name)
    val requestJson = tdJson.encodeToString(GetUpgradedGiftValueInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UpgradedGiftValueInfo.serializer(), responseJson)
}

/**
 * Returns a URL for upgraded gift withdrawal in the TON blockchain as an NFT; requires owner privileges for gifts owned by a chat
 * @param receivedGiftId Identifier of the gift
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getUpgradedGiftWithdrawalUrl(
    receivedGiftId: String? = null,
    password: String? = null,
): HttpUrl {
    val request = GetUpgradedGiftWithdrawalUrl(receivedGiftId, password)
    val requestJson = tdJson.encodeToString(GetUpgradedGiftWithdrawalUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns promotional animation for upgraded gifts
 */
suspend fun TdKtxClient.getUpgradedGiftsPromotionalAnimation(
): Animation {
    val request = GetUpgradedGiftsPromotionalAnimation()
    val requestJson = tdJson.encodeToString(GetUpgradedGiftsPromotionalAnimation.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Animation.serializer(), responseJson)
}

/**
 * Changes resale price of a unique gift owned by the current user
 * @param receivedGiftId Identifier of the unique gift
 * @param price The new price for the unique gift; pass null to disallow gift resale. The current user will receive getOption("gift_resale_star_earnings_per_mille") Telegram Stars for each 1000 Telegram Stars paid for the gift if the gift price is in Telegram Stars or getOption("gift_resale_ton_earnings_per_mille") Toncoins for each 1000 Toncoins paid for the gift if the gift price is in Toncoins
 */
suspend fun TdKtxClient.setGiftResalePrice(
    receivedGiftId: String? = null,
    price: GiftResalePrice? = null,
): Ok {
    val request = SetGiftResalePrice(receivedGiftId, price)
    val requestJson = tdJson.encodeToString(SetGiftResalePrice.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns upgraded gifts that can be bought from other owners using sendResoldGift
 * @param giftId Identifier of the regular gift that was upgraded to a unique gift
 * @param order Order in which the results will be sorted
 * @param forCrafting Pass true to get only gifts suitable for crafting
 * @param forStars Pass true to get only gifts that can be bought using Telegram Stars
 * @param attributes Attributes used to filter received gifts. If multiple attributes of the same type are specified, then all of them are allowed. If none attributes of specific type are specified, then all values for this attribute type are allowed
 * @param offset Offset of the first entry to return as received from the previous request with the same order and attributes; use empty string to get the first chunk of results
 * @param limit The maximum number of gifts to return
 */
suspend fun TdKtxClient.searchGiftsForResale(
    giftId: Long,
    order: GiftForResaleOrder? = null,
    forCrafting: Boolean,
    forStars: Boolean,
    attributes: List<UpgradedGiftAttributeId>? = null,
    offset: String? = null,
    limit: Int,
): GiftsForResale {
    val request = SearchGiftsForResale(giftId, order, forCrafting, forStars, attributes, offset, limit)
    val requestJson = tdJson.encodeToString(SearchGiftsForResale.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftsForResale.serializer(), responseJson)
}

/**
 * Returns collections of gifts owned by the given user or chat
 * @param ownerId Identifier of the user or the channel chat that received the gifts
 */
suspend fun TdKtxClient.getGiftCollections(
    ownerId: MessageSender? = null,
): GiftCollections {
    val request = GetGiftCollections(ownerId)
    val requestJson = tdJson.encodeToString(GetGiftCollections.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollections.serializer(), responseJson)
}

/**
 * Creates a collection from gifts on the current user's or a channel's profile page; requires can_post_messages administrator right in the channel chat. An owner can have up to getOption("gift_collection_count_max") gift collections. The new collection will be added to the end of the gift collection list of the owner. Returns the created collection
 * @param ownerId Identifier of the user or the channel chat that received the gifts
 * @param name Name of the collection; 1-12 characters
 * @param receivedGiftIds Identifier of the gifts to add to the collection; 0-getOption("gift_collection_size_max") identifiers
 */
suspend fun TdKtxClient.createGiftCollection(
    ownerId: MessageSender? = null,
    name: String? = null,
    receivedGiftIds: List<String>? = null,
): GiftCollection {
    val request = CreateGiftCollection(ownerId, name, receivedGiftIds)
    val requestJson = tdJson.encodeToString(CreateGiftCollection.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollection.serializer(), responseJson)
}

/**
 * Changes order of gift collections. If the collections are owned by a channel chat, then requires can_post_messages administrator right in the channel chat
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionIds New order of gift collections
 */
suspend fun TdKtxClient.reorderGiftCollections(
    ownerId: MessageSender? = null,
    collectionIds: List<Int>? = null,
): Ok {
    val request = ReorderGiftCollections(ownerId, collectionIds)
    val requestJson = tdJson.encodeToString(ReorderGiftCollections.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes a gift collection. If the collection is owned by a channel chat, then requires can_post_messages administrator right in the channel chat
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionId Identifier of the gift collection
 */
suspend fun TdKtxClient.deleteGiftCollection(
    ownerId: MessageSender? = null,
    collectionId: Int,
): Ok {
    val request = DeleteGiftCollection(ownerId, collectionId)
    val requestJson = tdJson.encodeToString(DeleteGiftCollection.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes name of a gift collection. If the collection is owned by a channel chat, then requires can_post_messages administrator right in the channel chat. Returns the changed collection
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionId Identifier of the gift collection
 * @param name New name of the collection; 1-12 characters
 */
suspend fun TdKtxClient.setGiftCollectionName(
    ownerId: MessageSender? = null,
    collectionId: Int,
    name: String? = null,
): GiftCollection {
    val request = SetGiftCollectionName(ownerId, collectionId, name)
    val requestJson = tdJson.encodeToString(SetGiftCollectionName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollection.serializer(), responseJson)
}

/**
 * Adds gifts to the beginning of a previously created collection. If the collection is owned by a channel chat, then requires can_post_messages administrator right in the channel chat. Returns the changed collection
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionId Identifier of the gift collection
 * @param receivedGiftIds Identifier of the gifts to add to the collection; 1-getOption("gift_collection_size_max") identifiers. If after addition the collection has more than getOption("gift_collection_size_max") gifts, then the last one are removed from the collection
 */
suspend fun TdKtxClient.addGiftCollectionGifts(
    ownerId: MessageSender? = null,
    collectionId: Int,
    receivedGiftIds: List<String>? = null,
): GiftCollection {
    val request = AddGiftCollectionGifts(ownerId, collectionId, receivedGiftIds)
    val requestJson = tdJson.encodeToString(AddGiftCollectionGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollection.serializer(), responseJson)
}

/**
 * Removes gifts from a collection. If the collection is owned by a channel chat, then requires can_post_messages administrator right in the channel chat. Returns the changed collection
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionId Identifier of the gift collection
 * @param receivedGiftIds Identifier of the gifts to remove from the collection
 */
suspend fun TdKtxClient.removeGiftCollectionGifts(
    ownerId: MessageSender? = null,
    collectionId: Int,
    receivedGiftIds: List<String>? = null,
): GiftCollection {
    val request = RemoveGiftCollectionGifts(ownerId, collectionId, receivedGiftIds)
    val requestJson = tdJson.encodeToString(RemoveGiftCollectionGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollection.serializer(), responseJson)
}

/**
 * Changes order of gifts in a collection. If the collection is owned by a channel chat, then requires can_post_messages administrator right in the channel chat. Returns the changed collection
 * @param ownerId Identifier of the user or the channel chat that owns the collection
 * @param collectionId Identifier of the gift collection
 * @param receivedGiftIds Identifier of the gifts to move to the beginning of the collection. All other gifts are placed in the current order after the specified gifts
 */
suspend fun TdKtxClient.reorderGiftCollectionGifts(
    ownerId: MessageSender? = null,
    collectionId: Int,
    receivedGiftIds: List<String>? = null,
): GiftCollection {
    val request = ReorderGiftCollectionGifts(ownerId, collectionId, receivedGiftIds)
    val requestJson = tdJson.encodeToString(ReorderGiftCollectionGifts.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiftCollection.serializer(), responseJson)
}

/**
 * Creates a link for the given invoice; for bots only
 * @param businessConnectionId Unique identifier of business connection on behalf of which to send the request
 * @param invoice Information about the invoice of the type inputMessageInvoice
 */
suspend fun TdKtxClient.createInvoiceLink(
    businessConnectionId: String? = null,
    invoice: InputMessageContent? = null,
): HttpUrl {
    val request = CreateInvoiceLink(businessConnectionId, invoice)
    val requestJson = tdJson.encodeToString(CreateInvoiceLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Refunds a previously done payment in Telegram Stars; for bots only
 * @param userId Identifier of the user who did the payment
 * @param telegramPaymentChargeId Telegram payment identifier
 */
suspend fun TdKtxClient.refundStarPayment(
    userId: Long,
    telegramPaymentChargeId: String? = null,
): Ok {
    val request = RefundStarPayment(userId, telegramPaymentChargeId)
    val requestJson = tdJson.encodeToString(RefundStarPayment.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a user who can be contacted to get support
 */
suspend fun TdKtxClient.getSupportUser(
): User {
    val request = GetSupportUser()
    val requestJson = tdJson.encodeToString(GetSupportUser.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(User.serializer(), responseJson)
}

/**
 * Constructs a persistent HTTP URL for a background @name Background name @type Background type; backgroundTypeChatTheme isn't supported
 */
suspend fun TdKtxClient.getBackgroundUrl(
    name: String? = null,
    type: BackgroundType? = null,
): HttpUrl {
    val request = GetBackgroundUrl(name, type)
    val requestJson = tdJson.encodeToString(GetBackgroundUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Searches for a background by its name @name The name of the background
 */
suspend fun TdKtxClient.searchBackground(
    name: String? = null,
): Background {
    val request = SearchBackground(name)
    val requestJson = tdJson.encodeToString(SearchBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Background.serializer(), responseJson)
}

/**
 * Sets default background for chats; adds the background to the list of installed backgrounds
 * @param background The input background to use; pass null to create a new filled background
 * @param type Background type; pass null to use the default type of the remote background; backgroundTypeChatTheme isn't supported
 * @param forDarkTheme Pass true if the background is set for a dark theme
 */
suspend fun TdKtxClient.setDefaultBackground(
    background: InputBackground? = null,
    type: BackgroundType? = null,
    forDarkTheme: Boolean,
): Background {
    val request = SetDefaultBackground(background, type, forDarkTheme)
    val requestJson = tdJson.encodeToString(SetDefaultBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Background.serializer(), responseJson)
}

/**
 * Deletes default background for chats @for_dark_theme Pass true if the background is deleted for a dark theme
 */
suspend fun TdKtxClient.deleteDefaultBackground(
    forDarkTheme: Boolean,
): Ok {
    val request = DeleteDefaultBackground(forDarkTheme)
    val requestJson = tdJson.encodeToString(DeleteDefaultBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns backgrounds installed by the user @for_dark_theme Pass true to order returned backgrounds for a dark theme
 */
suspend fun TdKtxClient.getInstalledBackgrounds(
    forDarkTheme: Boolean,
): Backgrounds {
    val request = GetInstalledBackgrounds(forDarkTheme)
    val requestJson = tdJson.encodeToString(GetInstalledBackgrounds.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Backgrounds.serializer(), responseJson)
}

/**
 * Removes background from the list of installed backgrounds @background_id The background identifier
 */
suspend fun TdKtxClient.removeInstalledBackground(
    backgroundId: Long,
): Ok {
    val request = RemoveInstalledBackground(backgroundId)
    val requestJson = tdJson.encodeToString(RemoveInstalledBackground.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resets list of installed backgrounds to its default value
 */
suspend fun TdKtxClient.resetInstalledBackgrounds(
): Ok {
    val request = ResetInstalledBackgrounds()
    val requestJson = tdJson.encodeToString(ResetInstalledBackgrounds.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about the current localization target. This is an offline method if only_local is true. Can be called before authorization @only_local Pass true to get only locally available information without sending network requests
 */
suspend fun TdKtxClient.getLocalizationTargetInfo(
    onlyLocal: Boolean,
): LocalizationTargetInfo {
    val request = GetLocalizationTargetInfo(onlyLocal)
    val requestJson = tdJson.encodeToString(GetLocalizationTargetInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LocalizationTargetInfo.serializer(), responseJson)
}

/**
 * Returns information about a language pack. Returned language pack identifier may be different from a provided one. Can be called before authorization @language_pack_id Language pack identifier
 */
suspend fun TdKtxClient.getLanguagePackInfo(
    languagePackId: String? = null,
): LanguagePackInfo {
    val request = GetLanguagePackInfo(languagePackId)
    val requestJson = tdJson.encodeToString(GetLanguagePackInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LanguagePackInfo.serializer(), responseJson)
}

/**
 * Returns strings from a language pack in the current localization target by their keys. Can be called before authorization
 * @param languagePackId Language pack identifier of the strings to be returned
 * @param keys Language pack keys of the strings to be returned; leave empty to request all available strings
 */
suspend fun TdKtxClient.getLanguagePackStrings(
    languagePackId: String? = null,
    keys: List<String>? = null,
): LanguagePackStrings {
    val request = GetLanguagePackStrings(languagePackId, keys)
    val requestJson = tdJson.encodeToString(GetLanguagePackStrings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LanguagePackStrings.serializer(), responseJson)
}

/**
 * Fetches the latest versions of all strings from a language pack in the current localization target from the server. This method doesn't need to be called explicitly for the current used/base language packs. Can be called before authorization
 * @param languagePackId Language pack identifier
 */
suspend fun TdKtxClient.synchronizeLanguagePack(
    languagePackId: String? = null,
): Ok {
    val request = SynchronizeLanguagePack(languagePackId)
    val requestJson = tdJson.encodeToString(SynchronizeLanguagePack.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a custom server language pack to the list of installed language packs in current localization target. Can be called before authorization @language_pack_id Identifier of a language pack to be added
 */
suspend fun TdKtxClient.addCustomServerLanguagePack(
    languagePackId: String? = null,
): Ok {
    val request = AddCustomServerLanguagePack(languagePackId)
    val requestJson = tdJson.encodeToString(AddCustomServerLanguagePack.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds or changes a custom local language pack to the current localization target
 * @param info Information about the language pack. Language pack identifier must start with 'X', consist only of English letters, digits and hyphens, and must not exceed 64 characters. Can be called before authorization
 * @param strings Strings of the new language pack
 */
suspend fun TdKtxClient.setCustomLanguagePack(
    info: LanguagePackInfo? = null,
    strings: List<LanguagePackString>? = null,
): Ok {
    val request = SetCustomLanguagePack(info, strings)
    val requestJson = tdJson.encodeToString(SetCustomLanguagePack.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Edits information about a custom local language pack in the current localization target. Can be called before authorization @info New information about the custom local language pack
 */
suspend fun TdKtxClient.editCustomLanguagePackInfo(
    info: LanguagePackInfo? = null,
): Ok {
    val request = EditCustomLanguagePackInfo(info)
    val requestJson = tdJson.encodeToString(EditCustomLanguagePackInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds, edits or deletes a string in a custom local language pack. Can be called before authorization @language_pack_id Identifier of a previously added custom local language pack in the current localization target @new_string New language pack string
 */
suspend fun TdKtxClient.setCustomLanguagePackString(
    languagePackId: String? = null,
    newString: LanguagePackString? = null,
): Ok {
    val request = SetCustomLanguagePackString(languagePackId, newString)
    val requestJson = tdJson.encodeToString(SetCustomLanguagePackString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Deletes all information about a language pack in the current localization target. The language pack which is currently in use (including base language pack) or is being synchronized can't be deleted. Can be called before authorization
 * @param languagePackId Identifier of the language pack to delete
 */
suspend fun TdKtxClient.deleteLanguagePack(
    languagePackId: String? = null,
): Ok {
    val request = DeleteLanguagePack(languagePackId)
    val requestJson = tdJson.encodeToString(DeleteLanguagePack.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Registers the currently used device for receiving push notifications. Returns a globally unique identifier of the push notification subscription @device_token Device token @other_user_ids List of user identifiers of other users currently using the application
 */
suspend fun TdKtxClient.registerDevice(
    deviceToken: DeviceToken? = null,
    otherUserIds: List<Long>? = null,
): PushReceiverId {
    val request = RegisterDevice(deviceToken, otherUserIds)
    val requestJson = tdJson.encodeToString(RegisterDevice.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PushReceiverId.serializer(), responseJson)
}

/**
 * Handles a push notification. Returns error with code 406 if the push notification is not supported and connection to the server is required to fetch new data. Can be called before authorization
 * @param payload JSON-encoded push notification payload with all fields sent by the server, and "google.sent_time" and "google.notification.sound" fields added
 */
suspend fun TdKtxClient.processPushNotification(
    payload: String? = null,
): Ok {
    val request = ProcessPushNotification(payload)
    val requestJson = tdJson.encodeToString(ProcessPushNotification.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a globally unique push notification subscription identifier for identification of an account, which has received a push notification. Can be called synchronously @payload JSON-encoded push notification payload
 */
suspend fun TdKtxClient.getPushReceiverId(
    payload: String? = null,
): PushReceiverId {
    val request = GetPushReceiverId(payload)
    val requestJson = tdJson.encodeToString(GetPushReceiverId.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PushReceiverId.serializer(), responseJson)
}

/**
 * Returns t.me URLs recently visited by a newly registered user @referrer Google Play referrer to identify the user
 */
suspend fun TdKtxClient.getRecentlyVisitedTMeUrls(
    referrer: String? = null,
): TMeUrls {
    val request = GetRecentlyVisitedTMeUrls(referrer)
    val requestJson = tdJson.encodeToString(GetRecentlyVisitedTMeUrls.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TMeUrls.serializer(), responseJson)
}

/**
 * Changes user privacy settings @setting The privacy setting @rules The new privacy rules
 */
suspend fun TdKtxClient.setUserPrivacySettingRules(
    setting: UserPrivacySetting? = null,
    rules: UserPrivacySettingRules? = null,
): Ok {
    val request = SetUserPrivacySettingRules(setting, rules)
    val requestJson = tdJson.encodeToString(SetUserPrivacySettingRules.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the current privacy settings @setting The privacy setting
 */
suspend fun TdKtxClient.getUserPrivacySettingRules(
    setting: UserPrivacySetting? = null,
): UserPrivacySettingRules {
    val request = GetUserPrivacySettingRules(setting)
    val requestJson = tdJson.encodeToString(GetUserPrivacySettingRules.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UserPrivacySettingRules.serializer(), responseJson)
}

/**
 * Changes privacy settings for message read date @settings New settings
 */
suspend fun TdKtxClient.setReadDatePrivacySettings(
    settings: ReadDatePrivacySettings? = null,
): Ok {
    val request = SetReadDatePrivacySettings(settings)
    val requestJson = tdJson.encodeToString(SetReadDatePrivacySettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns privacy settings for message read date
 */
suspend fun TdKtxClient.getReadDatePrivacySettings(
): ReadDatePrivacySettings {
    val request = GetReadDatePrivacySettings()
    val requestJson = tdJson.encodeToString(GetReadDatePrivacySettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReadDatePrivacySettings.serializer(), responseJson)
}

/**
 * Changes privacy settings for new chat creation; can be used only if getOption("can_set_new_chat_privacy_settings") @settings New settings
 */
suspend fun TdKtxClient.setNewChatPrivacySettings(
    settings: NewChatPrivacySettings? = null,
): Ok {
    val request = SetNewChatPrivacySettings(settings)
    val requestJson = tdJson.encodeToString(SetNewChatPrivacySettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns privacy settings for new chat creation
 */
suspend fun TdKtxClient.getNewChatPrivacySettings(
): NewChatPrivacySettings {
    val request = GetNewChatPrivacySettings()
    val requestJson = tdJson.encodeToString(GetNewChatPrivacySettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(NewChatPrivacySettings.serializer(), responseJson)
}

/**
 * Returns the total number of Telegram Stars received by the current user for paid messages from the given user @user_id Identifier of the user
 */
suspend fun TdKtxClient.getPaidMessageRevenue(
    userId: Long,
): StarCount {
    val request = GetPaidMessageRevenue(userId)
    val requestJson = tdJson.encodeToString(GetPaidMessageRevenue.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarCount.serializer(), responseJson)
}

/**
 * Allows the specified user to send unpaid private messages to the current user by adding a rule to userPrivacySettingAllowUnpaidMessages
 * @param userId Identifier of the user
 * @param refundPayments Pass true to refund the user previously paid messages
 */
suspend fun TdKtxClient.allowUnpaidMessagesFromUser(
    userId: Long,
    refundPayments: Boolean,
): Ok {
    val request = AllowUnpaidMessagesFromUser(userId, refundPayments)
    val requestJson = tdJson.encodeToString(AllowUnpaidMessagesFromUser.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the Telegram Star amount that must be paid to send a message to a supergroup chat; requires can_restrict_members administrator right and supergroupFullInfo.can_enable_paid_messages
 * @param chatId Identifier of the supergroup chat
 * @param paidMessageStarCount The new number of Telegram Stars that must be paid for each message that is sent to the supergroup chat unless the sender is an administrator of the chat; 0-getOption("paid_message_star_count_max"). The supergroup will receive getOption("paid_message_earnings_per_mille") Telegram Stars for each 1000 Telegram Stars paid for message sending
 */
suspend fun TdKtxClient.setChatPaidMessageStarCount(
    chatId: Long,
    paidMessageStarCount: Long,
): Ok {
    val request = SetChatPaidMessageStarCount(chatId, paidMessageStarCount)
    val requestJson = tdJson.encodeToString(SetChatPaidMessageStarCount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Checks whether the current user can message another user or try to create a chat with them
 * @param userId Identifier of the other user
 * @param onlyLocal Pass true to get only locally available information without sending network requests
 */
suspend fun TdKtxClient.canSendMessageToUser(
    userId: Long,
    onlyLocal: Boolean,
): CanSendMessageToUserResult {
    val request = CanSendMessageToUser(userId, onlyLocal)
    val requestJson = tdJson.encodeToString(CanSendMessageToUser.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CanSendMessageToUserResult.serializer(), responseJson)
}

/**
 * Returns the value of an option by its name. (Check the list of available options on https://core.telegram.org/tdlib/options.) Can be called before authorization. Can be called synchronously for options "version" and "commit_hash"
 * @param name The name of the option
 */
suspend fun TdKtxClient.getOption(
    name: String? = null,
): OptionValue {
    val request = GetOption(name)
    val requestJson = tdJson.encodeToString(GetOption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(OptionValue.serializer(), responseJson)
}

/**
 * Sets the value of an option. (Check the list of available options on https://core.telegram.org/tdlib/options.) Only writable options can be set. Can be called before authorization
 * @param name The name of the option
 * @param value The new value of the option; pass null to reset option value to a default value
 */
suspend fun TdKtxClient.setOption(
    name: String? = null,
    value: OptionValue? = null,
): Ok {
    val request = SetOption(name, value)
    val requestJson = tdJson.encodeToString(SetOption.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the period of inactivity after which the account of the current user will automatically be deleted @ttl New account TTL
 */
suspend fun TdKtxClient.setAccountTtl(
    ttl: AccountTtl? = null,
): Ok {
    val request = SetAccountTtl(ttl)
    val requestJson = tdJson.encodeToString(SetAccountTtl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the period of inactivity after which the account of the current user will automatically be deleted
 */
suspend fun TdKtxClient.getAccountTtl(
): AccountTtl {
    val request = GetAccountTtl()
    val requestJson = tdJson.encodeToString(GetAccountTtl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AccountTtl.serializer(), responseJson)
}

/**
 * Deletes the account of the current user, deleting all information associated with the user from the server. The phone number of the account can be used to create a new account. Can be called before authorization when the current authorization state is authorizationStateWaitPassword
 * @param reason The reason why the account was deleted; optional
 * @param password The 2-step verification password of the current user. If the current user isn't authorized, then an empty string can be passed and account deletion can be canceled within one week
 */
suspend fun TdKtxClient.deleteAccount(
    reason: String? = null,
    password: String? = null,
): Ok {
    val request = DeleteAccount(reason, password)
    val requestJson = tdJson.encodeToString(DeleteAccount.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the default message auto-delete time for new chats @message_auto_delete_time New default message auto-delete time; must be from 0 up to 365 * 86400 and be divisible by 86400. If 0, then messages aren't deleted automatically
 */
suspend fun TdKtxClient.setDefaultMessageAutoDeleteTime(
    messageAutoDeleteTime: MessageAutoDeleteTime? = null,
): Ok {
    val request = SetDefaultMessageAutoDeleteTime(messageAutoDeleteTime)
    val requestJson = tdJson.encodeToString(SetDefaultMessageAutoDeleteTime.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns default message auto-delete time setting for new chats
 */
suspend fun TdKtxClient.getDefaultMessageAutoDeleteTime(
): MessageAutoDeleteTime {
    val request = GetDefaultMessageAutoDeleteTime()
    val requestJson = tdJson.encodeToString(GetDefaultMessageAutoDeleteTime.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageAutoDeleteTime.serializer(), responseJson)
}

/**
 * Removes a chat action bar without any other action @chat_id Chat identifier
 */
suspend fun TdKtxClient.removeChatActionBar(
    chatId: Long,
): Ok {
    val request = RemoveChatActionBar(chatId)
    val requestJson = tdJson.encodeToString(RemoveChatActionBar.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports a chat to the Telegram moderators. A chat can be reported only from the chat action bar, or if chat.can_be_reported
 * @param chatId Chat identifier
 * @param optionId Option identifier chosen by the user; leave empty for the initial request
 * @param messageIds Identifiers of reported messages. Use messageProperties.can_report_chat to check whether the message can be reported
 * @param text Additional report details if asked by the server; 0-1024 characters; leave empty for the initial request
 */
suspend fun TdKtxClient.reportChat(
    chatId: Long,
    optionId: String? = null,
    messageIds: List<Long>? = null,
    text: String? = null,
): ReportChatResult {
    val request = ReportChat(chatId, optionId, messageIds, text)
    val requestJson = tdJson.encodeToString(ReportChat.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ReportChatResult.serializer(), responseJson)
}

/**
 * Reports a chat photo to the Telegram moderators. A chat photo can be reported only if chat.can_be_reported
 * @param chatId Chat identifier
 * @param fileId Identifier of the photo to report. Only full photos from chatPhoto can be reported
 * @param reason The reason for reporting the chat photo
 * @param text Additional report details; 0-1024 characters
 */
suspend fun TdKtxClient.reportChatPhoto(
    chatId: Long,
    fileId: Int,
    reason: ReportReason? = null,
    text: String? = null,
): Ok {
    val request = ReportChatPhoto(chatId, fileId, reason, text)
    val requestJson = tdJson.encodeToString(ReportChatPhoto.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reports reactions set on a message to the Telegram moderators. Reactions on a message can be reported only if messageProperties.can_report_reactions
 * @param chatId Chat identifier
 * @param messageId Message identifier
 * @param senderId Identifier of the sender, which added the reaction
 */
suspend fun TdKtxClient.reportMessageReactions(
    chatId: Long,
    messageId: Long,
    senderId: MessageSender? = null,
): Ok {
    val request = ReportMessageReactions(chatId, messageId, senderId)
    val requestJson = tdJson.encodeToString(ReportMessageReactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns detailed revenue statistics about a chat. Currently, this method can be used only for channels if supergroupFullInfo.can_get_revenue_statistics == true or bots if userFullInfo.bot_info.can_get_revenue_statistics == true
 * @param chatId Chat identifier
 * @param isDark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getChatRevenueStatistics(
    chatId: Long,
    isDark: Boolean,
): ChatRevenueStatistics {
    val request = GetChatRevenueStatistics(chatId, isDark)
    val requestJson = tdJson.encodeToString(GetChatRevenueStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatRevenueStatistics.serializer(), responseJson)
}

/**
 * Returns a URL for chat revenue withdrawal; requires owner privileges in the channel chat or the bot. Currently, this method can be used only if getOption("can_withdraw_chat_revenue") for channels with supergroupFullInfo.can_get_revenue_statistics == true or bots with userFullInfo.bot_info.can_get_revenue_statistics == true
 * @param chatId Chat identifier
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getChatRevenueWithdrawalUrl(
    chatId: Long,
    password: String? = null,
): HttpUrl {
    val request = GetChatRevenueWithdrawalUrl(chatId, password)
    val requestJson = tdJson.encodeToString(GetChatRevenueWithdrawalUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns the list of revenue transactions for a chat. Currently, this method can be used only for channels if supergroupFullInfo.can_get_revenue_statistics == true or bots if userFullInfo.bot_info.can_get_revenue_statistics == true
 * @param chatId Chat identifier
 * @param offset Offset of the first transaction to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of transactions to be returned; up to 100
 */
suspend fun TdKtxClient.getChatRevenueTransactions(
    chatId: Long,
    offset: String? = null,
    limit: Int,
): ChatRevenueTransactions {
    val request = GetChatRevenueTransactions(chatId, offset, limit)
    val requestJson = tdJson.encodeToString(GetChatRevenueTransactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatRevenueTransactions.serializer(), responseJson)
}

/**
 * Returns the list of Toncoin transactions of the current user
 * @param direction Direction of the transactions to receive; pass null to get all transactions
 * @param offset Offset of the first transaction to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of transactions to return
 */
suspend fun TdKtxClient.getTonTransactions(
    direction: TransactionDirection? = null,
    offset: String? = null,
    limit: Int,
): TonTransactions {
    val request = GetTonTransactions(direction, offset, limit)
    val requestJson = tdJson.encodeToString(GetTonTransactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TonTransactions.serializer(), responseJson)
}

/**
 * Returns detailed Telegram Star revenue statistics
 * @param ownerId Identifier of the owner of the Telegram Stars; can be identifier of the current user, an owned bot, or a supergroup or a channel chat with supergroupFullInfo.can_get_star_revenue_statistics == true
 * @param isDark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getStarRevenueStatistics(
    ownerId: MessageSender? = null,
    isDark: Boolean,
): StarRevenueStatistics {
    val request = GetStarRevenueStatistics(ownerId, isDark)
    val requestJson = tdJson.encodeToString(GetStarRevenueStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarRevenueStatistics.serializer(), responseJson)
}

/**
 * Returns a URL for Telegram Star withdrawal
 * @param ownerId Identifier of the owner of the Telegram Stars; can be identifier of the current user, an owned bot, or an owned supergroup or channel chat
 * @param starCount The number of Telegram Stars to withdraw; must be between getOption("star_withdrawal_count_min") and getOption("star_withdrawal_count_max")
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getStarWithdrawalUrl(
    ownerId: MessageSender? = null,
    starCount: Long,
    password: String? = null,
): HttpUrl {
    val request = GetStarWithdrawalUrl(ownerId, starCount, password)
    val requestJson = tdJson.encodeToString(GetStarWithdrawalUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns a URL for a Telegram Ad platform account that can be used to set up advertisements for the chat paid in the owned Telegram Stars
 * @param ownerId Identifier of the owner of the Telegram Stars; can be identifier of an owned bot, or identifier of an owned channel chat
 */
suspend fun TdKtxClient.getStarAdAccountUrl(
    ownerId: MessageSender? = null,
): HttpUrl {
    val request = GetStarAdAccountUrl(ownerId)
    val requestJson = tdJson.encodeToString(GetStarAdAccountUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns detailed Toncoin revenue statistics of the current user @is_dark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getTonRevenueStatistics(
    isDark: Boolean,
): TonRevenueStatistics {
    val request = GetTonRevenueStatistics(isDark)
    val requestJson = tdJson.encodeToString(GetTonRevenueStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TonRevenueStatistics.serializer(), responseJson)
}

/**
 * Returns a URL for Toncoin withdrawal from the current user's account. The user must have at least 10 toncoins to withdraw and can withdraw up to 100000 Toncoins in one transaction
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getTonWithdrawalUrl(
    password: String? = null,
): HttpUrl {
    val request = GetTonWithdrawalUrl(password)
    val requestJson = tdJson.encodeToString(GetTonWithdrawalUrl.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Returns detailed statistics about a chat. Currently, this method can be used only for supergroups and channels. Can be used only if supergroupFullInfo.can_get_statistics == true @chat_id Chat identifier @is_dark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getChatStatistics(
    chatId: Long,
    isDark: Boolean,
): ChatStatistics {
    val request = GetChatStatistics(chatId, isDark)
    val requestJson = tdJson.encodeToString(GetChatStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ChatStatistics.serializer(), responseJson)
}

/**
 * Returns detailed statistics about a message. Can be used only if messageProperties.can_get_statistics == true @chat_id Chat identifier @message_id Message identifier @is_dark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getMessageStatistics(
    chatId: Long,
    messageId: Long,
    isDark: Boolean,
): MessageStatistics {
    val request = GetMessageStatistics(chatId, messageId, isDark)
    val requestJson = tdJson.encodeToString(GetMessageStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(MessageStatistics.serializer(), responseJson)
}

/**
 * Returns forwarded copies of a channel message to different public channels and public reposts as a story. Can be used only if messageProperties.can_get_statistics == true. For optimal performance, the number of returned messages and stories is chosen by TDLib
 * @param chatId Chat identifier of the message
 * @param messageId Message identifier
 * @param offset Offset of the first entry to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of messages and stories to be returned; must be positive and can't be greater than 100. For optimal performance, the number of returned objects is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getMessagePublicForwards(
    chatId: Long,
    messageId: Long,
    offset: String? = null,
    limit: Int,
): PublicForwards {
    val request = GetMessagePublicForwards(chatId, messageId, offset, limit)
    val requestJson = tdJson.encodeToString(GetMessagePublicForwards.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PublicForwards.serializer(), responseJson)
}

/**
 * Returns detailed statistics about a story. Can be used only if story.can_get_statistics == true @chat_id Chat identifier @story_id Story identifier @is_dark Pass true if a dark theme is used by the application
 */
suspend fun TdKtxClient.getStoryStatistics(
    chatId: Long,
    storyId: Int,
    isDark: Boolean,
): StoryStatistics {
    val request = GetStoryStatistics(chatId, storyId, isDark)
    val requestJson = tdJson.encodeToString(GetStoryStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StoryStatistics.serializer(), responseJson)
}

/**
 * Loads an asynchronous or a zoomed in statistical graph @chat_id Chat identifier @token The token for graph loading @x X-value for zoomed in graph or 0 otherwise
 */
suspend fun TdKtxClient.getStatisticalGraph(
    chatId: Long,
    token: String? = null,
    x: Long,
): StatisticalGraph {
    val request = GetStatisticalGraph(chatId, token, x)
    val requestJson = tdJson.encodeToString(GetStatisticalGraph.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StatisticalGraph.serializer(), responseJson)
}

/**
 * Returns storage usage statistics. Can be called before authorization
 * @param chatLimit The maximum number of chats with the largest storage usage for which separate statistics need to be returned. All other chats will be grouped in entries with chat_id == 0. If the chat info database is not used, the chat_limit is ignored and is always set to 0
 */
suspend fun TdKtxClient.getStorageStatistics(
    chatLimit: Int,
): StorageStatistics {
    val request = GetStorageStatistics(chatLimit)
    val requestJson = tdJson.encodeToString(GetStorageStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StorageStatistics.serializer(), responseJson)
}

/**
 * Quickly returns approximate storage usage statistics. Can be called before authorization
 */
suspend fun TdKtxClient.getStorageStatisticsFast(
): StorageStatisticsFast {
    val request = GetStorageStatisticsFast()
    val requestJson = tdJson.encodeToString(GetStorageStatisticsFast.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StorageStatisticsFast.serializer(), responseJson)
}

/**
 * Returns database statistics
 */
suspend fun TdKtxClient.getDatabaseStatistics(
): DatabaseStatistics {
    val request = GetDatabaseStatistics()
    val requestJson = tdJson.encodeToString(GetDatabaseStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(DatabaseStatistics.serializer(), responseJson)
}

/**
 * Optimizes storage usage, i.e. deletes some files and returns new storage usage statistics. Secret thumbnails can't be deleted
 * @param size Limit on the total size of files after deletion, in bytes. Pass -1 to use the default limit
 * @param ttl Limit on the time that has passed since the last time a file was accessed (or creation time for some filesystems). Pass -1 to use the default limit
 * @param count Limit on the total number of files after deletion. Pass -1 to use the default limit
 * @param immunityDelay The amount of time after the creation of a file during which it can't be deleted, in seconds. Pass -1 to use the default value
 * @param fileTypes If non-empty, only files with the given types are considered. By default, all types except thumbnails, profile photos, stickers and wallpapers are deleted
 * @param chatIds If non-empty, only files from the given chats are considered. Use 0 as chat identifier to delete files not belonging to any chat (e.g., profile photos)
 * @param excludeChatIds If non-empty, files from the given chats are excluded. Use 0 as chat identifier to exclude all files not belonging to any chat (e.g., profile photos)
 * @param returnDeletedFileStatistics Pass true if statistics about the files that were deleted must be returned instead of the whole storage usage statistics. Affects only returned statistics
 * @param chatLimit Same as in getStorageStatistics. Affects only returned statistics
 */
suspend fun TdKtxClient.optimizeStorage(
    size: Long,
    ttl: Int,
    count: Int,
    immunityDelay: Int,
    fileTypes: List<FileType>? = null,
    chatIds: List<Long>? = null,
    excludeChatIds: List<Long>? = null,
    returnDeletedFileStatistics: Boolean,
    chatLimit: Int,
): StorageStatistics {
    val request = OptimizeStorage(size, ttl, count, immunityDelay, fileTypes, chatIds, excludeChatIds, returnDeletedFileStatistics, chatLimit)
    val requestJson = tdJson.encodeToString(OptimizeStorage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StorageStatistics.serializer(), responseJson)
}

/**
 * Sets the current network type. Can be called before authorization. Calling this method forces all network connections to reopen, mitigating the delay in switching between different networks, so it must be called whenever the network is changed, even if the network type remains the same. Network type is used to check whether the library can use the network at all and also for collecting detailed network data usage statistics
 * @param type The new network type; pass null to set network type to networkTypeOther
 */
suspend fun TdKtxClient.setNetworkType(
    type: NetworkType? = null,
): Ok {
    val request = SetNetworkType(type)
    val requestJson = tdJson.encodeToString(SetNetworkType.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns network data usage statistics. Can be called before authorization @only_current Pass true to get statistics only for the current library launch
 */
suspend fun TdKtxClient.getNetworkStatistics(
    onlyCurrent: Boolean,
): NetworkStatistics {
    val request = GetNetworkStatistics(onlyCurrent)
    val requestJson = tdJson.encodeToString(GetNetworkStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(NetworkStatistics.serializer(), responseJson)
}

/**
 * Adds the specified data to data usage statistics. Can be called before authorization @entry The network statistics entry with the data to be added to statistics
 */
suspend fun TdKtxClient.addNetworkStatistics(
    entry: NetworkStatisticsEntry? = null,
): Ok {
    val request = AddNetworkStatistics(entry)
    val requestJson = tdJson.encodeToString(AddNetworkStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Resets all network data usage statistics to zero. Can be called before authorization
 */
suspend fun TdKtxClient.resetNetworkStatistics(
): Ok {
    val request = ResetNetworkStatistics()
    val requestJson = tdJson.encodeToString(ResetNetworkStatistics.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns auto-download settings presets for the current user
 */
suspend fun TdKtxClient.getAutoDownloadSettingsPresets(
): AutoDownloadSettingsPresets {
    val request = GetAutoDownloadSettingsPresets()
    val requestJson = tdJson.encodeToString(GetAutoDownloadSettingsPresets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AutoDownloadSettingsPresets.serializer(), responseJson)
}

/**
 * Sets auto-download settings @settings New user auto-download settings @type Type of the network for which the new settings are relevant
 */
suspend fun TdKtxClient.setAutoDownloadSettings(
    settings: AutoDownloadSettings? = null,
    type: NetworkType? = null,
): Ok {
    val request = SetAutoDownloadSettings(settings, type)
    val requestJson = tdJson.encodeToString(SetAutoDownloadSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns autosave settings for the current user
 */
suspend fun TdKtxClient.getAutosaveSettings(
): AutosaveSettings {
    val request = GetAutosaveSettings()
    val requestJson = tdJson.encodeToString(GetAutosaveSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AutosaveSettings.serializer(), responseJson)
}

/**
 * Sets autosave settings for the given scope. The method is guaranteed to work only after at least one call to getAutosaveSettings @scope Autosave settings scope @settings New autosave settings for the scope; pass null to set autosave settings to default
 */
suspend fun TdKtxClient.setAutosaveSettings(
    scope: AutosaveSettingsScope? = null,
    settings: ScopeAutosaveSettings? = null,
): Ok {
    val request = SetAutosaveSettings(scope, settings)
    val requestJson = tdJson.encodeToString(SetAutosaveSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Clears the list of all autosave settings exceptions. The method is guaranteed to work only after at least one call to getAutosaveSettings
 */
suspend fun TdKtxClient.clearAutosaveSettingsExceptions(
): Ok {
    val request = ClearAutosaveSettingsExceptions()
    val requestJson = tdJson.encodeToString(ClearAutosaveSettingsExceptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes web browser settings
 * @param openExternalBrowser Pass true if links must be opened in an external browser by default
 * @param displayCloseButton Pass true if a close button must be shown in the in-app browser; for Android app only
 */
suspend fun TdKtxClient.changeWebBrowserSettings(
    openExternalBrowser: Boolean,
    displayCloseButton: Boolean,
): Ok {
    val request = ChangeWebBrowserSettings(openExternalBrowser, displayCloseButton)
    val requestJson = tdJson.encodeToString(ChangeWebBrowserSettings.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Adds a special handling for the opening of the specified URL
 * @param openExternalBrowser Pass true if the specified website must be opened in an external browser; pass false to open it in the in-app browser. There can be at most 100 exceptions in each list of the exceptions
 * @param url URL of the website
 */
suspend fun TdKtxClient.addWebBrowserSettingsException(
    openExternalBrowser: Boolean,
    url: String? = null,
): Ok {
    val request = AddWebBrowserSettingsException(openExternalBrowser, url)
    val requestJson = tdJson.encodeToString(AddWebBrowserSettingsException.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a special handling for the opening of the specified URL @url URL of the website
 */
suspend fun TdKtxClient.removeWebBrowserSettingsException(
    url: String? = null,
): Ok {
    val request = RemoveWebBrowserSettingsException(url)
    val requestJson = tdJson.encodeToString(RemoveWebBrowserSettingsException.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes special handling for the opening of all links
 */
suspend fun TdKtxClient.removeAllWebBrowserSettingsExceptions(
): Ok {
    val request = RemoveAllWebBrowserSettingsExceptions()
    val requestJson = tdJson.encodeToString(RemoveAllWebBrowserSettingsExceptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a bank card @bank_card_number The bank card number
 */
suspend fun TdKtxClient.getBankCardInfo(
    bankCardNumber: String? = null,
): BankCardInfo {
    val request = GetBankCardInfo(bankCardNumber)
    val requestJson = tdJson.encodeToString(GetBankCardInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BankCardInfo.serializer(), responseJson)
}

/**
 * Returns one of the available Telegram Passport elements @type Telegram Passport element type @password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getPassportElement(
    type: PassportElementType? = null,
    password: String? = null,
): PassportElement {
    val request = GetPassportElement(type, password)
    val requestJson = tdJson.encodeToString(GetPassportElement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PassportElement.serializer(), responseJson)
}

/**
 * Returns all available Telegram Passport elements @password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getAllPassportElements(
    password: String? = null,
): PassportElements {
    val request = GetAllPassportElements(password)
    val requestJson = tdJson.encodeToString(GetAllPassportElements.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PassportElements.serializer(), responseJson)
}

/**
 * Adds an element to the user's Telegram Passport. May return an error with a message "PHONE_VERIFICATION_NEEDED" or "EMAIL_VERIFICATION_NEEDED" if the chosen phone number or the chosen email address must be verified first
 * @param element Input Telegram Passport element
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.setPassportElement(
    element: InputPassportElement? = null,
    password: String? = null,
): PassportElement {
    val request = SetPassportElement(element, password)
    val requestJson = tdJson.encodeToString(SetPassportElement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PassportElement.serializer(), responseJson)
}

/**
 * Deletes a Telegram Passport element @type Element type
 */
suspend fun TdKtxClient.deletePassportElement(
    type: PassportElementType? = null,
): Ok {
    val request = DeletePassportElement(type)
    val requestJson = tdJson.encodeToString(DeletePassportElement.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs the user that some of the elements in their Telegram Passport contain errors; for bots only. The user will not be able to resend the elements, until the errors are fixed @user_id User identifier @errors The errors
 */
suspend fun TdKtxClient.setPassportElementErrors(
    userId: Long,
    errors: List<InputPassportElementError>? = null,
): Ok {
    val request = SetPassportElementErrors(userId, errors)
    val requestJson = tdJson.encodeToString(SetPassportElementErrors.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns an IETF language tag of the language preferred in the country, which must be used to fill native fields in Telegram Passport personal details. Returns a 404 error if unknown @country_code A two-letter ISO 3166-1 alpha-2 country code
 */
suspend fun TdKtxClient.getPreferredCountryLanguage(
    countryCode: String? = null,
): Text {
    val request = GetPreferredCountryLanguage(countryCode)
    val requestJson = tdJson.encodeToString(GetPreferredCountryLanguage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Sends a code to verify an email address to be added to a user's Telegram Passport @email_address Email address
 */
suspend fun TdKtxClient.sendEmailAddressVerificationCode(
    emailAddress: String? = null,
): EmailAddressAuthenticationCodeInfo {
    val request = SendEmailAddressVerificationCode(emailAddress)
    val requestJson = tdJson.encodeToString(SendEmailAddressVerificationCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmailAddressAuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Resends the code to verify an email address to be added to a user's Telegram Passport
 */
suspend fun TdKtxClient.resendEmailAddressVerificationCode(
): EmailAddressAuthenticationCodeInfo {
    val request = ResendEmailAddressVerificationCode()
    val requestJson = tdJson.encodeToString(ResendEmailAddressVerificationCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(EmailAddressAuthenticationCodeInfo.serializer(), responseJson)
}

/**
 * Checks the email address verification code for Telegram Passport @code Verification code to check
 */
suspend fun TdKtxClient.checkEmailAddressVerificationCode(
    code: String? = null,
): Ok {
    val request = CheckEmailAddressVerificationCode(code)
    val requestJson = tdJson.encodeToString(CheckEmailAddressVerificationCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns a Telegram Passport authorization form for sharing data with a service
 * @param botUserId User identifier of the service's bot
 * @param scope Telegram Passport element types requested by the service
 * @param publicKey Service's public key
 * @param nonce Unique request identifier provided by the service
 */
suspend fun TdKtxClient.getPassportAuthorizationForm(
    botUserId: Long,
    scope: String? = null,
    publicKey: String? = null,
    nonce: String? = null,
): PassportAuthorizationForm {
    val request = GetPassportAuthorizationForm(botUserId, scope, publicKey, nonce)
    val requestJson = tdJson.encodeToString(GetPassportAuthorizationForm.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PassportAuthorizationForm.serializer(), responseJson)
}

/**
 * Returns already available Telegram Passport elements suitable for completing a Telegram Passport authorization form. Result can be received only once for each authorization form
 * @param authorizationFormId Authorization form identifier
 * @param password The 2-step verification password of the current user
 */
suspend fun TdKtxClient.getPassportAuthorizationFormAvailableElements(
    authorizationFormId: Int,
    password: String? = null,
): PassportElementsWithErrors {
    val request = GetPassportAuthorizationFormAvailableElements(authorizationFormId, password)
    val requestJson = tdJson.encodeToString(GetPassportAuthorizationFormAvailableElements.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PassportElementsWithErrors.serializer(), responseJson)
}

/**
 * Sends a Telegram Passport authorization form, effectively sharing data with the service. This method must be called after getPassportAuthorizationFormAvailableElements if some previously available elements are going to be reused
 * @param authorizationFormId Authorization form identifier
 * @param types Types of Telegram Passport elements chosen by user to complete the authorization form
 */
suspend fun TdKtxClient.sendPassportAuthorizationForm(
    authorizationFormId: Int,
    types: List<PassportElementType>? = null,
): Ok {
    val request = SendPassportAuthorizationForm(authorizationFormId, types)
    val requestJson = tdJson.encodeToString(SendPassportAuthorizationForm.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs the server about the number of pending bot updates if they haven't been processed for a long time; for bots only @pending_update_count The number of pending updates @error_message The last error message
 */
suspend fun TdKtxClient.setBotUpdatesStatus(
    pendingUpdateCount: Int,
    errorMessage: String? = null,
): Ok {
    val request = SetBotUpdatesStatus(pendingUpdateCount, errorMessage)
    val requestJson = tdJson.encodeToString(SetBotUpdatesStatus.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Uploads a file with a sticker; returns the uploaded file
 * @param userId Sticker file owner; ignored for regular users
 * @param stickerFormat Sticker format
 * @param sticker File to upload; must fit in a 512x512 square. For WEBP stickers the file must be in WEBP or PNG format, which will be converted to WEBP server-side. See https://core.telegram.org/animated_stickers#technical-requirements for technical requirements
 */
suspend fun TdKtxClient.uploadStickerFile(
    userId: Long,
    stickerFormat: StickerFormat? = null,
    sticker: InputFile? = null,
): File {
    val request = UploadStickerFile(userId, stickerFormat, sticker)
    val requestJson = tdJson.encodeToString(UploadStickerFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Returns a suggested name for a new sticker set with a given title @title Sticker set title; 1-64 characters
 */
suspend fun TdKtxClient.getSuggestedStickerSetName(
    title: String? = null,
): Text {
    val request = GetSuggestedStickerSetName(title)
    val requestJson = tdJson.encodeToString(GetSuggestedStickerSetName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Checks whether a name can be used for a new sticker set @name Name to be checked
 */
suspend fun TdKtxClient.checkStickerSetName(
    name: String? = null,
): CheckStickerSetNameResult {
    val request = CheckStickerSetName(name)
    val requestJson = tdJson.encodeToString(CheckStickerSetName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CheckStickerSetNameResult.serializer(), responseJson)
}

/**
 * Creates a new sticker set. Returns the newly created sticker set
 * @param userId Sticker set owner; ignored for regular users
 * @param title Sticker set title; 1-64 characters
 * @param name Sticker set name. Can contain only English letters, digits and underscores. Must end with *"_by_<bot username>"* (*<bot_username>* is case insensitive) for bots; 0-64 characters. If empty, then the name returned by getSuggestedStickerSetName will be used automatically
 * @param stickerType Type of the stickers in the set
 * @param needsRepainting Pass true if stickers in the sticker set must be repainted; for custom emoji sticker sets only
 * @param stickers List of stickers to be added to the set; 1-200 stickers for custom emoji sticker sets, and 1-120 stickers otherwise. For TGS stickers, uploadStickerFile must be used before the sticker is shown
 * @param source Source of the sticker set; may be empty if unknown
 */
suspend fun TdKtxClient.createNewStickerSet(
    userId: Long,
    title: String? = null,
    name: String? = null,
    stickerType: StickerType? = null,
    needsRepainting: Boolean,
    stickers: List<InputSticker>? = null,
    source: String? = null,
): StickerSet {
    val request = CreateNewStickerSet(userId, title, name, stickerType, needsRepainting, stickers, source)
    val requestJson = tdJson.encodeToString(CreateNewStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSet.serializer(), responseJson)
}

/**
 * Adds a new sticker to a set
 * @param userId Sticker set owner; ignored for regular users
 * @param name Sticker set name. The sticker set must be owned by the current user, and contain less than 200 stickers for custom emoji sticker sets and less than 120 otherwise
 * @param sticker Sticker to add to the set
 */
suspend fun TdKtxClient.addStickerToSet(
    userId: Long,
    name: String? = null,
    sticker: InputSticker? = null,
): Ok {
    val request = AddStickerToSet(userId, name, sticker)
    val requestJson = tdJson.encodeToString(AddStickerToSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Replaces existing sticker in a set. The function is equivalent to removeStickerFromSet, then addStickerToSet, then setStickerPositionInSet
 * @param userId Sticker set owner; ignored for regular users
 * @param name Sticker set name. The sticker set must be owned by the current user
 * @param oldSticker Sticker to remove from the set
 * @param newSticker Sticker to add to the set
 */
suspend fun TdKtxClient.replaceStickerInSet(
    userId: Long,
    name: String? = null,
    oldSticker: InputFile? = null,
    newSticker: InputSticker? = null,
): Ok {
    val request = ReplaceStickerInSet(userId, name, oldSticker, newSticker)
    val requestJson = tdJson.encodeToString(ReplaceStickerInSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets a sticker set thumbnail
 * @param userId Sticker set owner; ignored for regular users
 * @param name Sticker set name. The sticker set must be owned by the current user
 * @param thumbnail Thumbnail to set; pass null to remove the sticker set thumbnail
 * @param format Format of the thumbnail; pass null if thumbnail is removed
 */
suspend fun TdKtxClient.setStickerSetThumbnail(
    userId: Long,
    name: String? = null,
    thumbnail: InputFile? = null,
    format: StickerFormat? = null,
): Ok {
    val request = SetStickerSetThumbnail(userId, name, thumbnail, format)
    val requestJson = tdJson.encodeToString(SetStickerSetThumbnail.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets a custom emoji sticker set thumbnail
 * @param name Sticker set name. The sticker set must be owned by the current user
 * @param customEmojiId Identifier of the custom emoji from the sticker set, which will be set as sticker set thumbnail; pass 0 to remove the sticker set thumbnail
 */
suspend fun TdKtxClient.setCustomEmojiStickerSetThumbnail(
    name: String? = null,
    customEmojiId: Long,
): Ok {
    val request = SetCustomEmojiStickerSetThumbnail(name, customEmojiId)
    val requestJson = tdJson.encodeToString(SetCustomEmojiStickerSetThumbnail.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sets a sticker set title @name Sticker set name. The sticker set must be owned by the current user @title New sticker set title
 */
suspend fun TdKtxClient.setStickerSetTitle(
    name: String? = null,
    title: String? = null,
): Ok {
    val request = SetStickerSetTitle(name, title)
    val requestJson = tdJson.encodeToString(SetStickerSetTitle.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Completely deletes a sticker set @name Sticker set name. The sticker set must be owned by the current user
 */
suspend fun TdKtxClient.deleteStickerSet(
    name: String? = null,
): Ok {
    val request = DeleteStickerSet(name)
    val requestJson = tdJson.encodeToString(DeleteStickerSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the position of a sticker in the set to which it belongs. The sticker set must be owned by the current user
 * @param sticker Sticker
 * @param position New position of the sticker in the set, 0-based
 */
suspend fun TdKtxClient.setStickerPositionInSet(
    sticker: InputFile? = null,
    position: Int,
): Ok {
    val request = SetStickerPositionInSet(sticker, position)
    val requestJson = tdJson.encodeToString(SetStickerPositionInSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a sticker from the set to which it belongs. The sticker set must be owned by the current user @sticker Sticker to remove from the set
 */
suspend fun TdKtxClient.removeStickerFromSet(
    sticker: InputFile? = null,
): Ok {
    val request = RemoveStickerFromSet(sticker)
    val requestJson = tdJson.encodeToString(RemoveStickerFromSet.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the list of emojis corresponding to a sticker. The sticker must belong to a regular or custom emoji sticker set that is owned by the current user
 * @param sticker Sticker
 * @param emojis New string with 1-20 emoji corresponding to the sticker
 */
suspend fun TdKtxClient.setStickerEmojis(
    sticker: InputFile? = null,
    emojis: String? = null,
): Ok {
    val request = SetStickerEmojis(sticker, emojis)
    val requestJson = tdJson.encodeToString(SetStickerEmojis.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the list of keywords of a sticker. The sticker must belong to a regular or custom emoji sticker set that is owned by the current user
 * @param sticker Sticker
 * @param keywords List of up to 20 keywords with total length up to 64 characters, which can be used to find the sticker
 */
suspend fun TdKtxClient.setStickerKeywords(
    sticker: InputFile? = null,
    keywords: List<String>? = null,
): Ok {
    val request = SetStickerKeywords(sticker, keywords)
    val requestJson = tdJson.encodeToString(SetStickerKeywords.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes the mask position of a mask sticker. The sticker must belong to a mask sticker set that is owned by the current user
 * @param sticker Sticker
 * @param maskPosition Position where the mask is placed; pass null to remove mask position
 */
suspend fun TdKtxClient.setStickerMaskPosition(
    sticker: InputFile? = null,
    maskPosition: MaskPosition? = null,
): Ok {
    val request = SetStickerMaskPosition(sticker, maskPosition)
    val requestJson = tdJson.encodeToString(SetStickerMaskPosition.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns sticker sets owned by the current user
 * @param offsetStickerSetId Identifier of the sticker set from which to return owned sticker sets; use 0 to get results from the beginning
 * @param limit The maximum number of sticker sets to be returned; must be positive and can't be greater than 100. For optimal performance, the number of returned objects is chosen by TDLib and can be smaller than the specified limit
 */
suspend fun TdKtxClient.getOwnedStickerSets(
    offsetStickerSetId: Long,
    limit: Int,
): StickerSets {
    val request = GetOwnedStickerSets(offsetStickerSetId, limit)
    val requestJson = tdJson.encodeToString(GetOwnedStickerSets.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StickerSets.serializer(), responseJson)
}

/**
 * Returns information about a file with a map thumbnail in PNG format. Only map thumbnail files with size less than 1MB can be downloaded
 * @param location Location of the map center
 * @param zoom Map zoom level; 13-20
 * @param width Map width in pixels before applying scale; 16-1024
 * @param height Map height in pixels before applying scale; 16-1024
 * @param scale Map scale; 1-3
 * @param chatId Identifier of a chat in which the thumbnail will be shown. Use 0 if unknown
 */
suspend fun TdKtxClient.getMapThumbnailFile(
    location: Location? = null,
    zoom: Int,
    width: Int,
    height: Int,
    scale: Int,
    chatId: Long,
): File {
    val request = GetMapThumbnailFile(location, zoom, width, height, scale, chatId)
    val requestJson = tdJson.encodeToString(GetMapThumbnailFile.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(File.serializer(), responseJson)
}

/**
 * Returns information about a limit, increased for Premium users. Returns a 404 error if the limit is unknown @limit_type Type of the limit
 */
suspend fun TdKtxClient.getPremiumLimit(
    limitType: PremiumLimitType? = null,
): PremiumLimit {
    val request = GetPremiumLimit(limitType)
    val requestJson = tdJson.encodeToString(GetPremiumLimit.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumLimit.serializer(), responseJson)
}

/**
 * Returns information about features, available to Premium users @source Source of the request; pass null if the method is called from some non-standard source
 */
suspend fun TdKtxClient.getPremiumFeatures(
    source: PremiumSource? = null,
): PremiumFeatures {
    val request = GetPremiumFeatures(source)
    val requestJson = tdJson.encodeToString(GetPremiumFeatures.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumFeatures.serializer(), responseJson)
}

/**
 * Returns examples of premium stickers for demonstration purposes
 */
suspend fun TdKtxClient.getPremiumStickerExamples(
): Stickers {
    val request = GetPremiumStickerExamples()
    val requestJson = tdJson.encodeToString(GetPremiumStickerExamples.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Stickers.serializer(), responseJson)
}

/**
 * Returns the sticker to be used as representation of the Telegram Premium subscription @month_count Number of months the Telegram Premium subscription will be active
 */
suspend fun TdKtxClient.getPremiumInfoSticker(
    monthCount: Int,
): Sticker {
    val request = GetPremiumInfoSticker(monthCount)
    val requestJson = tdJson.encodeToString(GetPremiumInfoSticker.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Sticker.serializer(), responseJson)
}

/**
 * Informs TDLib that the user viewed detailed information about a Premium feature on the Premium features screen @feature The viewed premium feature
 */
suspend fun TdKtxClient.viewPremiumFeature(
    feature: PremiumFeature? = null,
): Ok {
    val request = ViewPremiumFeature(feature)
    val requestJson = tdJson.encodeToString(ViewPremiumFeature.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs TDLib that the user clicked Premium subscription button on the Premium features screen
 */
suspend fun TdKtxClient.clickPremiumSubscriptionButton(
): Ok {
    val request = ClickPremiumSubscriptionButton()
    val requestJson = tdJson.encodeToString(ClickPremiumSubscriptionButton.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns state of Telegram Premium subscription and promotion videos for Premium features
 */
suspend fun TdKtxClient.getPremiumState(
): PremiumState {
    val request = GetPremiumState()
    val requestJson = tdJson.encodeToString(GetPremiumState.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumState.serializer(), responseJson)
}

/**
 * Returns available options for gifting Telegram Premium to a user
 */
suspend fun TdKtxClient.getPremiumGiftPaymentOptions(
): PremiumGiftPaymentOptions {
    val request = GetPremiumGiftPaymentOptions()
    val requestJson = tdJson.encodeToString(GetPremiumGiftPaymentOptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumGiftPaymentOptions.serializer(), responseJson)
}

/**
 * Returns available options for creating of Telegram Premium giveaway or manual distribution of Telegram Premium among chat members
 * @param boostedChatId Identifier of the supergroup or channel chat, which will be automatically boosted by receivers of the gift codes and which is administered by the user
 */
suspend fun TdKtxClient.getPremiumGiveawayPaymentOptions(
    boostedChatId: Long,
): PremiumGiveawayPaymentOptions {
    val request = GetPremiumGiveawayPaymentOptions(boostedChatId)
    val requestJson = tdJson.encodeToString(GetPremiumGiveawayPaymentOptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumGiveawayPaymentOptions.serializer(), responseJson)
}

/**
 * Returns information about a Telegram Premium gift code @code The code to check
 */
suspend fun TdKtxClient.checkPremiumGiftCode(
    code: String? = null,
): PremiumGiftCodeInfo {
    val request = CheckPremiumGiftCode(code)
    val requestJson = tdJson.encodeToString(CheckPremiumGiftCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PremiumGiftCodeInfo.serializer(), responseJson)
}

/**
 * Applies a Telegram Premium gift code @code The code to apply
 */
suspend fun TdKtxClient.applyPremiumGiftCode(
    code: String? = null,
): Ok {
    val request = ApplyPremiumGiftCode(code)
    val requestJson = tdJson.encodeToString(ApplyPremiumGiftCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Allows to buy a Telegram Premium subscription for another user with payment in Telegram Stars; for bots only
 * @param userId Identifier of the user which will receive Telegram Premium
 * @param starCount The number of Telegram Stars to pay for subscription
 * @param monthCount Number of months the Telegram Premium subscription will be active for the user
 * @param text Text to show to the user receiving Telegram Premium; 0-getOption("gift_text_length_max") characters. Only Bold, Italic, Underline, Strikethrough, Spoiler, CustomEmoji, and DateTime entities are allowed
 */
suspend fun TdKtxClient.giftPremiumWithStars(
    userId: Long,
    starCount: Long,
    monthCount: Int,
    text: FormattedText? = null,
): Ok {
    val request = GiftPremiumWithStars(userId, starCount, monthCount, text)
    val requestJson = tdJson.encodeToString(GiftPremiumWithStars.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Launches a prepaid giveaway
 * @param giveawayId Unique identifier of the prepaid giveaway
 * @param parameters Giveaway parameters
 * @param winnerCount The number of users to receive giveaway prize
 * @param starCount The number of Telegram Stars to be distributed through the giveaway; pass 0 for Telegram Premium giveaways
 */
suspend fun TdKtxClient.launchPrepaidGiveaway(
    giveawayId: Long,
    parameters: GiveawayParameters? = null,
    winnerCount: Int,
    starCount: Long,
): Ok {
    val request = LaunchPrepaidGiveaway(giveawayId, parameters, winnerCount, starCount)
    val requestJson = tdJson.encodeToString(LaunchPrepaidGiveaway.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about a giveaway
 * @param chatId Identifier of the channel chat which started the giveaway
 * @param messageId Identifier of the giveaway or a giveaway winners message in the chat
 */
suspend fun TdKtxClient.getGiveawayInfo(
    chatId: Long,
    messageId: Long,
): GiveawayInfo {
    val request = GetGiveawayInfo(chatId, messageId)
    val requestJson = tdJson.encodeToString(GetGiveawayInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(GiveawayInfo.serializer(), responseJson)
}

/**
 * Returns available options for Telegram Stars purchase
 */
suspend fun TdKtxClient.getStarPaymentOptions(
): StarPaymentOptions {
    val request = GetStarPaymentOptions()
    val requestJson = tdJson.encodeToString(GetStarPaymentOptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarPaymentOptions.serializer(), responseJson)
}

/**
 * Returns available options for Telegram Stars gifting @user_id Identifier of the user who will receive Telegram Stars; pass 0 to get options for an unspecified user
 */
suspend fun TdKtxClient.getStarGiftPaymentOptions(
    userId: Long,
): StarPaymentOptions {
    val request = GetStarGiftPaymentOptions(userId)
    val requestJson = tdJson.encodeToString(GetStarGiftPaymentOptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarPaymentOptions.serializer(), responseJson)
}

/**
 * Returns available options for Telegram Star giveaway creation
 */
suspend fun TdKtxClient.getStarGiveawayPaymentOptions(
): StarGiveawayPaymentOptions {
    val request = GetStarGiveawayPaymentOptions()
    val requestJson = tdJson.encodeToString(GetStarGiveawayPaymentOptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarGiveawayPaymentOptions.serializer(), responseJson)
}

/**
 * Returns the list of Telegram Star transactions for the specified owner
 * @param ownerId Identifier of the owner of the Telegram Stars; can be the identifier of the current user, identifier of an owned bot, or identifier of a supergroup or a channel chat with supergroupFullInfo.can_get_star_revenue_statistics == true
 * @param subscriptionId If non-empty, only transactions related to the Star Subscription will be returned
 * @param direction Direction of the transactions to receive; pass null to get all transactions
 * @param offset Offset of the first transaction to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of transactions to return
 */
suspend fun TdKtxClient.getStarTransactions(
    ownerId: MessageSender? = null,
    subscriptionId: String? = null,
    direction: TransactionDirection? = null,
    offset: String? = null,
    limit: Int,
): StarTransactions {
    val request = GetStarTransactions(ownerId, subscriptionId, direction, offset, limit)
    val requestJson = tdJson.encodeToString(GetStarTransactions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarTransactions.serializer(), responseJson)
}

/**
 * Returns the list of Telegram Star subscriptions for the current user
 * @param onlyExpiring Pass true to receive only expiring subscriptions for which there aren't enough Telegram Stars to extend
 * @param offset Offset of the first subscription to return as received from the previous request; use empty string to get the first chunk of results
 */
suspend fun TdKtxClient.getStarSubscriptions(
    onlyExpiring: Boolean,
    offset: String? = null,
): StarSubscriptions {
    val request = GetStarSubscriptions(onlyExpiring, offset)
    val requestJson = tdJson.encodeToString(GetStarSubscriptions.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(StarSubscriptions.serializer(), responseJson)
}

/**
 * Checks whether an in-store purchase is possible. Must be called before any in-store purchase. For official applications only @purpose Transaction purpose
 */
suspend fun TdKtxClient.canPurchaseFromStore(
    purpose: StorePaymentPurpose? = null,
): Ok {
    val request = CanPurchaseFromStore(purpose)
    val requestJson = tdJson.encodeToString(CanPurchaseFromStore.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Informs server about an in-store purchase. For official applications only @transaction Information about the transaction @purpose Transaction purpose
 */
suspend fun TdKtxClient.assignStoreTransaction(
    transaction: StoreTransaction? = null,
    purpose: StorePaymentPurpose? = null,
): Ok {
    val request = AssignStoreTransaction(transaction, purpose)
    val requestJson = tdJson.encodeToString(AssignStoreTransaction.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Cancels or re-enables Telegram Star subscription
 * @param subscriptionId Identifier of the subscription to change
 * @param isCanceled New value of is_canceled
 */
suspend fun TdKtxClient.editStarSubscription(
    subscriptionId: String? = null,
    isCanceled: Boolean,
): Ok {
    val request = EditStarSubscription(subscriptionId, isCanceled)
    val requestJson = tdJson.encodeToString(EditStarSubscription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Cancels or re-enables Telegram Star subscription for a user; for bots only
 * @param userId User identifier
 * @param telegramPaymentChargeId Telegram payment identifier of the subscription
 * @param isCanceled Pass true to cancel the subscription; pass false to allow the user to enable it
 */
suspend fun TdKtxClient.editUserStarSubscription(
    userId: Long,
    telegramPaymentChargeId: String? = null,
    isCanceled: Boolean,
): Ok {
    val request = EditUserStarSubscription(userId, telegramPaymentChargeId, isCanceled)
    val requestJson = tdJson.encodeToString(EditUserStarSubscription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Reuses an active Telegram Star subscription to a channel chat and joins the chat again @subscription_id Identifier of the subscription
 */
suspend fun TdKtxClient.reuseStarSubscription(
    subscriptionId: String? = null,
): Ok {
    val request = ReuseStarSubscription(subscriptionId)
    val requestJson = tdJson.encodeToString(ReuseStarSubscription.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Changes affiliate program for a bot
 * @param chatId Identifier of the chat with an owned bot for which affiliate program is changed
 * @param parameters Parameters of the affiliate program; pass null to close the currently active program. If there is an active program, then commission and program duration can only be increased. If the active program is scheduled to be closed, then it can't be changed anymore
 */
suspend fun TdKtxClient.setChatAffiliateProgram(
    chatId: Long,
    parameters: AffiliateProgramParameters? = null,
): Ok {
    val request = SetChatAffiliateProgram(chatId, parameters)
    val requestJson = tdJson.encodeToString(SetChatAffiliateProgram.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches a chat with an affiliate program. Returns the chat if found and the program is active
 * @param username Username of the chat
 * @param referrer The referrer from an internalLinkTypeChatAffiliateProgram link
 */
suspend fun TdKtxClient.searchChatAffiliateProgram(
    username: String? = null,
    referrer: String? = null,
): Chat {
    val request = SearchChatAffiliateProgram(username, referrer)
    val requestJson = tdJson.encodeToString(SearchChatAffiliateProgram.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Chat.serializer(), responseJson)
}

/**
 * Searches affiliate programs that can be connected to the given affiliate
 * @param affiliate The affiliate for which affiliate programs are searched for
 * @param sortOrder Sort order for the results
 * @param offset Offset of the first affiliate program to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of affiliate programs to return
 */
suspend fun TdKtxClient.searchAffiliatePrograms(
    affiliate: AffiliateType? = null,
    sortOrder: AffiliateProgramSortOrder? = null,
    offset: String? = null,
    limit: Int,
): FoundAffiliatePrograms {
    val request = SearchAffiliatePrograms(affiliate, sortOrder, offset, limit)
    val requestJson = tdJson.encodeToString(SearchAffiliatePrograms.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundAffiliatePrograms.serializer(), responseJson)
}

/**
 * Connects an affiliate program to the given affiliate. Returns information about the connected affiliate program
 * @param affiliate The affiliate to which the affiliate program will be connected
 * @param botUserId Identifier of the bot, which affiliate program is connected
 */
suspend fun TdKtxClient.connectAffiliateProgram(
    affiliate: AffiliateType? = null,
    botUserId: Long,
): ConnectedAffiliateProgram {
    val request = ConnectAffiliateProgram(affiliate, botUserId)
    val requestJson = tdJson.encodeToString(ConnectAffiliateProgram.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ConnectedAffiliateProgram.serializer(), responseJson)
}

/**
 * Disconnects an affiliate program from the given affiliate and immediately deactivates its referral link. Returns updated information about the disconnected affiliate program
 * @param affiliate The affiliate to which the affiliate program is connected
 * @param url The referral link of the affiliate program
 */
suspend fun TdKtxClient.disconnectAffiliateProgram(
    affiliate: AffiliateType? = null,
    url: String? = null,
): ConnectedAffiliateProgram {
    val request = DisconnectAffiliateProgram(affiliate, url)
    val requestJson = tdJson.encodeToString(DisconnectAffiliateProgram.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ConnectedAffiliateProgram.serializer(), responseJson)
}

/**
 * Returns an affiliate program that was connected to the given affiliate by identifier of the bot that created the program
 * @param affiliate The affiliate to which the affiliate program will be connected
 * @param botUserId Identifier of the bot that created the program
 */
suspend fun TdKtxClient.getConnectedAffiliateProgram(
    affiliate: AffiliateType? = null,
    botUserId: Long,
): ConnectedAffiliateProgram {
    val request = GetConnectedAffiliateProgram(affiliate, botUserId)
    val requestJson = tdJson.encodeToString(GetConnectedAffiliateProgram.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ConnectedAffiliateProgram.serializer(), responseJson)
}

/**
 * Returns affiliate programs that were connected to the given affiliate
 * @param affiliate The affiliate to which the affiliate programs were connected
 * @param offset Offset of the first affiliate program to return as received from the previous request; use empty string to get the first chunk of results
 * @param limit The maximum number of affiliate programs to return
 */
suspend fun TdKtxClient.getConnectedAffiliatePrograms(
    affiliate: AffiliateType? = null,
    offset: String? = null,
    limit: Int,
): ConnectedAffiliatePrograms {
    val request = GetConnectedAffiliatePrograms(affiliate, offset, limit)
    val requestJson = tdJson.encodeToString(GetConnectedAffiliatePrograms.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(ConnectedAffiliatePrograms.serializer(), responseJson)
}

/**
 * Returns information about features, available to Business users @source Source of the request; pass null if the method is called from settings or some non-standard source
 */
suspend fun TdKtxClient.getBusinessFeatures(
    source: BusinessFeature? = null,
): BusinessFeatures {
    val request = GetBusinessFeatures(source)
    val requestJson = tdJson.encodeToString(GetBusinessFeatures.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(BusinessFeatures.serializer(), responseJson)
}

/**
 * Accepts Telegram terms of service @terms_of_service_id Terms of service identifier
 */
suspend fun TdKtxClient.acceptTermsOfService(
    termsOfServiceId: String? = null,
): Ok {
    val request = AcceptTermsOfService(termsOfServiceId)
    val requestJson = tdJson.encodeToString(AcceptTermsOfService.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Searches specified query by word prefixes in the provided strings. Returns 0-based positions of strings that matched. Can be called synchronously
 * @param strings The strings to search in for the query
 * @param query Query to search for
 * @param limit The maximum number of objects to return
 * @param returnNoneForEmptyQuery Pass true to receive no results for an empty query
 */
suspend fun TdKtxClient.searchStringsByPrefix(
    strings: List<String>? = null,
    query: String? = null,
    limit: Int,
    returnNoneForEmptyQuery: Boolean,
): FoundPositions {
    val request = SearchStringsByPrefix(strings, query, limit, returnNoneForEmptyQuery)
    val requestJson = tdJson.encodeToString(SearchStringsByPrefix.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(FoundPositions.serializer(), responseJson)
}

/**
 * Sends a custom request; for bots only @method The method name @parameters JSON-serialized method parameters
 */
suspend fun TdKtxClient.sendCustomRequest(
    method: String? = null,
    parameters: String? = null,
): CustomRequestResult {
    val request = SendCustomRequest(method, parameters)
    val requestJson = tdJson.encodeToString(SendCustomRequest.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CustomRequestResult.serializer(), responseJson)
}

/**
 * Answers a custom query; for bots only @custom_query_id Identifier of a custom query @data JSON-serialized answer to the query
 */
suspend fun TdKtxClient.answerCustomQuery(
    customQueryId: Long,
    data: String? = null,
): Ok {
    val request = AnswerCustomQuery(customQueryId, data)
    val requestJson = tdJson.encodeToString(AnswerCustomQuery.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Succeeds after a specified amount of time has passed. Can be called before initialization @seconds Number of seconds before the function returns
 */
suspend fun TdKtxClient.setAlarm(
    seconds: Double,
): Ok {
    val request = SetAlarm(seconds)
    val requestJson = tdJson.encodeToString(SetAlarm.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about existing countries. Can be called before authorization
 */
suspend fun TdKtxClient.getCountries(
): Countries {
    val request = GetCountries()
    val requestJson = tdJson.encodeToString(GetCountries.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Countries.serializer(), responseJson)
}

/**
 * Returns information about an existing country. Can be called before authorization @country_code A two-letter ISO 3166-1 alpha-2 country code
 */
suspend fun TdKtxClient.getCountry(
    countryCode: String? = null,
): CountryInfo {
    val request = GetCountry(countryCode)
    val requestJson = tdJson.encodeToString(GetCountry.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CountryInfo.serializer(), responseJson)
}

/**
 * Uses the current IP address to find the current country. Returns two-letter ISO 3166-1 alpha-2 country code. Can be called before authorization
 */
suspend fun TdKtxClient.getCountryCode(
): Text {
    val request = GetCountryCode()
    val requestJson = tdJson.encodeToString(GetCountryCode.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Returns information about a phone number by its prefix. Can be called before authorization @phone_number_prefix The phone number prefix
 */
suspend fun TdKtxClient.getPhoneNumberInfo(
    phoneNumberPrefix: String? = null,
): PhoneNumberInfo {
    val request = GetPhoneNumberInfo(phoneNumberPrefix)
    val requestJson = tdJson.encodeToString(GetPhoneNumberInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PhoneNumberInfo.serializer(), responseJson)
}

/**
 * Returns information about a phone number by its prefix synchronously. getCountries must be called at least once after changing localization to the specified language if properly localized country information is expected. Can be called synchronously
 * @param languageCode A two-letter ISO 639-1 language code for country information localization
 * @param phoneNumberPrefix The phone number prefix
 */
suspend fun TdKtxClient.getPhoneNumberInfoSync(
    languageCode: String? = null,
    phoneNumberPrefix: String? = null,
): PhoneNumberInfo {
    val request = GetPhoneNumberInfoSync(languageCode, phoneNumberPrefix)
    val requestJson = tdJson.encodeToString(GetPhoneNumberInfoSync.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(PhoneNumberInfo.serializer(), responseJson)
}

/**
 * Returns information about a given collectible item that was purchased at https://fragment.com
 * @param type Type of the collectible item. The item must be used by a user and must be visible to the current user
 */
suspend fun TdKtxClient.getCollectibleItemInfo(
    type: CollectibleItemType? = null,
): CollectibleItemInfo {
    val request = GetCollectibleItemInfo(type)
    val requestJson = tdJson.encodeToString(GetCollectibleItemInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(CollectibleItemInfo.serializer(), responseJson)
}

/**
 * Returns information about a tg:// deep link. Use "tg://need_update_for_some_feature" or "tg:some_unsupported_feature" for testing. Returns a 404 error for unknown links. Can be called before authorization @link The link
 */
suspend fun TdKtxClient.getDeepLinkInfo(
    link: String? = null,
): DeepLinkInfo {
    val request = GetDeepLinkInfo(link)
    val requestJson = tdJson.encodeToString(GetDeepLinkInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(DeepLinkInfo.serializer(), responseJson)
}

/**
 * Returns application config, provided by the server. Can be called before authorization
 */
suspend fun TdKtxClient.getApplicationConfig(
): JsonValue {
    val request = GetApplicationConfig()
    val requestJson = tdJson.encodeToString(GetApplicationConfig.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(JsonValue.serializer(), responseJson)
}

/**
 * Saves application log event on the server. Can be called before authorization @type Event type @chat_id Optional chat identifier, associated with the event @data The log event data
 */
suspend fun TdKtxClient.saveApplicationLogEvent(
    type: String? = null,
    chatId: Long,
    data: JsonValue? = null,
): Ok {
    val request = SaveApplicationLogEvent(type, chatId, data)
    val requestJson = tdJson.encodeToString(SaveApplicationLogEvent.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the link for downloading official Telegram application to be used when the current user invites friends to Telegram
 */
suspend fun TdKtxClient.getApplicationDownloadLink(
): HttpUrl {
    val request = GetApplicationDownloadLink()
    val requestJson = tdJson.encodeToString(GetApplicationDownloadLink.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(HttpUrl.serializer(), responseJson)
}

/**
 * Adds a proxy server for network requests. Can be called before authorization
 * @param proxy The proxy to add
 * @param enable Pass true to immediately enable the proxy
 * @param comment Comment to set for the proxy
 */
suspend fun TdKtxClient.addProxy(
    proxy: Proxy? = null,
    enable: Boolean,
    comment: String? = null,
): AddedProxy {
    val request = AddProxy(proxy, enable, comment)
    val requestJson = tdJson.encodeToString(AddProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AddedProxy.serializer(), responseJson)
}

/**
 * Edits an existing proxy server for network requests. Can be called before authorization
 * @param proxyId Proxy identifier
 * @param proxy The new information about the proxy
 * @param enable Pass true to immediately enable the proxy
 * @param comment New comment for the proxy
 */
suspend fun TdKtxClient.editProxy(
    proxyId: Int,
    proxy: Proxy? = null,
    enable: Boolean,
    comment: String? = null,
): AddedProxy {
    val request = EditProxy(proxyId, proxy, enable, comment)
    val requestJson = tdJson.encodeToString(EditProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AddedProxy.serializer(), responseJson)
}

/**
 * Enables a proxy. Only one proxy can be enabled at a time. Can be called before authorization @proxy_id Proxy identifier
 */
suspend fun TdKtxClient.enableProxy(
    proxyId: Int,
): Ok {
    val request = EnableProxy(proxyId)
    val requestJson = tdJson.encodeToString(EnableProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Disables the currently enabled proxy. Can be called before authorization
 */
suspend fun TdKtxClient.disableProxy(
): Ok {
    val request = DisableProxy()
    val requestJson = tdJson.encodeToString(DisableProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Removes a proxy server. Can be called before authorization @proxy_id Proxy identifier
 */
suspend fun TdKtxClient.removeProxy(
    proxyId: Int,
): Ok {
    val request = RemoveProxy(proxyId)
    val requestJson = tdJson.encodeToString(RemoveProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the list of proxies that are currently set up. Can be called before authorization
 */
suspend fun TdKtxClient.getProxies(
): AddedProxies {
    val request = GetProxies()
    val requestJson = tdJson.encodeToString(GetProxies.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(AddedProxies.serializer(), responseJson)
}

/**
 * Computes time needed to receive a response from a Telegram server through a proxy. Can be called before authorization
 * @param proxy The proxy to test; pass null to ping a Telegram server without a proxy
 */
suspend fun TdKtxClient.pingProxy(
    proxy: Proxy? = null,
): Seconds {
    val request = PingProxy(proxy)
    val requestJson = tdJson.encodeToString(PingProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Seconds.serializer(), responseJson)
}

/**
 * Sets new log stream for internal logging of TDLib. Can be called synchronously @log_stream New log stream
 */
suspend fun TdKtxClient.setLogStream(
    logStream: LogStream? = null,
): Ok {
    val request = SetLogStream(logStream)
    val requestJson = tdJson.encodeToString(SetLogStream.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns information about currently used log stream for internal logging of TDLib. Can be called synchronously
 */
suspend fun TdKtxClient.getLogStream(
): LogStream {
    val request = GetLogStream()
    val requestJson = tdJson.encodeToString(GetLogStream.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LogStream.serializer(), responseJson)
}

/**
 * Sets the verbosity level of the internal logging of TDLib. Can be called synchronously
 * @param newVerbosityLevel New value of the verbosity level for logging. Value 0 corresponds to fatal errors, value 1 corresponds to errors, value 2 corresponds to warnings and debug warnings, value 3 corresponds to informational, value 4 corresponds to debug, value 5 corresponds to verbose debug, value greater than 5 and up to 1023 can be used to enable even more logging
 */
suspend fun TdKtxClient.setLogVerbosityLevel(
    newVerbosityLevel: Int,
): Ok {
    val request = SetLogVerbosityLevel(newVerbosityLevel)
    val requestJson = tdJson.encodeToString(SetLogVerbosityLevel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns current verbosity level of the internal logging of TDLib. Can be called synchronously
 */
suspend fun TdKtxClient.getLogVerbosityLevel(
): LogVerbosityLevel {
    val request = GetLogVerbosityLevel()
    val requestJson = tdJson.encodeToString(GetLogVerbosityLevel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LogVerbosityLevel.serializer(), responseJson)
}

/**
 * Returns the list of available TDLib internal log tags, for example, ["actor", "binlog", "connections", "notifications", "proxy"]. Can be called synchronously
 */
suspend fun TdKtxClient.getLogTags(
): LogTags {
    val request = GetLogTags()
    val requestJson = tdJson.encodeToString(GetLogTags.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LogTags.serializer(), responseJson)
}

/**
 * Sets the verbosity level for a specified TDLib internal log tag. Can be called synchronously
 * @param tag Logging tag to change verbosity level
 * @param newVerbosityLevel New verbosity level; 1-1024
 */
suspend fun TdKtxClient.setLogTagVerbosityLevel(
    tag: String? = null,
    newVerbosityLevel: Int,
): Ok {
    val request = SetLogTagVerbosityLevel(tag, newVerbosityLevel)
    val requestJson = tdJson.encodeToString(SetLogTagVerbosityLevel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns current verbosity level for a specified TDLib internal log tag. Can be called synchronously @tag Logging tag to change verbosity level
 */
suspend fun TdKtxClient.getLogTagVerbosityLevel(
    tag: String? = null,
): LogVerbosityLevel {
    val request = GetLogTagVerbosityLevel(tag)
    val requestJson = tdJson.encodeToString(GetLogTagVerbosityLevel.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(LogVerbosityLevel.serializer(), responseJson)
}

/**
 * Adds a message to TDLib internal log. Can be called synchronously
 * @param verbosityLevel The minimum verbosity level needed for the message to be logged; 0-1023
 * @param text Text of a message to log
 */
suspend fun TdKtxClient.addLogMessage(
    verbosityLevel: Int,
    text: String? = null,
): Ok {
    val request = AddLogMessage(verbosityLevel, text)
    val requestJson = tdJson.encodeToString(AddLogMessage.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns support information for the given user; for Telegram support only @user_id User identifier
 */
suspend fun TdKtxClient.getUserSupportInfo(
    userId: Long,
): UserSupportInfo {
    val request = GetUserSupportInfo(userId)
    val requestJson = tdJson.encodeToString(GetUserSupportInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UserSupportInfo.serializer(), responseJson)
}

/**
 * Sets support information for the given user; for Telegram support only @user_id User identifier @message New information message
 */
suspend fun TdKtxClient.setUserSupportInfo(
    userId: Long,
    message: FormattedText? = null,
): UserSupportInfo {
    val request = SetUserSupportInfo(userId, message)
    val requestJson = tdJson.encodeToString(SetUserSupportInfo.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(UserSupportInfo.serializer(), responseJson)
}

/**
 * Returns localized name of the Telegram support user; for Telegram support only
 */
suspend fun TdKtxClient.getSupportName(
): Text {
    val request = GetSupportName()
    val requestJson = tdJson.encodeToString(GetSupportName.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Text.serializer(), responseJson)
}

/**
 * Does nothing; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TdKtxClient.testCallEmpty(
): Ok {
    val request = TestCallEmpty()
    val requestJson = tdJson.encodeToString(TestCallEmpty.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Returns the received string; for testing only. This is an offline method. Can be called before authorization @x String to return
 */
suspend fun TdKtxClient.testCallString(
    x: String? = null,
): TestString {
    val request = TestCallString(x)
    val requestJson = tdJson.encodeToString(TestCallString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestString.serializer(), responseJson)
}

/**
 * Returns the received bytes; for testing only. This is an offline method. Can be called before authorization @x Bytes to return
 */
suspend fun TdKtxClient.testCallBytes(
    x: String? = null,
): TestBytes {
    val request = TestCallBytes(x)
    val requestJson = tdJson.encodeToString(TestCallBytes.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestBytes.serializer(), responseJson)
}

/**
 * Returns the received vector of numbers; for testing only. This is an offline method. Can be called before authorization @x Vector of numbers to return
 */
suspend fun TdKtxClient.testCallVectorInt(
    x: List<Int>? = null,
): TestVectorInt {
    val request = TestCallVectorInt(x)
    val requestJson = tdJson.encodeToString(TestCallVectorInt.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestVectorInt.serializer(), responseJson)
}

/**
 * Returns the received vector of objects containing a number; for testing only. This is an offline method. Can be called before authorization @x Vector of objects to return
 */
suspend fun TdKtxClient.testCallVectorIntObject(
    x: List<TestInt>? = null,
): TestVectorIntObject {
    val request = TestCallVectorIntObject(x)
    val requestJson = tdJson.encodeToString(TestCallVectorIntObject.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestVectorIntObject.serializer(), responseJson)
}

/**
 * Returns the received vector of strings; for testing only. This is an offline method. Can be called before authorization @x Vector of strings to return
 */
suspend fun TdKtxClient.testCallVectorString(
    x: List<String>? = null,
): TestVectorString {
    val request = TestCallVectorString(x)
    val requestJson = tdJson.encodeToString(TestCallVectorString.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestVectorString.serializer(), responseJson)
}

/**
 * Returns the received vector of objects containing a string; for testing only. This is an offline method. Can be called before authorization @x Vector of objects to return
 */
suspend fun TdKtxClient.testCallVectorStringObject(
    x: List<TestString>? = null,
): TestVectorStringObject {
    val request = TestCallVectorStringObject(x)
    val requestJson = tdJson.encodeToString(TestCallVectorStringObject.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestVectorStringObject.serializer(), responseJson)
}

/**
 * Returns the squared received number; for testing only. This is an offline method. Can be called before authorization @x Number to square
 */
suspend fun TdKtxClient.testSquareInt(
    x: Int,
): TestInt {
    val request = TestSquareInt(x)
    val requestJson = tdJson.encodeToString(TestSquareInt.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(TestInt.serializer(), responseJson)
}

/**
 * Sends a simple network request to the Telegram servers; for testing only. Can be called before authorization
 */
suspend fun TdKtxClient.testNetwork(
): Ok {
    val request = TestNetwork()
    val requestJson = tdJson.encodeToString(TestNetwork.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Sends a simple network request to the Telegram servers via proxy; for testing only. Can be called before authorization
 * @param proxy The proxy to test
 * @param dcId Identifier of a datacenter with which to test connection
 * @param timeout The maximum overall timeout for the request
 */
suspend fun TdKtxClient.testProxy(
    proxy: Proxy? = null,
    dcId: Int,
    timeout: Double,
): Ok {
    val request = TestProxy(proxy, dcId, timeout)
    val requestJson = tdJson.encodeToString(TestProxy.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Forces an updates.getDifference call to the Telegram servers; for testing only
 */
suspend fun TdKtxClient.testGetDifference(
): Ok {
    val request = TestGetDifference()
    val requestJson = tdJson.encodeToString(TestGetDifference.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Ok.serializer(), responseJson)
}

/**
 * Does nothing and ensures that the Update object is used; for testing only. This is an offline method. Can be called before authorization
 */
suspend fun TdKtxClient.testUseUpdate(
): Update {
    val request = TestUseUpdate()
    val requestJson = tdJson.encodeToString(TestUseUpdate.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Update.serializer(), responseJson)
}

/**
 * Returns the specified error and ensures that the Error object is used; for testing only. Can be called synchronously @error The error to be returned
 */
suspend fun TdKtxClient.testReturnError(
    error: Error? = null,
): Error {
    val request = TestReturnError(error)
    val requestJson = tdJson.encodeToString(TestReturnError.serializer(), request)
    val responseJson = this.sendJson(requestJson)
    return tdJson.decodeFromString(Error.serializer(), responseJson)
}

