<template>
<div class="icon-file-box">
  <!-- <button v-on:click="upload" style="background-color: blue;">upload</button> -->
  <p class="icon-label">アイコン画像</p>
  <label class="avatar-uploader">
    <input
      type="file"
      @change="onFileChange"
      accept=".jpeg, .png, .jpg"
      class="avatar-uploader-inner"
    >
    <canvas
      ref="canvas"
      class="avatar-uploader-area"
    ></canvas>
    <i :class="{ 'fa-user-alt fas fa-3x' : isShowPeopleIcon }"></i>
  </label>
</div>
</template>

<script>
import firebase from '../plugins/firebaseconfig'
export default {
  data () {
    return {
      iconImage: '',
      uploadImage: '',
      imageUrl: '',
      firebaseImage: '',
      isShowPeopleIcon: true
    }
  },
  methods: {
    onFileChange (e) {
      var file = e.target.files[0]
      this.firebaseImage = e.target.files[0]
      this.uploadImage = e.target.files[0]
      var reader = new FileReader()
      reader.onload = (e) => {
        this.createImage(e.target.result)
      }
      reader.readAsDataURL(file)
      // ファイルアップロード
      var storageRef = firebase.storage().ref(file.name)
      storageRef.put(file).then(() => {
        firebase.storage().ref(file.name).getDownloadURL().then((url) => {
          this.$emit('iconImageUrl', url)
        }).catch(error => {
          console.log(error)
        })
      })
    },
    createImage (file) {
      const image = new Image()
      image.crossOrigin = 'Anonymous'
      image.onload = e => {
        const resizedBase64 = this.makeResizeImg(image)
        const resizeBlob = this.base64ToBlob(resizedBase64)
        const resizeImg = window.URL.createObjectURL(resizeBlob)
        this.iconImage = resizeImg
        this.isShowPeopleIcon = false
      }
      image.src = file
    },
    makeResizeImg (image) {
      const canvas = this.$refs.canvas
      const ctx = canvas.getContext('2d')
      const MAX_SIZE = 1000
      if (image.width < MAX_SIZE && image.height < MAX_SIZE) {
        [canvas.width, canvas.height] = [image.width, image.height]
        ctx.drawImage(image, 0, 0)
        return canvas.toDataURL('image/jpeg')
      }
      let dstWidth
      let dstHeight
      // 縦横比の計算
      if (image.width > image.height) {
        dstWidth = MAX_SIZE
        dstHeight = (image.height * MAX_SIZE) / image.width
      } else {
        dstHeight = MAX_SIZE
        dstWidth = (image.width * MAX_SIZE) / image.height
      }
      canvas.width = dstWidth
      canvas.height = dstHeight
      // リサイズ
      ctx.drawImage(image, 0, 0, image.width, image.height, 0, 0, dstWidth, dstHeight)

      // data_url形式に変換したものを返す
      return canvas.toDataURL('image/jpeg')
    },
    base64ToBlob (base64) {
      const bin = atob(base64.replace(/^.*,/, ''))
      const buffer = new Uint8Array(bin.length)
      for (let i = 0; i < bin.length; i++) {
        buffer[i] = bin.charCodeAt(i)
      }
      return new Blob([buffer.buffer], {
        type: 'image/png'
      })
    },
    created () {
      this.$parent.message = this.firebaseImgUrl
    }
  }
}
</script>

<style scoped>
 .icon-file-box {
  text-align: center;
  height: 160px;
  margin-bottom: 30px;
 }

 .avatar-uploader > input {
   display: none;
 }

 .fa-user-alt {
   position: relative;
   top: -90px;
 }

 .avatar-uploader-area {
   display: block;
   width: 130px;
   height: 130px;
   margin: 0 auto;
   border-radius: 100%;
   background-color: #c4c4c4;
 }

 .icon-label {
   color: rgba(0, 0, 0, 0.6);
 }
</style>
