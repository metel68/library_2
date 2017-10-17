Vagrant.configure("2") do |config|
  config.vm.box = "ubuntu/xenial64"
  config.vm.network "forwarded_port", guest: 80, host: 4200
  config.vm.network :forwarded_port, guest: 22, host: 2223, id: 'ssh'
  config.ssh.port = 2223
end
