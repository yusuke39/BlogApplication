<template>
  <div>
    <AdminHeader></AdminHeader>
    <el-card class="edit-admin-wrapper">
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
        <UploadUserIcon></UploadUserIcon>
        <BlogMainImage></BlogMainImage>
        <el-button type="success" @click="submit" class="edit-button">編集完了</el-button>
      </form>
    </el-card>
  </div>
</template>

<script>
import AdminHeader from './adminHeader'
import UploadUserIcon from './iconImageUpload'
import BlogMainImage from './blogMainImageUpload'
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
      email: ''
    }
  },
  computed: {
    nameErrors () {
      const errors = []
      if (!this.$v.name.$dirty) return errors
      !this.$v.name.maxLength && errors.push('名前は10文字いないでお願いします')
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
    submit () {
      this.$v.$touch()
    }
  },
  components: {
    AdminHeader,
    UploadUserIcon,
    BlogMainImage
  }
}
</script>

<style>
 .edit-admin-wrapper {
   width: 800px;
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
   margin-left: 230px;
 }

 .edit-admin-input {
   width: 400px;
   margin: 0 auto;
   margin-bottom: 30px;
 }
</style>
