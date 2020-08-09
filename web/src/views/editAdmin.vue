<template>
  <div>
    <admin-header></admin-header>
    <div class="edit-admin-wrapper">
      <form>
        <v-text-field
          v-model="name"
          :error-messages="nameErrors"
          :counter="10"
          label="ニックネーム"
          prepend-icon="fas fa-user"
          required
          @input="$v.name.$touch()"
          @blur="$v.name.$touch()"
        ></v-text-field>
        <v-file-input
          :rules="rules"
          accept="image/png, image/jpeg, image/bmp"
          placeholder="アイコン(画像を選択してください)"
          prepend-icon="mdi-camera"
          label="アイコン"
          name="iconImage"
          class="register-input-form"
        ></v-file-input>
        <v-text-field
          v-model="email"
          :error-messages="emailErrors"
          label="メールアドレス"
          prepend-icon="fas fa-envelope"
          required
          @input="$v.email.$touch()"
          @blur="$v.email.$touch()"
        ></v-text-field>

        <el-button type="success" @click="submit">編集完了</el-button>
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
      email: ''
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
    submit () {
      this.$v.$touch()
    }
  },
  components: {
    AdminHeader
  },
  template: '<admin-header>'
}
</script>

<style>
 .edit-admin-wrapper {
   width: 500px;
   height: 700px;
   border: solid 1px;
   margin: 100px auto;
 }
</style>
