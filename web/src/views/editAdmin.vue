<template>
  <div>
    <AdminHeader></AdminHeader>
    <div class="edit-admin-wrapper">
      <form>
        <v-text-field
          class="edit-admin-input"
          v-model="name"
          :error-messages="nameErrors"
          :counter="10"
          label="ニックネーム"
          prepend-icon="fas fa-user"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field>
        <div class="icon-file-box">
          <p class="icon-label">アイコン画像</p>
          <label class="avatar-uploader">
            <input
              type="file"
              @change="onFileChange"
              class="avatar-uploader-inner"
            >
            <img
              v-show="iconImage"
              :src="iconImage"
              class="avatar-uploader">
            <i :class="{ 'fa-user-alt fas fa-3x' : isShow }"></i>
          </label>
        </div>
        <v-file-input
          class="edit-admin-input"
          accept="image/png, image/jpeg, image/bmp"
          placeholder="アイコン(画像を選択してください)"
          prepend-icon="mdi-camera"
          label="アイコン"
          name="iconImage"
        ></v-file-input>
        <v-text-field
          class="edit-admin-input"
          v-model="email"
          :error-messages="emailErrors"
          label="メールアドレス"
          prepend-icon="fas fa-envelope"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
        ></v-text-field>

        <el-button type="success" @click="submit" class="edit-button">編集完了</el-button>
      </form>
    </div>
  </div>
</template>

<script>
import AdminHeader from './adminHeader'
import { validationMixin } from 'vuelidate'
import { required, maxLength, email } from 'vuelidate/lib/validators'
export default {
  mixins: [validationMixin],
  validations: {
    name: { required, maxLength: maxLength(10) },
    email: { required, email }
  },
  data () {
    return {
      name: '',
      email: '',
      icon: '',
      iconImage: '',
      isShow: true
    }
  },
  computed: {
    nameErrors () {
      const errors = []
      if (!this.$v.name.$dirty) return errors
      !this.$v.name.maxLength && errors.push('Name must be at most 10 characters long')
      !this.$v.name.required && errors.push('ニックネームは必ず入力して下さい')
      return errors
    },
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('メールアドレスの形式が不正です')
      !this.$v.email.required && errors.push('メールアドレスは必ず入力して下さい')
      return errors
    }
  },
  methods: {
    onFileChange (e) {
      const files = e.target.files || e.dataTransfer.files
      this.createImage(files[0])
      this.iconImage = files[0].name
      this.isShow = false
    },
    createImage (file) {
      const reader = new FileReader()
      reader.onload = e => {
        this.iconImage = e.target.result
      }
      reader.readAsDataURL(file)
    },
    submit () {
      this.$v.$touch()
    }
  },
  components: {
    AdminHeader
  }
}
</script>

<style>
 .edit-admin-wrapper {
   width: 500px;
   margin: 100px auto;
 }

 .icon-img {
   display: none;
 }

 .file-select {
   height: 80px;
   width: 80px;
   border-radius: 100%;
   background-color: gray;
   margin: auto;
 }

 .inner-icon {
   position: relative;
   top: 13px;
   left: 18px;
 }

 .icon-img-label {
   text-decoration: none;
 }

 .edit-button {
   color: #ffffff;
   width: 100px;
   margin-top: 20px;
 }

 .edit-admin-input {
   margin-bottom: 30px;
 }

 .icon-file-box {
   margin: 30px auto;
  text-align: center;
 }

 .avatar-uploader > input {
   display: none;
 }

 .avatar-uploader {
   display: inline-block;
   width: 130px;
   height: 130px;
   border-radius: 100%;
   text-align: center;
   line-height: 140px;
   background-color: #c4c4c4;
 }

 .icon-label {
   color: rgba(0, 0, 0, 0.6);
 }

.avatar-uploader-icon {
  font-size: 28px;
  color: #8c939d;
  width: 100px;
  height: 100px;
  position: relative;
  top: 35px;
  text-align: center;
}
.avatar {
  width: 178px;
  height: 178px;
  display: block;
}
</style>
