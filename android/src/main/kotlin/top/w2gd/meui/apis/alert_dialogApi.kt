// Autogenerated from Pigeon (v7.0.0), do not edit directly.
// See also: https://pub.dev/packages/pigeon


import android.util.Log
import io.flutter.plugin.common.BasicMessageChannel
import io.flutter.plugin.common.BinaryMessenger
import io.flutter.plugin.common.MessageCodec
import io.flutter.plugin.common.StandardMessageCodec
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

private fun wrapResult(result: Any?): List<Any?> {
  return listOf(result)
}

private fun wrapError(exception: Throwable): List<Any> {
  return listOf<Any>(
    exception.javaClass.simpleName,
    exception.toString(),
    "Cause: " + exception.cause + ", Stacktrace: " + Log.getStackTraceString(exception)
  )
}

/** Generated class from Pigeon that represents data sent in messages. */
data class AlertDialogConfig (
  /** 对话框标题 */
  val title: String? = null,
  /** 对话框内容 */
  val content: String? = null,
  /** 确认按钮文案 */
  val confirmText: String? = null,
  /** 取消按钮文案 */
  val cancelText: String? = null

) {
  companion object {
    @Suppress("UNCHECKED_CAST")
    fun fromList(list: List<Any?>): AlertDialogConfig {
      val title = list[0] as? String
      val content = list[1] as? String
      val confirmText = list[2] as? String
      val cancelText = list[3] as? String
      return AlertDialogConfig(title, content, confirmText, cancelText)
    }
  }
  fun toList(): List<Any?> {
    return listOf<Any?>(
      title,
      content,
      confirmText,
      cancelText,
    )
  }
}
/** Generated interface from Pigeon that represents a handler of messages from Flutter. */
interface AlertDialogHostAPI {
  /** 点击确定 */
  fun onClickConfirm()
  /** 点击取消 */
  fun onClickCancel()

  companion object {
    /** The codec used by AlertDialogHostAPI. */
    val codec: MessageCodec<Any?> by lazy {
      StandardMessageCodec()
    }
    /** Sets up an instance of `AlertDialogHostAPI` to handle messages through the `binaryMessenger`. */
    @Suppress("UNCHECKED_CAST")
    fun setUp(binaryMessenger: BinaryMessenger, api: AlertDialogHostAPI?) {
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.AlertDialogHostAPI.onClickConfirm", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped = listOf<Any?>()
            try {
              api.onClickConfirm()
              wrapped = listOf<Any?>(null)
            } catch (exception: Error) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
      run {
        val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.AlertDialogHostAPI.onClickCancel", codec)
        if (api != null) {
          channel.setMessageHandler { _, reply ->
            var wrapped = listOf<Any?>()
            try {
              api.onClickCancel()
              wrapped = listOf<Any?>(null)
            } catch (exception: Error) {
              wrapped = wrapError(exception)
            }
            reply.reply(wrapped)
          }
        } else {
          channel.setMessageHandler(null)
        }
      }
    }
  }
}
@Suppress("UNCHECKED_CAST")
private object AlertDialogFlutterAPICodec : StandardMessageCodec() {
  override fun readValueOfType(type: Byte, buffer: ByteBuffer): Any? {
    return when (type) {
      128.toByte() -> {
        return (readValue(buffer) as? List<Any?>)?.let {
          AlertDialogConfig.fromList(it)
        }
      }
      else -> super.readValueOfType(type, buffer)
    }
  }
  override fun writeValue(stream: ByteArrayOutputStream, value: Any?)   {
    when (value) {
      is AlertDialogConfig -> {
        stream.write(128)
        writeValue(stream, value.toList())
      }
      else -> super.writeValue(stream, value)
    }
  }
}

/** Generated class from Pigeon that represents Flutter messages that can be called from Kotlin. */
@Suppress("UNCHECKED_CAST")
class AlertDialogFlutterAPI(private val binaryMessenger: BinaryMessenger) {
  companion object {
    /** The codec used by AlertDialogFlutterAPI. */
    val codec: MessageCodec<Any?> by lazy {
      AlertDialogFlutterAPICodec
    }
  }
  /** 初始化配置 */
  fun config(configArg: AlertDialogConfig, callback: () -> Unit) {
    val channel = BasicMessageChannel<Any?>(binaryMessenger, "dev.flutter.pigeon.AlertDialogFlutterAPI.config", codec)
    channel.send(listOf(configArg)) {
      callback()
    }
  }
}
