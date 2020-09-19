<template>
<v-card class="login-card">
  <form @submit.prevent="login" method="post">
    <v-text-field
      v-model="email"
      :error-messages="emailErrors"
      label="メールアドレス"
      required
      @input="$v.email.$touch()"
      @blur="$v.email.$touch()"
      class="login-email"
    ></v-text-field>

    <v-text-field
      v-model="password"
      :error-messages="passwordErrors"
      label="パスワード"
      required
      @input="$v.password.$touch()"
      @blur="$v.password.$touch()"
      :append-icon="showPassword ? 'mdi-eye' : 'mdi-eye-off'"
      :type="showPassword ?  'text' : 'password'"
      @click:append="showPassword = !showPassword"
      class="login-password"
    ></v-text-field>

    <div class="v-application">
      <v-btn type="submit" color="success">ログイン</v-btn>
    </div>

  </form>
</v-card>
</template>

<script>
import { validationMixin } from 'vuelidate'
import { required, email } from 'vuelidate/lib/validators'
import axios from 'axios'

export default {
  mixins: [validationMixin],

  validations: {
    email: { required, email },
    password: { required }
  },
  data: () => ({
    password: '',
    email: '',
    showPassword: false
  }),
  computed: {
    passwordErrors () {
      const errors = []
      if (!this.$v.password.$dirty) return errors
      !this.$v.password.required && errors.push('パスワードを入力してください')
      return errors
    },
    emailErrors () {
      const errors = []
      if (!this.$v.email.$dirty) return errors
      !this.$v.email.email && errors.push('メールアドレスの形式で入力してください')
      !this.$v.email.required && errors.push('メールアドレスを入力してください')
      return errors
    }
  },
  methods: {
    login () {
      // const userLoginInfo = new FormData()
      // userLoginInfo.append('email', this.email)
      // userLoginInfo.append('password', this.password)
      // console.log(userLoginInfo + 'この中身何dだー')
      axios
        .post('http://localhost:8080/login', { username: this.email, password: this.password })
        .then(response => {
          console.log(response)
        })
        .catch(error => {
          console.log(error)
        })
    }
  }
}

</script>

<style>
  .login-card{
    width: 500px;
    height: 300px;
    margin: 150px auto;
    padding: 50px;
  }

  .login-password{
    margin-bottom: 30px;
  }

  .login-email{
    margin-bottom: 20px;
  }

</style>
