// Autogenerated from Pigeon (v7.0.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon

import Foundation
#if os(iOS)
import Flutter
#elseif os(macOS)
import FlutterMacOS
#else
#error("Unsupported platform.")
#endif



private func wrapResult(_ result: Any?) -> [Any?] {
  return [result]
}

private func wrapError(_ error: FlutterError) -> [Any?] {
  return [
    error.code,
    error.message,
    error.details
  ]
}

/// Generated class from Pigeon that represents data sent in messages.
struct AlertDialogConfig {
  /// 对话框标题
  var title: String? = nil
  /// 对话框内容
  var content: String? = nil
  /// 确认按钮文案
  var confirmText: String? = nil
  /// 取消按钮文案
  var cancelText: String? = nil

  static func fromList(_ list: [Any?]) -> AlertDialogConfig? {
    let title = list[0] as? String 
    let content = list[1] as? String 
    let confirmText = list[2] as? String 
    let cancelText = list[3] as? String 

    return AlertDialogConfig(
      title: title,
      content: content,
      confirmText: confirmText,
      cancelText: cancelText
    )
  }
  func toList() -> [Any?] {
    return [
      title,
      content,
      confirmText,
      cancelText,
    ]
  }
}
/// Generated protocol from Pigeon that represents a handler of messages from Flutter.
protocol AlertDialogHostAPI {
  /// 点击确定
  func onClickConfirm()
  /// 点击取消
  func onClickCancel()
}

/// Generated setup class from Pigeon to handle messages through the `binaryMessenger`.
class AlertDialogHostAPISetup {
  /// The codec used by AlertDialogHostAPI.
  /// Sets up an instance of `AlertDialogHostAPI` to handle messages through the `binaryMessenger`.
  static func setUp(binaryMessenger: FlutterBinaryMessenger, api: AlertDialogHostAPI?) {
    /// 点击确定
    let onClickConfirmChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.AlertDialogHostAPI.onClickConfirm", binaryMessenger: binaryMessenger)
    if let api = api {
      onClickConfirmChannel.setMessageHandler { _, reply in
        api.onClickConfirm()
        reply(wrapResult(nil))
      }
    } else {
      onClickConfirmChannel.setMessageHandler(nil)
    }
    /// 点击取消
    let onClickCancelChannel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.AlertDialogHostAPI.onClickCancel", binaryMessenger: binaryMessenger)
    if let api = api {
      onClickCancelChannel.setMessageHandler { _, reply in
        api.onClickCancel()
        reply(wrapResult(nil))
      }
    } else {
      onClickCancelChannel.setMessageHandler(nil)
    }
  }
}
private class AlertDialogFlutterAPICodecReader: FlutterStandardReader {
  override func readValue(ofType type: UInt8) -> Any? {
    switch type {
      case 128:
        return AlertDialogConfig.fromList(self.readValue() as! [Any])      
      default:
        return super.readValue(ofType: type)
      
    }
  }
}
private class AlertDialogFlutterAPICodecWriter: FlutterStandardWriter {
  override func writeValue(_ value: Any) {
    if let value = value as? AlertDialogConfig {
      super.writeByte(128)
      super.writeValue(value.toList())
    } else {
      super.writeValue(value)
    }
  }
}

private class AlertDialogFlutterAPICodecReaderWriter: FlutterStandardReaderWriter {
  override func reader(with data: Data) -> FlutterStandardReader {
    return AlertDialogFlutterAPICodecReader(data: data)
  }

  override func writer(with data: NSMutableData) -> FlutterStandardWriter {
    return AlertDialogFlutterAPICodecWriter(data: data)
  }
}

class AlertDialogFlutterAPICodec: FlutterStandardMessageCodec {
  static let shared = AlertDialogFlutterAPICodec(readerWriter: AlertDialogFlutterAPICodecReaderWriter())
}

/// Generated class from Pigeon that represents Flutter messages that can be called from Swift.
class AlertDialogFlutterAPI {
  private let binaryMessenger: FlutterBinaryMessenger
  init(binaryMessenger: FlutterBinaryMessenger){
    self.binaryMessenger = binaryMessenger
  }
  var codec: FlutterStandardMessageCodec {
    return AlertDialogFlutterAPICodec.shared
  }
  /// 初始化配置
  func config(config configArg: AlertDialogConfig, completion: @escaping () -> Void) {
    let channel = FlutterBasicMessageChannel(name: "dev.flutter.pigeon.AlertDialogFlutterAPI.config", binaryMessenger: binaryMessenger, codec: codec)
    channel.sendMessage([configArg] as [Any?]) { _ in
      completion()
    }
  }
}
