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
        <el-upload
          class="avatar-uploader"
          action="https://jsonplaceholder.typicode.com/posts/"
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload">
          <img v-if="imageUrl" :src="imageUrl" class="avatar">
          <i v-else class="fas fa-user avatar-uploader-icon"></i>
        </el-upload>
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
      imageUrl: ''
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
    handleAvatarSuccess (res, file) {
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    beforeAvatarUpload (file) {
      const isJPG = file.type === 'image/jpeg'
      if (!isJPG) {
        this.$message.error('写真は.JPGの拡張子を選択してください!')
      }
      return isJPG
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

 .avatar-uploader .el-upload {
  border: 1px dashed #d9d9d9;
  border-radius: 6px;
  cursor: pointer;
  position: relative;
  overflow: hidden;
  border-radius: 100%;
}
.avatar-uploader .el-upload:hover {
  border-color: #409EFF;
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
