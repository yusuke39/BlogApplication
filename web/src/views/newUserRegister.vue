<template>
<div>
<user-header></user-header>
<v-card class="register-card">
  <form @submit.prevent="submit"  method="post">
    <v-text-field
      v-model="userName"
      :error-messages="userNameErrors"
      label="ニックネーム"
      required
      @input="$v.userName.$touch()"
      @blur="$v.userName.$touch()"
      class="register-input-form"
      :class="{ error : $v.userName.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      label="メールアドレス"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="register-input-form"
      :class="{ error : $v.email.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="blogName"
      :error-messages="blogNameErrors"
      label="ブログ名"
      required
      @input="$v.blogName.$touch()"
      @blur="$v.blogName.$touch()"
      class="register-input-form"
      :class="{ error : $v.blogName.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="password"
      :error-messages="passwordErrors"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
      :passwordRules="[rules.required, rules.min]"
      :type="show ? 'text' : 'password'"
      label="パスワード"
      required
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
      counter
      @click:append="show = !show"
      class="register-input-form"
      :class="{ error : $v.password.$error,'form-control': true }"
    ></v-text-field>
    <v-text-field
      v-model="confirmPassword"
      :error-messages="confirmPasswordErrors"
      :append-icon="show ? 'mdi-eye' : 'mdi-eye-off'"
      :passwordRules="[rules.required, rules.min]"
      :type="show ? 'text' : 'password'"
      label="パスワード確認"
      required
      @input="$v.confirmPassword.$touch()"
      @blur="$v.confirmPassword.$touch()"
      counter
      @click:append="show = !show"
      class="register-input-form"
      :class="{ error : $v.confirmPassword.$error,'form-control': true }"
    ></v-text-field>

    <button type="submit" class="register-button">新規会員登録する</button>
  </form>
</v-card>
</div>
</template>

<script>
import UserHeader from './userHeader'
import { validationMixin } from 'vuelidate'
import axios from 'axios'
import { required, email, maxLength, minLength, sameAs } from 'vuelidate/lib/validators'

export default {
  mixins: [validationMixin],

  validations: {
    userName: { required },
    email: { required, email },
    blogName: { required },
    password: { required, maxLength: maxLength(40), minLength: minLength(8) },
    confirmPassword: { required, sameAsPassword: sameAs('password'), maxLength: maxLength(40), minLength: minLength(8) }
  },
  data () {
    return {
      userName: '',
      email: '',
      blogName: '',
      password: '',
      show: false,
      confirmPassword: '',
      rules: [
        value => !value || value.size < 2000000 || '写真のサイズは2MB以下でお願いします'
      ],
      passwordRules: {
        required: value => !!value || 'Required.',
        min: v => v.length >= 7 || 'Min 8 characters'
      }
    }
  },
  computed: {
    userNameErrors () {
      const errors = []
      if (!this.$v.userName.$dirty) return errors
      !this.$v.userName.required && errors.push('ニックネームは必ず入力して下さい')
      return errors
    },
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('メールアドレスの形式が不正です')
      !this.$v.email.required && errors.push('メールアドレスは必ず入力して下さい')
      return errors
    },
    blogNameErrors () {
      const errors = []
      if (!this.$v.blogName.$dirty) return errors
      !this.$v.blogName.required && errors.push('ブログ名は必ず入力して下さい')
      return errors
    },
    passwordErrors () {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('パスワードは必ず入力して下さい')
      !this.$v.password.maxLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.password.minLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      return errors
    },
    confirmPasswordErrors () {
      const errors = []
      if (!this.$v.confirmPassword.$dirty) return errors
      !this.$v.confirmPassword.required && errors.push('確認用パスワードは必ず入力して下さい')
      !this.$v.confirmPassword.maxLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.confirmPassword.minLength && errors.push('パスワードは8文字以上40文字以内で入力して下さい')
      !this.$v.confirmPassword.sameAsPassword && errors.push('パスワードは同一にして下さい')
      return errors
    }
  },
  methods: {
    submit () {
      const userInfo = new FormData()
      userInfo.append('userName', this.userName)
      userInfo.append('email', this.email)
      userInfo.append('blogName', this.blogName)
      userInfo.append('password', this.password)
      axios
        .post('http://localhost:8080/registerUser', userInfo)
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  },
  components: {
    UserHeader
  },
  template: '<user-header>'
}
</script>

<style scoped>
.register-card{
    width: 700px;
    margin: auto;
    margin-bottom: 60px;
    margin-top: 60px;
    padding: 20px;
  }

  .register-input-form{
    width: 400px;
    margin: auto;
    margin-top: 50px;
  }

  .register-button{
    margin-top: 50px;
    margin-bottom: 30px;
    margin-left: 130px;
    width: 200px;
    height: 40px;
    background-color: #55C500;
    color: #ffffff;
  }

  .file-label{
    color: rgba(0, 0, 0, 0.6);
  }

  .error {
    color: red;
  }
</style>
