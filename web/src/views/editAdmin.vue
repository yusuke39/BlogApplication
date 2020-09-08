<template>
  <div>
    <AdminHeader></AdminHeader>
    <el-card class="edit-admin-wrapper">
      <form method="post">
        <v-text-field
          class="edit-admin-input"
          v-model="name"
          :error-messages="nameErrors"
          :counter="10"
          label="ユーザー名"
          prepend-icon="fas fa-user"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        >{{ name }}</v-text-field>
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
        <v-text-field
          class="edit-admin-input"
          v-model="blogName"
          label="ブログ名"
          prepend-icon="fas fa-clipboard"
          required
          @input="$v.blogName.$touch()"
          @blur="$v.blogName.$touch()"
        >{{ blogName }}</v-text-field>
        <UploadUserIcon @iconImageUrl='getIconImageUrl'></UploadUserIcon>
        <BlogMainImage @blogMainImageUrl="getBlogManinImageUrl"></BlogMainImage>
        <el-button @click="updataUser" type="success" class="edit-button">ユーザー情報編集完了</el-button>
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
import axios from 'axios'
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
      blogName: '',
      iconImageUrl: '',
      blogMainImageUrl: ''
    }
  },
  mounted () {
    const userId = 7
    axios
      .get('http://localhost:8080/user/findUserById?userId=' + userId)
      .then(response => {
        console.log(response)
        this.name = response.data.userName
        this.email = response.data.email
        this.blogName = response.data.blogName
        this.iconImageUrl = response.data.userImg
        this.blogMainImageUrl = response.data.blogImg
      })
      .catch(error => {
        console.log(error)
      })
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
    getIconImageUrl (url) {
      this.iconImageUrl = url
    },
    getBlogManinImageUrl (url) {
      this.blogMainImageUrl = url
    },
    updataUser () {
      const userInfo = new FormData()
      userInfo.append('userId', 7)
      userInfo.append('userName', this.name)
      userInfo.append('email', this.email)
      userInfo.append('blogName', this.blogName)
      userInfo.append('iconImageUrl', this.iconImageUrl)
      userInfo.append('blogMainImageUrl', this.blogMainImageUrl)
      axios
        .post('http://localhost:8080/user/updataUserInfo', userInfo)
        .then(response => {
          this.$router.push('/adminTop')
        })
        .catch(error => {
          console.log(error)
        })
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
   width: 200px;
   margin-top: 20px;
   margin-left: 270px;
 }

 .edit-admin-input {
   width: 400px;
   margin: 0 auto;
   margin-bottom: 30px;
 }
</style>
